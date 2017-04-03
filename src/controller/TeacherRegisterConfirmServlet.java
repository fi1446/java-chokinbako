package controller;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

import beans.CategoryTopicBeans;
import beans.CategoryUniqueNameBeans;
import beans.StudentNewInfoBeans;
import beans.TopicIdBeans;
import helper.NameExtractor;

import model.TeacherRegisterModel;

/**
 * Servlet implementation class TeacherRegisterServlet
 */
@WebServlet("/TeacherRegisterConfirmServlet")
public class TeacherRegisterConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherRegisterConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void forwardJSP(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);

		ArrayList<CategoryUniqueNameBeans> catname_list = new ArrayList<>();
		String unique_id = new String();
		unique_id = generateCategoryUniqueId(unique_id);
		String name;
		int length = 4;

		for (int i = 1; i <= length; i++) {
			name = (String) session.getAttribute("category_name_" + i);
			if (String.valueOf(name) == "null" || String.valueOf(name) == "") {
				CategoryUniqueNameBeans u_beans = new CategoryUniqueNameBeans();
				u_beans.setName("");
				catname_list.add(u_beans);
			} else {
				CategoryUniqueNameBeans u_beans = new CategoryUniqueNameBeans();
				u_beans.setName(unique_id + "_" + session.getAttribute("category_name_" + i));
				catname_list.add(u_beans);
			}
		}

		String s_id = request.getParameter("teachers_id");
		int t_id = Integer.valueOf(s_id); //logins_idではなく、teachers_id

		String course_name = (String) session.getAttribute("course_name");
		course_name = String.valueOf(course_name);

		String password = (String) session.getAttribute("password");
		password = String.valueOf(password);

		 //コース登録
		 TeacherRegisterModel.setNewCourse(catname_list, course_name,
		 password, t_id);

		// コースのデータベース上のIDを取得
		int db_course_id = TeacherRegisterModel.sendBackLatestCourseId();

		// トピックをデータベースへ保存
		int catnum = (int) session.getAttribute("categories_num");
		for (int i = 1; i <= catnum; i++) {
			int topicnum = (int) session.getAttribute("topic" + i + "_num");
			for (int j = 1; j <= topicnum; j++) {
				String topic = (String) session.getAttribute("topic" + i + "_" + j);
				TeacherRegisterModel.insertIntoTopicsByCategories(db_course_id, catname_list.get(i - 1).getName(),
						topic);
			}
		}

		// トピックのIDを取る
		ArrayList<ArrayList<TopicIdBeans>> topic_id_list = new ArrayList<>();
		for (int i = 0; i < catnum; i++) {
			topic_id_list.add(TeacherRegisterModel.setTopicIdsByCategories(catname_list.get(i).getName()));
		}
		
		//ログイン情報を保存する
		int s_num = (int) session.getAttribute("student_num");
		for (int i=0; i<s_num; i++) {
			TeacherRegisterModel.createStudentsLogins((String) session.getAttribute("student" + i + "_email"), (String) session.getAttribute("password"), db_course_id);
		}
		
		//ログインIDを取得する
		ArrayList<StudentNewInfoBeans> logins_id_list = new ArrayList<>();
		for (int i = 0; i < s_num; i++) {
			logins_id_list = TeacherRegisterModel.setLoginsIdsByCourseId(db_course_id);
		}
		for (int i = 0; i < s_num; i++) {
			System.out.println(logins_id_list.get(i).getLogins_id());
		}
		
		//View名を作る
		ArrayList<String> checklistsViews_list = new ArrayList<>();
		for (int i=0; i<s_num; i++) {
			checklistsViews_list.add("checklist_" + db_course_id + "_" + logins_id_list.get(i).getLogins_id());
		}
		for (int i=0; i<s_num; i++) {
			System.out.println(checklistsViews_list.get(i));
		}
		
		//checkテーブルにインサートする
		for (int i = 0; i < s_num; i++) {
			for (int j = 0; j < topic_id_list.size(); j++) {
				ArrayList<TopicIdBeans> topic_list = topic_id_list.get(j);
				for (int k = 0; k < topic_list.size(); k++) {
					TeacherRegisterModel.createChecksByStudents(catname_list.get(j), topic_list.get(k),
							(String) session.getAttribute("student" + i + "_email"), db_course_id);
				}
			}
		}

		//Viewを作る
		for (int i = 0; i < s_num; i++) {
			TeacherRegisterModel.createViewsByStudents(checklistsViews_list.get(i) ,(String) session.getAttribute("student" + i + "_email"));
		}
		
		//ようやく生徒が作れるやったー！
		for (int i = 0; i < s_num; i++) {
			TeacherRegisterModel.createStudents((String) session.getAttribute("student" + i + "_email"), (String) session.getAttribute("student" + i + "_name"), db_course_id, logins_id_list.get(i).getLogins_id(), checklistsViews_list.get(i));
		}		

		//先生のコースIDとregisteredもアップデートする
		TeacherRegisterModel.updateTeacherInfo(db_course_id, t_id);

		String jspname = null;
		jspname = "teacher_done.jsp";

		forwardJSP(jspname, request, response);
	}

	private String generateCategoryUniqueId(String unique_id) {
		SecureRandom random;
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
			byte tokenBytes[] = new byte[4];
			random.nextBytes(tokenBytes);
			unique_id = DatatypeConverter.printHexBinary(tokenBytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return unique_id;
	}
}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.ArrayList;

import beans.CategoryTopicBeans;
import beans.StudentNewInfoBeans;

@WebServlet("/TeacherRegisterServlet")
public class TeacherRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeacherRegisterServlet() {
		super();
	}

	private void forwardJSP(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);

		session.setAttribute("course_name", request.getParameter("course_name"));
		session.setAttribute("password", request.getParameter("password"));

		ArrayList<ArrayList<CategoryTopicBeans>> all_topics_list = new ArrayList<>();
		int length = 4;

		for (int i = 1; i <= length; i++) {
			ArrayList<CategoryTopicBeans> topic_list = new ArrayList<>();
			try {
				File f = new File(getServletContext().getRealPath("/csv/sample" + i + ".csv"));
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line;
				while ((line = br.readLine()) != null) {
					String[] data = line.split(",", 0);
					for (String topic : data) {
						CategoryTopicBeans t_beans = new CategoryTopicBeans();
						t_beans.setTopic(topic);
						topic_list.add(t_beans);
					}
				}
				br.close();
			} catch (IOException e) {
				System.out.println(e);
			}
			all_topics_list.add(topic_list);
		}

		ArrayList<StudentNewInfoBeans> student_list = new ArrayList<>();
		try {
			File f = new File(getServletContext().getRealPath("/csv/student.csv"));
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",", 0);
				StudentNewInfoBeans s_beans = new StudentNewInfoBeans();
				s_beans.setName(data[0]);
				s_beans.setEmail(data[1]);
				student_list.add(s_beans);
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}

		for (int i = 0; i < student_list.size(); i++) {
			session.setAttribute("student" + i + "_name", student_list.get(i).getName());
			session.setAttribute("student" + i + "_email", student_list.get(i).getEmail());
		}
		session.setAttribute("student_num", student_list.size());

		for (int i = 0; i < all_topics_list.size(); i++) {
			ArrayList<CategoryTopicBeans> list = new ArrayList<>();
			list = all_topics_list.get(i);
			session.setAttribute("topic" + (i + 1) + "_num", list.size());
			for (int j = 0; j < list.size(); j++) {
				session.setAttribute("topic" + (i + 1) + "_" + (j + 1), list.get(j).getTopic());
			}
		}

		for (int i = 1; i <= length; i++) {
			String name;
			name = request.getParameter("category_name_" + i);
			if (!(name.equals(""))) {
				session.setAttribute("category_name_" + i, request.getParameter("category_name_" + i));
				session.setAttribute("categories_num", i);
			}
		}

		String jspname = null;
		jspname = "teacher_confirm.jsp";

		forwardJSP(jspname, request, response);
	}
}

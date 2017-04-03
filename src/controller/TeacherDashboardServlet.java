package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentLoginModel;
import model.TeacherDashboardModel;
import model.TeacherLoginModel;
import model.StudentDashboardModel;

import beans.TeacherInfoBeans;

/**
 * Servlet implementation class StudentDashboardServlet
 */
@WebServlet("/TeacherDashboardServlet")
public class TeacherDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherDashboardServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String jspname = null;

		if (TeacherLoginModel.login(request.getParameter("teacher_loginid"), request.getParameter("teacher_password"))) {
			session.setAttribute("id", request.getParameter("teacher_loginid"));
			session.setAttribute("password", request.getParameter("teacher_password"));
			
			int teacher_logins_id = TeacherLoginModel.getLoginsId(request.getParameter("teacher_loginid"));
			session.setAttribute("teacher_logins_id", teacher_logins_id);
			
			beans.TeacherInfoBeans teacherInfoBeans = new beans.TeacherInfoBeans();
			teacherInfoBeans = TeacherDashboardModel.getTeacherInfo(teacherInfoBeans, teacher_logins_id);

			session.setAttribute("teacher_name", teacherInfoBeans.getTeacher_name());
			session.setAttribute("teacher_course_id", teacherInfoBeans.getCourses_id());
			session.setAttribute("teacher_id", teacherInfoBeans.getTeachers_id());
			session.setAttribute("teacher_registered", teacherInfoBeans.getRegistered());
			
			beans.TeacherCourseInfoBeans teacherCourseInfoBeans = new beans.TeacherCourseInfoBeans();
			teacherCourseInfoBeans = TeacherDashboardModel.getTeacherCourseInfo(teacherCourseInfoBeans, teacherInfoBeans.getCourses_id(), teacherInfoBeans.getTeachers_id());			
			
			session.setAttribute("teacher_course_name", teacherCourseInfoBeans.getCourse_name());
			session.setAttribute("teacher_category1", teacherCourseInfoBeans.getCategory1());
			session.setAttribute("teacher_category2", teacherCourseInfoBeans.getCategory2());
			session.setAttribute("teacher_category3", teacherCourseInfoBeans.getCategory3());
			session.setAttribute("teacher_category4", teacherCourseInfoBeans.getCategory4());
			session.setAttribute("teacher_course_password", teacherCourseInfoBeans.getCourse_password());
			session.setAttribute("teacher_students_num", teacherCourseInfoBeans.getStudents_num());
			
			ArrayList<String> catname = new ArrayList<>();
			catname.add(teacherCourseInfoBeans.getCategory1());
			catname.add(teacherCourseInfoBeans.getCategory2());
			catname.add(teacherCourseInfoBeans.getCategory3());
			catname.add(teacherCourseInfoBeans.getCategory4());
			
			for(int i=1; i<=4; i++) {
				try {
				if(!(catname.get(i-1).equals("null")) || !(catname.get(i-1).equals(""))) {
					session.setAttribute("teacher_categories_num", i);					
				} else {
					break;
				}
				} catch (NullPointerException e) {}
			}
			
			
			jspname = "teacher_dashboard.jsp";
		} else {
			jspname = "index.jsp";
		}

		forwardJSP(jspname, request, response);
	}

}

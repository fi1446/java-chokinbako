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

import beans.ChecklistBeans;

import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

import model.TeacherDeleteModel;

/**
 * Servlet implementation class TeacherRegisterServlet
 */
@WebServlet("/TeacherDeleteConfirmServlet")
public class TeacherDeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherDeleteConfirmServlet() {
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

		int courses_id = (int) session.getAttribute("teacher_course_id");
		int logins_id = (int) session.getAttribute("teacher_logins_id");
		
		ArrayList<ChecklistBeans> checklist_list = new ArrayList<>();
		checklist_list = TeacherDeleteModel.getAllChecklists(courses_id);
		for(int i=0; i<checklist_list.size(); i++) {
			TeacherDeleteModel.deleteAllChecklists(checklist_list.get(i));
			System.out.println(checklist_list.get(i).getChecklist());
		}

		TeacherDeleteModel.deleteAllInfo(courses_id);
		TeacherDeleteModel.changeTeacherInfoBack(logins_id);
	
		String jspname = null;
		jspname = "teacher_delete_done.jsp";

		forwardJSP(jspname, request, response);
	}
}

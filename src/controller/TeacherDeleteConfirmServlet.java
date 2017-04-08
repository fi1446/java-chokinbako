package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import beans.ChecklistBeans;

import model.TeacherDeleteModel;

@WebServlet("/TeacherDeleteConfirmServlet")
public class TeacherDeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TeacherDeleteConfirmServlet() {
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

		int courses_id = (int) session.getAttribute("teacher_course_id");
		int logins_id = (int) session.getAttribute("teacher_logins_id");

		ArrayList<ChecklistBeans> checklist_list = new ArrayList<>();
		checklist_list = TeacherDeleteModel.getAllChecklists(courses_id);
		for (int i = 0; i < checklist_list.size(); i++) {
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

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

import beans.CategoryCheckBeans;
import beans.CategoryTopicBeans;
import beans.ChecklistBeans;
import beans.StudentInfoBeans;
import beans.MemoBeans;
import model.StudentChecklistModel;
import model.StudentDashboardModel;

/**
 * Servlet implementation class InputServlet
 */
@WebServlet("/StudentChecklistUpdateServlet")
public class StudentChecklistUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentChecklistUpdateServlet() {
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
		HttpSession session = request.getSession(false);

		String length = request.getParameter("length");
		int len = Integer.parseInt(length);

		String category_num = request.getParameter("category_num");
		int catnum = Integer.parseInt(category_num);

		CategoryCheckBeans c_beans = new CategoryCheckBeans();
		MemoBeans m_beans = new MemoBeans();
		CategoryTopicBeans t_beans = new CategoryTopicBeans();
		
		StudentInfoBeans s_beans = new StudentInfoBeans();
		s_beans.setEmail((String) session.getAttribute("email"));
		
		String topic;
		for (int i = 0; i < len; i++) {
			c_beans.setCheck(request.getParameter("check_" + i));
			topic = (String) session.getAttribute("topic" + catnum + "_" + (i+1));
			t_beans.setTopic(topic);
			if (request.getParameter("memo_" + i) == null || request.getParameter("memo_" + i) == "") {
				m_beans.setMemo("");
			} else {
				m_beans.setMemo(request.getParameter("memo_" + i));
			}
			StudentChecklistModel.updateChecklist(s_beans, c_beans, m_beans, t_beans, request.getParameter("category"));
		}

		String jspname = null;
		jspname = "checklist_done.jsp";
		forwardJSP(jspname, request, response);

	}

}

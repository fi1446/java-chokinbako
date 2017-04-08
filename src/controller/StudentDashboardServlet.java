package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentLoginModel;
import model.StudentDashboardModel;

/**
 * Servlet implementation class StudentDashboardServlet
 */
@WebServlet("/StudentDashboardServlet")
public class StudentDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentDashboardServlet() {
		super();
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

		if (StudentLoginModel.login(request.getParameter("email"), request.getParameter("password"))) {
			session.setAttribute("email", request.getParameter("email"));
			session.setAttribute("password", request.getParameter("password"));

			int logins_id = StudentLoginModel.getLoginsId(request.getParameter("email"));
			session.setAttribute("logins_id", logins_id);
			System.out.println("logins_id: " + logins_id);

			beans.StudentInfoBeans studentInfoBeans = new beans.StudentInfoBeans();
			studentInfoBeans = StudentDashboardModel.getStudentInfo(studentInfoBeans, logins_id);

			beans.CategoryNameBeans categoryNameBeans = new beans.CategoryNameBeans();
			categoryNameBeans = StudentDashboardModel.getCategoriesNamesFromCourse(categoryNameBeans, logins_id);

			beans.ChecklistBeans checklistBeans = new beans.ChecklistBeans();
			checklistBeans = StudentDashboardModel.getChecklistName(checklistBeans, logins_id);

			int all_checked = StudentDashboardModel.countAllChecked(checklistBeans);

			int category_all_checked1 = StudentDashboardModel.countAllCheckedByCategories(checklistBeans,
					categoryNameBeans.getCategory1());
			int category_all_checked2 = StudentDashboardModel.countAllCheckedByCategories(checklistBeans,
					categoryNameBeans.getCategory2());
			int category_all_checked3 = StudentDashboardModel.countAllCheckedByCategories(checklistBeans,
					categoryNameBeans.getCategory3());
			int category_all_checked4 = StudentDashboardModel.countAllCheckedByCategories(checklistBeans,
					categoryNameBeans.getCategory4());

			int all_listcheck = StudentDashboardModel.countAllListcheck(checklistBeans);

			int category_all_listcheck1 = StudentDashboardModel.countAllListcheckByCategories(checklistBeans,
					categoryNameBeans.getCategory1());
			int category_all_listcheck2 = StudentDashboardModel.countAllListcheckByCategories(checklistBeans,
					categoryNameBeans.getCategory2());
			int category_all_listcheck3 = StudentDashboardModel.countAllListcheckByCategories(checklistBeans,
					categoryNameBeans.getCategory3());
			int category_all_listcheck4 = StudentDashboardModel.countAllListcheckByCategories(checklistBeans,
					categoryNameBeans.getCategory4());

			session.setAttribute("studentName", studentInfoBeans.getStudent_name());

			session.setAttribute("category1", categoryNameBeans.getCategory1());
			session.setAttribute("category2", categoryNameBeans.getCategory2());
			session.setAttribute("category3", categoryNameBeans.getCategory3());
			session.setAttribute("category4", categoryNameBeans.getCategory4());

			session.setAttribute("checklistName", checklistBeans.getChecklist());

			session.setAttribute("allChecked", all_checked);

			session.setAttribute("categoryAllChecked1", category_all_checked1);
			session.setAttribute("categoryAllChecked2", category_all_checked2);
			session.setAttribute("categoryAllChecked3", category_all_checked3);
			session.setAttribute("categoryAllChecked4", category_all_checked4);

			session.setAttribute("listcheckAll", all_listcheck);

			session.setAttribute("categoryListcheckAll1", category_all_listcheck1);
			session.setAttribute("categoryListcheckAll2", category_all_listcheck2);
			session.setAttribute("categoryListcheckAll3", category_all_listcheck3);
			session.setAttribute("categoryListcheckAll4", category_all_listcheck4);

			jspname = "dashboard.jsp";

		} else if (StudentLoginModel.checkLockedStatus(request.getParameter("email"))) {
			session.setAttribute("failure", true);
			session.setAttribute("reason", "locked");
			jspname = "index.jsp";
		} else {
			session.setAttribute("failure", true);
			session.setAttribute("reason", "noId");
			jspname = "index.jsp";
		}

		forwardJSP(jspname, request, response);
	}

}

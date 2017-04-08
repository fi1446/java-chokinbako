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
import beans.MemoBeans;
import model.StudentChecklistModel;
import model.StudentDashboardModel;

@WebServlet("/StudentChecklistServlet")
public class StudentChecklistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentChecklistServlet() {
		super();
	}

	private void forwardJSP(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);

		beans.CategoryNameBeans categoryNameBeans = new beans.CategoryNameBeans();
		categoryNameBeans = StudentDashboardModel.getCategoriesNamesFromCourse(categoryNameBeans,
				(int) session.getAttribute("logins_id"));

		beans.ChecklistBeans checklistBeans = new beans.ChecklistBeans();
		checklistBeans = StudentDashboardModel.getChecklistName(checklistBeans,
				(int) session.getAttribute("logins_id"));

		int i;

		try {
			ArrayList<CategoryCheckBeans> list1 = new ArrayList<>();
			list1 = StudentChecklistModel.getCheckedByCategories(checklistBeans, categoryNameBeans.getCategory1());
			System.out.println(list1.size());
			if (list1.size() != 0) {
				session.setAttribute("category1", categoryNameBeans.getCategory1());
				session.setAttribute("list1", list1);
				ArrayList<CategoryTopicBeans> topic1 = new ArrayList<>();
				topic1 = StudentChecklistModel.getTopicsByCategories(categoryNameBeans.getCategory1());
				ArrayList<MemoBeans> memos1 = new ArrayList<>();
				memos1 = StudentChecklistModel.getMemoByCategories(checklistBeans, categoryNameBeans.getCategory1());
				for (i = 0; i < list1.size(); i++) {
					CategoryCheckBeans c_beans = list1.get(i);
					if (c_beans.getCheck() == null) {
						session.setAttribute("check1_" + (i + 1), "");
					} else {
						session.setAttribute("check1_" + (i + 1), c_beans.getCheck());
					}
					CategoryTopicBeans t_beans = topic1.get(i);
					session.setAttribute("topic1_" + (i + 1), t_beans.getTopic());
					MemoBeans m_beans = memos1.get(i);
					if (m_beans.getMemo() != null) {
						session.setAttribute("memo1_" + (i + 1), m_beans.getMemo());
					}
				}
			}
		} catch (NullPointerException e) {
		}

		try {
			ArrayList<CategoryCheckBeans> list2 = new ArrayList<>();
			list2 = StudentChecklistModel.getCheckedByCategories(checklistBeans, categoryNameBeans.getCategory2());
			if (list2.size() != 0) {
				session.setAttribute("category2", categoryNameBeans.getCategory2());
				session.setAttribute("list2", list2);
				ArrayList<CategoryTopicBeans> topic2 = new ArrayList<>();
				topic2 = StudentChecklistModel.getTopicsByCategories(categoryNameBeans.getCategory2());
				ArrayList<MemoBeans> memos2 = new ArrayList<>();
				memos2 = StudentChecklistModel.getMemoByCategories(checklistBeans, categoryNameBeans.getCategory2());
				for (i = 0; i < list2.size(); i++) {
					CategoryCheckBeans c_beans = list2.get(i);
					if (c_beans.getCheck() == null) {
						session.setAttribute("check2_" + (i + 1), "");
					} else {
						session.setAttribute("check2_" + (i + 1), c_beans.getCheck());
					}
					CategoryTopicBeans t_beans = topic2.get(i);
					session.setAttribute("topic2_" + (i + 1), t_beans.getTopic());
					MemoBeans m_beans = memos2.get(i);
					if (m_beans.getMemo() != null) {
						session.setAttribute("memo2_" + (i + 1), m_beans.getMemo());
					}
				}
			}
		} catch (NullPointerException e) {
		}

		try {
			ArrayList<CategoryCheckBeans> list3 = new ArrayList<>();
			list3 = StudentChecklistModel.getCheckedByCategories(checklistBeans, categoryNameBeans.getCategory3());
			if (list3.size() != 0) {
				session.setAttribute("category3", categoryNameBeans.getCategory3());
				session.setAttribute("list3", list3);
				ArrayList<CategoryTopicBeans> topic3 = new ArrayList<>();
				topic3 = StudentChecklistModel.getTopicsByCategories(categoryNameBeans.getCategory3());
				ArrayList<MemoBeans> memos3 = new ArrayList<>();
				memos3 = StudentChecklistModel.getMemoByCategories(checklistBeans, categoryNameBeans.getCategory3());
				for (i = 0; i < list3.size(); i++) {
					CategoryCheckBeans c_beans = list3.get(i);
					if (c_beans.getCheck() == null) {
						session.setAttribute("check3_" + (i + 1), "");
					} else {
						session.setAttribute("check3_" + (i + 1), c_beans.getCheck());
					}
					CategoryTopicBeans t_beans = topic3.get(i);
					session.setAttribute("topic3_" + (i + 1), t_beans.getTopic());
					MemoBeans m_beans = memos3.get(i);
					if (m_beans.getMemo() != null) {
						session.setAttribute("memo3_" + (i + 1), m_beans.getMemo());
					}
				}
			}
		} catch (NullPointerException e) {
		}

		try {
			ArrayList<CategoryCheckBeans> list4 = new ArrayList<>();
			list4 = StudentChecklistModel.getCheckedByCategories(checklistBeans, categoryNameBeans.getCategory4());
			if (list4.size() != 0) {
				session.setAttribute("category4", categoryNameBeans.getCategory4());
				session.setAttribute("list4", list4);
				ArrayList<CategoryTopicBeans> topic4 = new ArrayList<>();
				topic4 = StudentChecklistModel.getTopicsByCategories(categoryNameBeans.getCategory4());
				ArrayList<MemoBeans> memos4 = new ArrayList<>();
				memos4 = StudentChecklistModel.getMemoByCategories(checklistBeans, categoryNameBeans.getCategory4());
				for (i = 0; i < list4.size(); i++) {
					CategoryCheckBeans c_beans = list4.get(i);
					if (c_beans.getCheck() == null) {
						session.setAttribute("check4_" + (i + 1), "");
					} else {
						session.setAttribute("check4_" + (i + 1), c_beans.getCheck());
					}
					CategoryTopicBeans t_beans = topic4.get(i);
					session.setAttribute("topic4_" + (i + 1), t_beans.getTopic());
					MemoBeans m_beans = memos4.get(i);
					if (m_beans.getMemo() != null) {
						session.setAttribute("memo4_" + (i + 1), m_beans.getMemo());
					}
				}
			}
		} catch (NullPointerException e) {
		}

		String jspname = null;
		jspname = "checklist.jsp";

		forwardJSP(jspname, request, response);

	}

}

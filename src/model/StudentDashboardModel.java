package model;

import beans.CategoryNameBeans;
import beans.StudentInfoBeans;
import beans.ChecklistBeans;
import dao.StudentDashboardDao;

public class StudentDashboardModel {

	public static StudentInfoBeans getStudentInfo(StudentInfoBeans beans, int logins_id) {
		dao.StudentDashboardDao dao = new StudentDashboardDao();
		beans = dao.selectStudentInfo(logins_id);
		return beans;
	}

	public static CategoryNameBeans getCategoriesNamesFromCourse(CategoryNameBeans beans, int logins_id) {
		dao.StudentDashboardDao dao = new StudentDashboardDao();
		beans = dao.getCategoriesNamesFromCourse(logins_id);
		return beans;
	}

	public static ChecklistBeans getChecklistName(ChecklistBeans beans, int logins_id) {
		dao.StudentDashboardDao dao = new StudentDashboardDao();
		beans = dao.getChecklistName(logins_id);
		return beans;
	}

	public static int countAllChecked(ChecklistBeans beans) {
		dao.StudentDashboardDao dao = new StudentDashboardDao();
		int checked_count = dao.countAllChecked(beans);
		return checked_count;
	}

	public static int countAllCheckedByCategories(ChecklistBeans beans, String category) {
		dao.StudentDashboardDao dao = new StudentDashboardDao();
		int checked_count = dao.countAllCheckedByCategories(beans, category);
		return checked_count;
	}

	public static int countAllListcheck(ChecklistBeans checklistBeans) {
		dao.StudentDashboardDao dao = new StudentDashboardDao();
		int checked_count = dao.countAllListcheck(checklistBeans);
		return checked_count;
	}

	public static int countAllListcheckByCategories(ChecklistBeans checklistBeans, String category) {
		dao.StudentDashboardDao dao = new StudentDashboardDao();
		int checked_count = dao.countAllListcheckByCategories(checklistBeans, category);
		return checked_count;
	}

}

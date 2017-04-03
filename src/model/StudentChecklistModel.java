package model;

import beans.CategoryNameBeans;
import beans.CategoryTopicBeans;
import beans.ChecklistBeans;
import beans.StudentInfoBeans;
import beans.MemoBeans;

import java.util.ArrayList;

import beans.CategoryCheckBeans;
import dao.StudentChecklistDao;

public class StudentChecklistModel {

	public static ArrayList<CategoryCheckBeans> getCheckedByCategories(ChecklistBeans beans, String category) {
		dao.StudentChecklistDao dao = new StudentChecklistDao();
		ArrayList<CategoryCheckBeans> list = dao.getCheckedByCategories(beans, category);
		return list;
	}
	
	public static ArrayList<CategoryTopicBeans> getTopicsByCategories(String category) {
		dao.StudentChecklistDao dao = new StudentChecklistDao();
		ArrayList<CategoryTopicBeans> list = dao.getTopicsByCategories(category);
		return list;
	}
	
	public static ArrayList<MemoBeans> getMemoByCategories(ChecklistBeans beans, String category) {
		dao.StudentChecklistDao dao = new StudentChecklistDao();
		ArrayList<MemoBeans> list = dao.getMemosByCategories(beans, category);
		return list;
	}
	
	public static void updateChecklist(StudentInfoBeans s_beans, CategoryCheckBeans c_beans, MemoBeans m_beans, CategoryTopicBeans t_beans, String category) {
		dao.StudentChecklistDao dao = new StudentChecklistDao();
		dao.updateChecklist(s_beans, c_beans, m_beans, t_beans, category);
		return;
	}

}

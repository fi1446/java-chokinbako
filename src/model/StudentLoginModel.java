package model;

import beans.CategoryNameBeans;
import beans.CategoryTopicBeans;
import beans.ChecklistBeans;
import beans.StudentInfoBeans;
import beans.MemoBeans;

import java.util.ArrayList;

import beans.CategoryCheckBeans;
import dao.StudentChecklistDao;
import dao.StudentLoginDao;

public class StudentLoginModel {

	public static boolean login(String email, String password) {
		StudentLoginDao dao = new StudentLoginDao();
		return dao.login(email, password);
	}

	public static int getLoginsId(String email) {
		StudentLoginDao dao = new StudentLoginDao();
		return dao.getLoginsId(email);
	}

	public static boolean checkLockedStatus(String email) {
		// TODO Auto-generated method stub
		StudentLoginDao dao = new StudentLoginDao();
		return dao.checkLockedStatus(email);
	}

}

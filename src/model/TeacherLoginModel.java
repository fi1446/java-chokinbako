package model;

import beans.CategoryNameBeans;
import beans.CategoryTopicBeans;
import beans.TeacherInfoBeans;

import java.util.ArrayList;

import beans.CategoryCheckBeans;
import dao.StudentChecklistDao;
import dao.StudentLoginDao;
import dao.TeacherLoginDao;
import dao.TeacherRegisterDao;

public class TeacherLoginModel {

	public static boolean login(String id, String password) {
		dao.TeacherLoginDao dao = new TeacherLoginDao();
		return dao.login(id, password);
	}

	public static int getLoginsId(String id) {
		dao.TeacherLoginDao dao = new TeacherLoginDao();
		return dao.getLoginsId(id);
	}

}

package model;

import beans.CategoryNameBeans;
import beans.CategoryTopicBeans;
import beans.ChecklistBeans;
import beans.TeacherInfoBeans;

import java.util.ArrayList;

import beans.CategoryCheckBeans;
import dao.StudentChecklistDao;
import dao.StudentLoginDao;
import dao.TeacherDeleteDao;
import dao.TeacherLoginDao;
import dao.TeacherRegisterDao;

public class TeacherDeleteModel {

	public static void deleteAllInfo(int teacher_course_id) {
		dao.TeacherDeleteDao dao = new TeacherDeleteDao();
		dao.deleteAllInfo(teacher_course_id);
		return;
	}

	public static void changeTeacherInfoBack(int logins_id) {
		dao.TeacherDeleteDao dao = new TeacherDeleteDao();
		dao.changeTeacherInfoBack(logins_id);
		return;
	}

	public static ArrayList<ChecklistBeans> getAllChecklists(int courses_id) {
		dao.TeacherDeleteDao dao = new TeacherDeleteDao();
		ArrayList<ChecklistBeans> list = dao.getAllChecklists(courses_id);
		return list;
	}

	public static void deleteAllChecklists(ChecklistBeans beans) {
		dao.TeacherDeleteDao dao = new TeacherDeleteDao();
		dao.deleteAllChecklists(beans);
		return;
	}
}

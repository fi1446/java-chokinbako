package model;

import beans.CategoryNameBeans;
import beans.CategoryTopicBeans;
import beans.ChecklistBeans;
import beans.StudentInfoBeans;
import beans.StudentNewInfoBeans;
import beans.TopicIdBeans;
import beans.MemoBeans;
import beans.CategoryUniqueNameBeans;

import java.util.ArrayList;

import beans.CategoryCheckBeans;
import dao.TeacherRegisterDao;

public class TeacherRegisterModel {

	public static void setNewCourse(ArrayList<CategoryUniqueNameBeans> list, String course_name, String password,
			int id) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		dao.setNewCourse(list, course_name, password, id);
		return;
	}

	public static int sendBackLatestCourseId() {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		int id = dao.sendBackLatestCourseId();
		return id;
	}

	public static void insertIntoTopicsByCategories(int courses_id, String category_name, String topic) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		dao.insertIntoTopicsByCategories(courses_id, category_name, topic);
		return;
	}

	public static ArrayList<TopicIdBeans> setTopicIdsByCategories(String category) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		ArrayList<TopicIdBeans> list = dao.setTopicIdsByCategories(category);
		return list;
	}

	public static void createStudentsLogins(String email, String password, int courses_id) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		dao.createStudentsLogins(email, password, courses_id);
		return;
	}

	public static ArrayList<StudentNewInfoBeans> setLoginsIdsByCourseId(int db_course_id) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		ArrayList<StudentNewInfoBeans> list = dao.setLoginsIdsByCourseId(db_course_id);
		return list;
	}

	public static void createChecksByStudents(CategoryUniqueNameBeans categoryUniqueNameBeans,
			TopicIdBeans topicIdBeans, String user_info, int courses_id) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		dao.createChecksByStudents(categoryUniqueNameBeans, topicIdBeans, user_info, courses_id);
		return;
	}

	public static void createViewsByStudents(String checklist, String email) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		dao.createViewsByStudents(checklist, email);
		return;
	}

	public static void createStudents(String email, String name, int db_course_id,
			int logins_id, String checklist) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		dao.createStudents(email, name, db_course_id, logins_id, checklist);
		return;
	}

	public static void updateTeacherInfo(int db_course_id, int t_id) {
		dao.TeacherRegisterDao dao = new TeacherRegisterDao();
		dao.updateTeacherInfo(db_course_id, t_id);
		return;
	}
}

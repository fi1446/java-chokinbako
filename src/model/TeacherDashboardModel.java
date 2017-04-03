package model;

import beans.CategoryNameBeans;
import beans.CategoryTopicBeans;
import beans.ChecklistBeans;
import beans.StudentInfoBeans;
import beans.StudentNewInfoBeans;
import beans.TeacherCourseInfoBeans;
import beans.TeacherInfoBeans;
import beans.TopicIdBeans;
import beans.MemoBeans;
import beans.CategoryUniqueNameBeans;

import java.util.ArrayList;

import beans.CategoryCheckBeans;
import dao.TeacherDashboardDao;
import dao.TeacherLoginDao;
import dao.TeacherRegisterDao;

public class TeacherDashboardModel {

	public static TeacherInfoBeans getTeacherInfo(TeacherInfoBeans teacherInfoBeans, int id) {
		dao.TeacherDashboardDao dao = new TeacherDashboardDao();
		teacherInfoBeans = dao.getTeacherInfo(teacherInfoBeans, id);
		return teacherInfoBeans;
	}

	public static TeacherCourseInfoBeans getTeacherCourseInfo(TeacherCourseInfoBeans teacherCourseInfoBeans, int courses_id, int logins_id) {
		dao.TeacherDashboardDao dao = new TeacherDashboardDao();
		teacherCourseInfoBeans =  dao.getTeacherCourseInfo(teacherCourseInfoBeans, courses_id, logins_id);
		return teacherCourseInfoBeans;
	}

}

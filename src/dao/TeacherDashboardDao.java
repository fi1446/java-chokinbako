package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.TeacherCourseInfoBeans;
import beans.TeacherInfoBeans;

public class TeacherDashboardDao extends SuperDao {

	private static String TABLENAME1 = "teachers";
	private static String TABLENAME2 = "students";
	private static String TABLENAME3 = "courses";

	public TeacherInfoBeans getTeacherInfo(TeacherInfoBeans teacherInfoBeans, int logins_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select teachers_id as teachers_id, name as name, courses_id as courses_id, registered as registered from " + TABLENAME1 + " where logins_id = " + logins_id + ";";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				teacherInfoBeans.setTeachers_id(rs.getInt("teachers_id"));
				teacherInfoBeans.setTeacher_name(rs.getString("name"));
				teacherInfoBeans.setCourses_id(rs.getInt("courses_id"));
				teacherInfoBeans.setRegistered(rs.getString("registered"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return teacherInfoBeans;
	}

	public TeacherCourseInfoBeans getTeacherCourseInfo(TeacherCourseInfoBeans teacherCourseInfoBeans, int courses_id,
			int teachers_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select c.name as course_name, c.category1 as category1, c.category2 as category2, c.category3 as category3, c.category4 as category4, c.password as course_password, (select count(*) from " + TABLENAME2 + " as s where s.courses_id = " + courses_id + ") as students_number from " + TABLENAME3 + " as c where c.teachers_id = '" + teachers_id + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				teacherCourseInfoBeans.setCourse_name(rs.getString("course_name"));
				teacherCourseInfoBeans.setCategory1(rs.getString("category1"));
				teacherCourseInfoBeans.setCategory2(rs.getString("category2"));
				teacherCourseInfoBeans.setCategory3(rs.getString("category3"));
				teacherCourseInfoBeans.setCategory4(rs.getString("category4"));
				teacherCourseInfoBeans.setCourse_password(rs.getString("course_password"));
				teacherCourseInfoBeans.setStudents_num(rs.getInt("students_number"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return teacherCourseInfoBeans;
	}
}

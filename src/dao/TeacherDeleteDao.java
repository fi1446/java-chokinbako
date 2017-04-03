package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.CategoryCheckBeans;
import beans.CategoryNameBeans;
import beans.CategoryUniqueNameBeans;
import beans.ChecklistBeans;
import beans.MemoBeans;
import beans.StudentInfoBeans;
import beans.StudentNewInfoBeans;
import beans.TopicIdBeans;

public class TeacherDeleteDao extends SuperDao {

	public void deleteAllInfo(int teacher_course_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		try {
			con = getConnection();
			String sql1 = "delete from students cascade where courses_id = " + teacher_course_id;
			String sql2 = "delete from checks cascade where courses_id = " + teacher_course_id;
			String sql3 = "delete from logins cascade where courses_id = " + teacher_course_id;
			String sql4 = "delete from topics cascade where courses_id = " + teacher_course_id;
			String sql5 = "delete from courses cascade where courses_id = " + teacher_course_id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			stmt.executeUpdate(sql5);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;
	}

	public void changeTeacherInfoBack(int logins_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		try {
			con = getConnection();
			String sql = "update teachers set courses_id = null, registered = '0' where logins_id = " + logins_id;
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;
	}

	public ArrayList<ChecklistBeans> getAllChecklists(int courses_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		ArrayList<ChecklistBeans> list = new ArrayList<>();
		try {
			con = getConnection();
			String sql = "select checklist as checklist from students where courses_id = " + courses_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ChecklistBeans beans = new ChecklistBeans();
				beans.setChecklist(rs.getString("checklist"));
				list.add(beans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			closeConnection(con);
		}
		return list;
	}

	public void deleteAllChecklists(ChecklistBeans beans) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		try {
			con = getConnection();
			String sql = "drop view " + beans.getChecklist();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;
	}
}

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.CategoryNameBeans;
import beans.ChecklistBeans;
import beans.StudentInfoBeans;

public class StudentDashboardDao extends SuperDao {

	private static String TABLENAME1 = "students";
	private static String TABLENAME2 = "courses";

	public StudentInfoBeans selectStudentInfo(int logins_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		StudentInfoBeans beans = new StudentInfoBeans();
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select s.name as sname, (select c.name as cname from " + TABLENAME2 + " as c where c.courses_id = s.courses_id) from " + TABLENAME1 + " as s where s.logins_id = " + logins_id + ";";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				beans.setStudent_name(rs.getString("sname"));
				beans.setCourse_name(rs.getString("cname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return beans;
	}

	public CategoryNameBeans getCategoriesNamesFromCourse(int logins_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		CategoryNameBeans beans = new CategoryNameBeans();
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select c.category1 as category1, c.category2 as category2, c.category3 as category3, c.category4 as category4 from " + TABLENAME2 + " as c where c.courses_id = (select s.courses_id from " + TABLENAME1 + " as s where s.logins_id = " + logins_id + ")";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				beans.setCategory1(rs.getString("category1"));
				beans.setCategory2(rs.getString("category2"));
				beans.setCategory3(rs.getString("category3"));
				beans.setCategory4(rs.getString("category4"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return beans;
	}

	public ChecklistBeans getChecklistName(int logins_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		ChecklistBeans beans = new ChecklistBeans();
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select checklist as checklist from " + TABLENAME1 + " where logins_id = " + logins_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				beans.setChecklist(rs.getString("checklist"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return beans;
	}

	public int countAllChecked(ChecklistBeans beans) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		int checked_count = 0;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select count(c.list_check) as checked from " + beans.getChecklist() + " as c where c.list_check = '1'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				checked_count = rs.getInt("checked");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return checked_count;
	}

	public int countAllCheckedByCategories(ChecklistBeans beans, String category) {
		loadJDBCDriver();
		System.out.println("ロードできました。");

		int checked_count = 0;

		Connection con = null;
		try {
			con = getConnection();
			String sql = "select count(c.list_check) as checked from " + beans.getChecklist() + " as c where c.category = '" + category + "' and c.list_check = '1'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				checked_count = rs.getInt("checked");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return checked_count;
	}

	public int countAllListcheck(ChecklistBeans checklistBeans) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		int checked_count = 0;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select count(c.list_check) as checked from " + checklistBeans.getChecklist() + " as c";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				checked_count = rs.getInt("checked");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return checked_count;
	}

	public int countAllListcheckByCategories(ChecklistBeans checklistBeans, String category) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		int checked_count = 0;
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select count(c.list_check) as checked from " + checklistBeans.getChecklist() + " as c where c.category = '" + category + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				checked_count = rs.getInt("checked");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return checked_count;
	}
}

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.CategoryNameBeans;
import beans.ChecklistBeans;
import beans.StudentInfoBeans;

public class StudentLoginDao extends SuperDao {

	private static String TABLENAME = "logins";

	public boolean login(String email, String password) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		String db_email = "";
		String db_password = "";
		String locked = "";
		Boolean success = false;
		try {
			con = getConnection();
			String sql = "select id as email, password as password, locked as locked from " + TABLENAME + " where id = '" + email + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				db_email = rs.getString("email");
				db_password = rs.getString("password");
				locked = rs.getString("locked");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection(con);
			success = false;
		} finally {
			closeConnection(con);
		}
		if (db_email.equals(email) && db_password.equals(password) && locked.equals("0")) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public int getLoginsId(String email) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		int id = 0;
		try {
			con = getConnection();
			String sql = "select logins_id as id from " + TABLENAME + " where id = '" + email + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection(con);
		} finally {
			closeConnection(con);
		}
		return id;
	}

	public boolean checkLockedStatus(String email) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		String status = "";
		try {
			con = getConnection();
			String sql = "select locked as status from " + TABLENAME + " where id = '" + email + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				status = rs.getString("status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection(con);
		} finally {
			closeConnection(con);
		}
		if(status == "0") {
			return true;
		} else {
			return false;
		}
	}
}

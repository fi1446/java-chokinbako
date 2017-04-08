package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherLoginDao extends SuperDao {

	private static String TABLENAME = "logins";

	public boolean login(String id, String password) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		String db_email = "";
		String db_password = "";
		String locked = "";
		Boolean success = false;
		try {
			con = getConnection();
			String sql = "select id as id, password as password, locked as locked from " + TABLENAME + " where id = '" + id + "' and user_type = '1'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				db_email = rs.getString("id");
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
		if (db_email.equals(id) && db_password.equals(password) && locked.equals("0")) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	public int getLoginsId(String id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		int db_id = 0;
		try {
			con = getConnection();
			String sql = "select logins_id as id from " + TABLENAME + " where id = '" + id + "' and user_type = '1'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				db_id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			closeConnection(con);
		} finally {
			closeConnection(con);
		}
		return db_id;
	}


}

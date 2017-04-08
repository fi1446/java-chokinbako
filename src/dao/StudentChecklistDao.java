package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.CategoryTopicBeans;
import beans.ChecklistBeans;
import beans.CategoryCheckBeans;
import beans.StudentInfoBeans;
import beans.MemoBeans;

public class StudentChecklistDao extends SuperDao {

	private static String TABLENAME = "topics";

	public ArrayList<CategoryCheckBeans> getCheckedByCategories(ChecklistBeans beans, String category) {
		loadJDBCDriver();
		System.out.println("ロードできました。");

		ArrayList<CategoryCheckBeans> list = new ArrayList<>();

		Connection con = null;
		try {
			con = getConnection();
			String sql = "select c.list_check as list_check from " + beans.getChecklist() + " as c where c.category = '" + category + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CategoryCheckBeans checkBeans = new CategoryCheckBeans();
				checkBeans.setCheck(rs.getString("list_check"));
				list.add(checkBeans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			closeConnection(con);
		}
		return list;
	}
	
	public ArrayList<CategoryTopicBeans> getTopicsByCategories(String category) {
		loadJDBCDriver();
		System.out.println("ロードできました。");

		ArrayList<CategoryTopicBeans> list = new ArrayList<>();

		Connection con = null;
		try {
			con = getConnection();
			String sql = "select topic as topic from " + TABLENAME + " where category = '" + category + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				CategoryTopicBeans beans = new CategoryTopicBeans();
				beans.setTopic(rs.getString("topic"));
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
	
	public ArrayList<MemoBeans> getMemosByCategories(ChecklistBeans beans, String category) {
		loadJDBCDriver();
		System.out.println("ロードできました。");

		ArrayList<MemoBeans> list = new ArrayList<>();

		Connection con = null;
		try {
			con = getConnection();
			String sql = "select memo as memo from " + beans.getChecklist() + " where category = '" + category + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MemoBeans memoBeans = new MemoBeans();
				memoBeans.setMemo(rs.getString("memo"));
				list.add(memoBeans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;
		} finally {
			closeConnection(con);
		}
		return list;
	}

	public void updateChecklist(StudentInfoBeans s_beans, CategoryCheckBeans c_beans, MemoBeans m_beans, CategoryTopicBeans t_beans, String category) {
		loadJDBCDriver();
		System.out.println("ロードできました。");

		Connection con = null;
		try {
			con = getConnection();
			String sql = "update checks set list_check = '" + c_beans.getCheck()+ "', memo = '" + m_beans.getMemo() + "' where user_info = '" + s_beans.getEmail() + "' and topics_id = (select t.topics_id from topics as t where t.category = '" + category + "' and t.topic = '" + t_beans.getTopic() + "')";
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

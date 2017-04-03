package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.CategoryNameBeans;
import beans.CategoryUniqueNameBeans;
import beans.ChecklistBeans;
import beans.MemoBeans;
import beans.StudentInfoBeans;
import beans.StudentNewInfoBeans;
import beans.TopicIdBeans;

public class TeacherRegisterDao extends SuperDao {

	private static String TABLENAME1 = "students";
	private static String TABLENAME2 = "courses";
	private static String TABLENAME3 = "checks";
	private static String TABLENAME4 = "topics";
	private static String TABLENAME5 = "logins";
	private static String TABLENAME6 = "teachers";

	public void setNewCourse(ArrayList<CategoryUniqueNameBeans> list, String course_name, String password, int id) {
		loadJDBCDriver();
		Connection con = getConnection();

		String sql = "insert into " + TABLENAME2 + " (name, category1, category2, category3, category4, password, teachers_id) values (?,?,?,?,?,?,?);";

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, course_name);
			for (int i = 0; i < 4; i++) {
				if (list.get(i).getName() == null || String.valueOf(list.get(i).getName()) == "") {
					statement.setString(i + 2, null);
				} else {
					statement.setString(i + 2, list.get(i).getName());
				}
			}
			statement.setString(2, list.get(0).getName());
			statement.setString(3, list.get(1).getName());
			statement.setString(4, list.get(2).getName());
			statement.setString(5, list.get(3).getName());
			statement.setString(6, password);
			statement.setInt(7, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;
	}

	public int sendBackLatestCourseId() {
		loadJDBCDriver();
		System.out.println("ロードできました。");

		int checked_count = 0;

		Connection con = null;
		try {
			/* データベースに接続 */
			con = getConnection();

			/* データベースにSQL文を送信 */
			String sql = "select max(courses_id) as id from " + TABLENAME2;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				checked_count = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return checked_count;
	}
	
	public void insertIntoTopicsByCategories(int courses_id, String category_name, String topic) {
		loadJDBCDriver();
		Connection con = getConnection();

		String sql = "insert into " + TABLENAME4 + " (courses_id, category, topic) values (?,?,?);";

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, courses_id);
			statement.setString(2, category_name);
			statement.setString(3, topic);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;
	}
	
	//いまここ
	public ArrayList<TopicIdBeans> setTopicIdsByCategories(String category) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		ArrayList<TopicIdBeans> list = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select topics_id as id from " + TABLENAME4 + " where category = '" + category + "' order by topics_id";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				TopicIdBeans beans = new TopicIdBeans();
				beans.setId(rs.getInt("id"));
				beans.setCategory(category);
				list.add(beans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return list;
	}
	
	public void createStudentsLogins(String email, String password, int courses_id) {
		loadJDBCDriver();
		Connection con = getConnection();
		String sql = "insert into " + TABLENAME5 + " (user_type, id, password, courses_id, locked) values (?,?,?,?,?);";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "2");
			statement.setString(2, email);
			statement.setString(3, password);
			statement.setInt(4, courses_id);
			statement.setString(5, "0");
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;		
	}

	public ArrayList<StudentNewInfoBeans> setLoginsIdsByCourseId(int db_course_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		ArrayList<StudentNewInfoBeans> list = new ArrayList<>();
		Connection con = null;
		try {
			con = getConnection();
			String sql = "select logins_id as id from " + TABLENAME5 + " where courses_id = " + db_course_id + " and user_type = '2'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				StudentNewInfoBeans beans = new StudentNewInfoBeans();
				beans.setLogins_id(rs.getInt("id"));
				list.add(beans);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return list;
	}

	public void createChecksByStudents(CategoryUniqueNameBeans categoryUniqueNameBeans, TopicIdBeans topicIdBeans,
			String user_info, int courses_id) {
		loadJDBCDriver();
		Connection con = getConnection();
		String sql = "insert into " + TABLENAME3 + " (category, topics_id, user_info, list_check, memo, courses_id) values (?,?,?,?,?,?);";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, categoryUniqueNameBeans.getName());
			statement.setInt(2, topicIdBeans.getId());
			statement.setString(3, user_info);
			statement.setString(4, "");
			statement.setString(5, "");
			statement.setInt(6, courses_id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;	
	}

	public void createViewsByStudents(String checklist, String email) {
		loadJDBCDriver();
		Connection con = getConnection();
		try {
			String sql = "create view " + checklist + " as select t.topic, c.list_check, c.memo, c.category from checks as c left join topics as t on c.topics_id = t.topics_id where c.user_info = '" + email + "'";
			Statement stmt = con.createStatement();
			stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;	
	}

	public void createStudents(String email, String name, int db_course_id, int logins_id, String checklist) {
		loadJDBCDriver();
		Connection con = getConnection();
		String sql = "insert into " + TABLENAME1 + " (email, name, courses_id, logins_id, checklist) values (?,?,?,?,?);";
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, name);
			statement.setInt(3, db_course_id);
			statement.setInt(4, logins_id);
			statement.setString(5, checklist);

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con);
		}
		return;		
	}

	public void updateTeacherInfo(int courses_id, int teachers_id) {
		loadJDBCDriver();
		System.out.println("ロードできました。");
		Connection con = null;
		try {
			con = getConnection();
			String sql = "update " + TABLENAME6 + " set courses_id = '" + courses_id + "', registered = '1' where teachers_id = " + teachers_id;
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

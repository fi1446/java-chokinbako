package dao;

import java.sql.Connection;

public interface MasterDaoInterface {
	void loadJDBCDriver();
	public Connection getConnection();
	public void closeConnection(Connection con);
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SuperDao implements MasterDaoInterface{
	// ******** ＤＢとの接続に必要な情報を保持する ***
	private final static String DRIVER_URL = "jdbc:postgresql://localhost:5433/chokinbako";
	private final static String DRIVER_NAME = "org.postgresql.Driver";
	private final static String USER_NAME = "postgres";
	private final static String PASSWORD = "totomoni";

	// private final static String RESOURCE_NAME = "jdbc/mydata";

	// ******** ドライバのロード ****************
	@Override
	public void loadJDBCDriver() {
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("ロードに成功しました。");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// ******** DBに接続 *************************
	@Override
	public Connection getConnection() {
		try {
			System.out.println("connect0");
			return (DriverManager
					.getConnection(DRIVER_URL, USER_NAME, PASSWORD));
		} catch (SQLException e) {
			System.out.println("エラーですな！");
			throw new RuntimeException(e);
		}
	}

	// ******** DBの接続解除 *********************
	@Override
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ******** tableの全データ読み出し *******************


//	@Override
//	public List selectRecordById() {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}

}

package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	public static final DatabaseManager instance = new DatabaseManager();
	private Connection conn;

	private DatabaseManager() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			conn = DriverManager
					.getConnection("jdbc:sqlserver://HP\\SQLEXPRESS:1435;user=sa;password=radwant12345;databaseName=Spendiser");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet select(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		ResultSet rs = sta.executeQuery(sql);
		return rs;
	}

	public void query(String sql) throws SQLException {

		Statement sta = conn.createStatement();
		sta.executeUpdate(sql);

	}
}

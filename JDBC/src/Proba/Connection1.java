package Proba;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection1 {
	String driverClassName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/proba";
	String dbUser = "root";
	String dbPwd = "root";

	private static Connection1 connectionFactory = null;

	private Connection1() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static Connection1 getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new Connection1();
		}
		return connectionFactory;
	}
}

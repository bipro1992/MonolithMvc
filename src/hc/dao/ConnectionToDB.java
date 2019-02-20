package hc.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnectionToDB {

	private Connection conn;

	public static Connection getConnect()
	{
		Connection finalConn=null;
		try {
			finalConn= new ConnectionToDB().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return finalConn;
	}

	private Connection connect() throws SQLException {

		conn = null;

		try {
			// load the properties file

			// assign db parameters
			String url = "jdbc:mysql://clouddbmysql.ccppgde3p5wu.us-east-2.rds.amazonaws.com:3306/cloudDBMysql";
			String user = "javaToCloud";
			String password = "javaToCloud2019";
			// create a connection to the database
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = (Connection) DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
}

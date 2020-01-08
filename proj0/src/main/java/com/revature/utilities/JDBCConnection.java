package com.revature.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	public static Connection conn = null;
	
	public static Connection getConnection() {
		if(conn == null) {
			String endpoint = "jdbc:oracle:thin:@csong.csasln9s54wq.us-east-2.rds.amazonaws.com:1521:ORCL";
			String username = "Admin";
			String password = "password";
			try {
				conn = DriverManager.getConnection(endpoint, username, password);
				MyLogger.logger.info("DB connected");
				return conn;
			} catch (SQLException e) {
				MyLogger.logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return conn;
	}
}

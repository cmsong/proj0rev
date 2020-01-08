package com.revature.main;
import java.sql.Connection;

import com.revature.prompts.StartUp;
import com.revature.utilities.JDBCConnection;
import com.revature.utilities.MyLogger;

public class Progstart {

	public static void main(String[] args) {
		MyLogger.logger.info("Program start up");
		final Connection conn = JDBCConnection.getConnection();
		StartUp.menu();
	}
}

package com.odesk.treeapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	private static final String driver = "com.mysql.jdbc.Driver";

	private static final String url = "jdbc:mysql://127.0.0.1:3306/dbtree";

	private static final String user = "root";

	private static final String password = "";

	private static Connection connection;
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}

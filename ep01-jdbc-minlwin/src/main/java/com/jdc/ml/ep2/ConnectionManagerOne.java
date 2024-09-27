package com.jdc.ml.ep2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionManagerOne {

	Connection getConnection() throws SQLException;

	String URL = "jdbc:mysql://localhost:3306/member_db";
	String USR = "root";
	String PASS = "admin";
	
	public static ConnectionManagerOne getIstance() {
		return () -> DriverManager.getConnection(URL, USR, PASS);
	}

}

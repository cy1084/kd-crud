package com.game.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	public static final String DRIVER_NAME="org.mariadb.jdbc.Driver";
	public static final String URL="jdbc:mariadb://localhost:3306/game";
	public static final String USERNAME="KDTEST";
	public static final String PASSWORD="kd1824java";
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	public static Connection getCon() {
		try {
			return DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getCon());

	}

}

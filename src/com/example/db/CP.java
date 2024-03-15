package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {

	static Connection conn;
	
	public static Connection createc() throws SQLException {
		
		//load drive class
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection
			
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/studentdata";
			
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		return conn;
		
		
	}
	
}

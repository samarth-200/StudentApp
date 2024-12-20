package com.student.connectors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection Connectionrequest()
	{
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/company_1";
		String user = "root";
		String password = "samarth";
	        
	        	try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection(url,user,password);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	return con;
	}
	
}

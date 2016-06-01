package com.itekkies.training.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itekkies.training.util.PropertyFileReader;

public class DBConnection {
	
	public java.sql.Connection getConnection() {
		Connection con = null;
		String db_class = PropertyFileReader.getProperty("db.properties", "DB_CLASS");
		String user = PropertyFileReader.getProperty("db.properties", "USER_NAME");
		String password = PropertyFileReader.getProperty("db.properties", "PASSWORD");
		String host = PropertyFileReader.getProperty("db.properties", "HOST");
		String port = PropertyFileReader.getProperty("db.properties", "PORT");
		String db_name = PropertyFileReader.getProperty("db.properties", "DB_NAME");
		
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance(); 
			con = DriverManager.getConnection( db_class + "://" + host + ":" + port + "/" + db_name + "?user=" + user + "&password=" + password);
		}
		catch(SQLException sqe) {
			sqe.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return con;
	}
	
	public void closeConnection(Connection con) {
		
		try {
			if(con != null) {
				con.close();
			}
		}
		catch(SQLException sqe) {
			System.out.println("Exception while closing connection: ");
			sqe.printStackTrace();
		}
		
	}
	
	public void closeConnection(Connection con, PreparedStatement psmt, ResultSet rs) {
		
		try {
			if(rs != null)
				rs.close();
			if(psmt != null)
				psmt.close();
			if(con != null) {
				con.close();
			}
		}
		catch(SQLException sqe) {
			System.out.println("Exception while closing connection: ");
			sqe.printStackTrace();
		}
		
	}
}

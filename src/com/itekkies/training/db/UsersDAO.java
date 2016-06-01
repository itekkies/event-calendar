package com.itekkies.training.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itekkies.training.events.User;

public class UsersDAO {

	public User getUser(String userName) {
		DBConnection dbcon = new DBConnection();
		Connection connection = dbcon.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		User user = null;
		try {	
			psmt = connection.prepareStatement("Select id, user_name,password,email from users where user_name=?");
			psmt.setString(1, userName);
			rs = psmt.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("user_name"));
			}
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}finally {
			dbcon.closeConnection(connection, psmt, rs);
		}
		
		return user;
	}
	
	public void saveUser(User user) {
		DBConnection dbcon = new DBConnection();
		Connection connection = dbcon.getConnection();
		PreparedStatement psmt = null;
		try {	
			psmt = connection.prepareStatement("insert into users (user_name, email, password) values (?,?,?)");
			psmt.setString(1, user.getUserName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPassword());
			psmt.execute();
		}catch(SQLException sqe) {
			sqe.printStackTrace();
		}finally {
			dbcon.closeConnection(connection, psmt, null);
		}
	}
	
}

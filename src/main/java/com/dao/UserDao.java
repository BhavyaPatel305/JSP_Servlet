package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.Bean.UserBean;
import com.utility.DbConnection;

public class UserDao {
	public void UserData(UserBean user) {
		try {
			// Get the connection object from DbConnection.java file
			Connection connection = DbConnection.getConnection();

			// Execute query in database
			PreparedStatement pstmt = connection
					.prepareStatement("insert into users(firstname,email,password) values (?,?,?)");
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());

			// Run the query
			pstmt.executeUpdate();// insert delete update

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<UserBean> getAllUsers() {
		// return users
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection connection = DbConnection.getConnection();

			PreparedStatement pstmt = connection.prepareStatement("select * from users");
			ResultSet rs = pstmt.executeQuery();// select

			while (rs.next()) {

				int userId = rs.getInt("userId");
				String fn = rs.getString("firstName");
				String em = rs.getString("email");
				String pwd = rs.getString("password");

				UserBean u = new UserBean();
				u.setUserId(userId);
				u.setFirstName(fn);
				u.setPassword(pwd);
				u.setEmail(em);

				users.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}

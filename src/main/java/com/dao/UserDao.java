package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;

import com.Bean.UserBean;
import com.utility.DbConnection;

public class UserDao {
    public void UserData(UserBean user){
        try{
				// Get the connection object from DbConnection.java file
				Connection connection = DbConnection.getConnection();

				// Execute query in database
				PreparedStatement pstmt = connection.prepareStatement("insert into users(firstname,email,password) values (?,?,?)");
				pstmt.setString(1,user.getFirstName());
				pstmt.setString(2,user.getEmail());
				pstmt.setString(3,user.getPassword());

				// Run the query
				pstmt.executeUpdate();

			}catch(Exception e){
				e.printStackTrace();
			}

    }
}

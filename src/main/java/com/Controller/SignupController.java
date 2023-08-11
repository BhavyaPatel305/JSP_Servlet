package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.UserBean;
import com.dao.UserDao;
import com.utility.DbConnection;

@javax.servlet.annotation.WebServlet("/SignupController")
public class SignupController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("SignUpController...");
		String firstName = request.getParameter("firstname");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String err_msg = "";
		boolean flg = false;
		
		// Write logic for validation
		if (firstName == null || firstName.trim().length() == 0) {
			flg = true;
			err_msg += "<br>Please Enter First Name";
		}
		if (email == null || email.trim().length() == 0) {
			flg = true;
			err_msg += "<br>Please Enter Email";
		}
		if (password == null || password.trim().length() == 0) {
			flg = true;
			err_msg += "<br>Please Enter Password";
		}
		
		
		if (flg == true) {
		}
		else{
			// Add content to it
			try{
				UserBean user = new UserBean();
				user.setFirstName(firstName);
				user.setEmail(email);
				user.setPassword(password);

				UserDao userdao = new UserDao();
				userdao.UserData(user);
				// Then go to Login.jsp file
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	  			rd.forward(request, response);

			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
	}
}

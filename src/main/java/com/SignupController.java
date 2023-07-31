package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
		// Give response to client
		PrintWriter out = response.getWriter();
		// give response in the form of html
		response.setContentType("text/html");
		// Start the html file, that we are returning
		out.print("<html><body>");
		
		if (flg == true) {
			// Add content to it
			out.print(err_msg);
		}
		else{
			// Add content to it
			out.print("FirstName: " + firstName);
			out.print("<br>Email: " + email);
			out.print("<br>Password: " + password);
		}
		out.print("</body></html>");
		
	}
}

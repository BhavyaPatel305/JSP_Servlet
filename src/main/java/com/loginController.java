package com;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginController")
public class loginController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Login...");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		System.out.println(email + "\n");
		System.out.println(password + "\n");

	}
}
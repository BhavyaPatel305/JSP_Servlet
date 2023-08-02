package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignupController2")
public class SignupController2 extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String gender = request.getParameter("gender");
        String hobby = request.getParameter("hobby");
        String city = request.getParameter("city");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        out.print("<html><body>");
        out.print("<br>FirstName: " + firstName);
        out.print("<br>LastName: " + lastName);
        out.print("<br>Email: " + email);
        out.print("<br>Password: " + password);
        out.print("<br>Gender: " + gender);
        out.print("<br>hobby; " + hobby);
        out.print("<br>city: " + city);
        out.print("</body></html>");
    }
    
}

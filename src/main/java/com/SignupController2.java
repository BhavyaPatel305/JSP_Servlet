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
        String[] hobby = request.getParameterValues("hobby");
        String city = request.getParameter("city");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        // Validation
        String err_msg = "";
        boolean flg = false;
        if(firstName == null || firstName.trim().length() == 0){
            err_msg += "First Name is required<br>";
            flg = true;
        }
        if(lastName == null || lastName.trim().length() == 0){
            err_msg += "Last Name is required<br>";
            flg = true;
        }
        if(email == null || email.trim().length() == 0){
            err_msg += "Email is required<br>";
            flg = true;
        }
        if(password == null || password.trim().length() == 0){
            err_msg += "Password is required<br>";
            flg = true;
        }
        if(gender == null || gender.trim().length() == 0){
            err_msg += "Gender is required<br>";
            flg = true;
        }
        if(hobby == null || hobby.length == 0){
            err_msg += "Hobby is required<br>";
            flg = true;
        }
        if(city == null || city.trim().length() == 0){
            err_msg += "City is required<br>";
            flg = true;
        }
        if(flg == false){
            out.print("<html><body>");
            out.print("<br>FirstName: " + firstName);
            out.print("<br>LastName: " + lastName);
            out.print("<br>Email: " + email);
            out.print("<br>Password: " + password);
            out.print("<br>Gender: " + gender);
            out.print("<br>hobby:");
            for(int i = 0; i<hobby.length;i++) {
            	out.print("<br>" + hobby[i]);
            }
            out.print("<br>city: " + city);
        }else{
            out.print(err_msg);
        }
        out.print("</body></html>");
    }
    
}

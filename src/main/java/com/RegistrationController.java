package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("RegistrationController...");

        String firstName = request.getParameter("firstname");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");

        boolean flg = false;

        // Write logic for validation
        if (firstName == null || firstName.trim().length() == 0) {
            flg = true;
            // We send error message using setAttribute, where "firstNameError" is key and
            // "PLease Enter First Name" is value
            // We send multiple error messages using setAttribute
            request.setAttribute("firstNameError", "Please Enter FirstName");
        } else {
            // If firstname was given as input by the user than setAttribute its value
            // Which we will access in Home.jsp file to print it on screen
            request.setAttribute("firstNameValue", firstName);
        }
        if (email == null || email.trim().length() == 0) {
            flg = true;
            // We send multiple error messages using setAttribute
            request.setAttribute("emailError", "Please Enter Email");
        }else {
            // If email was given as input by the user than setAttribute its value
            // Which we will access in Home.jsp file to print it on screen
            request.setAttribute("emailValue", email);
        }
        if (password == null || password.trim().length() == 0) {
            flg = true;
            // We send multiple error messages using setAttribute
            request.setAttribute("passwordError", "Please Enter Password");
        }else {
            // If password was given as input by the user than setAttribute its value
            // Which we will access in Home.jsp file to print it on screen
            request.setAttribute("passwordValue", password);
        }
        // if flg == true, we go back to Registration.jsp to print error msg over there
        if (flg == true) {
            // Add content to it
            // We send error message using setAttribute, where "err_msg" is key and err_msg
            // is value
            // We use requestDispatcher to go to a specific .jsp page
            RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
            // Go and take request and response variables
            rd.forward(request, response);

        } // If there is no error, then go to Home.jsp page
        else {
            // Add content to it
            RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);

        }

    }
}

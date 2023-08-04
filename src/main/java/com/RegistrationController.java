package com;

import java.io.IOException;
import java.io.PrintWriter;

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
        // if flg == true, we go back to Registration.jsp to print error msg over there
        if (flg == true) {
            // Add content to it
            // We send error message using setAttribute, where "err_msg" is key and err_msg is value
            request.setAttribute("err_msg", err_msg);
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

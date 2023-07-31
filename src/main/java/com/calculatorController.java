package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculatorController")
public class calculatorController extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // get the 2 numbers entered by the user
        String num1 = request.getParameter("number1");
        String num2 = request.getParameter("number2");

        // get the operation user wants to perform from radio buttons
        String operation = request.getParameter("calc");

        // Write the response to client
        PrintWriter out = response.getWriter();
        // Send response in form of html file
        response.setContentType("text/html");
        
        // Start the html file for response
        out.print("<html><body>");

        // Write the logic of the code
        if (operation.equals("add")){
        	
            out.print("Addition: " + (Integer.parseInt(num1) + Integer.parseInt(num2)));
        }
        if (operation.equals("sub")){
            out.print("Subtraction: " + (Integer.parseInt(num1) - Integer.parseInt(num2)));
        }
        if (operation.equals("div")){
            out.print("Division: " + (Integer.parseInt(num1) / Integer.parseInt(num2)));
        }
        if (operation.equals("mul")){
            out.print("Multiplication: " + (Integer.parseInt(num1) * Integer.parseInt(num2)));
        }        
        out.print("</body></html>");

    }
    
}

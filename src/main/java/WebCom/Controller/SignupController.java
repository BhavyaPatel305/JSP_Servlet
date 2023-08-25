package WebCom.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebCom.Bean.CustomerBean;
import WebCom.Dao.CustomerDao;

@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get User Input
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String pnum = request.getParameter("pnum");
        String pass = request.getParameter("pass");
        // bool to check if anything is missing
        boolean flg = false;

        // Validate User Input
        if (fname == null || fname.trim().length() == 0) {
            flg = true;
            request.setAttribute("fname", "Please Enter First Name");
        }

        if (lname == null || lname.trim().length() == 0) {
            flg = true;
            request.setAttribute("lname", "Please Enter Last Name");
        }

        if (email == null || email.trim().length() == 0) {
            flg = true;
            request.setAttribute("email", "Please Enter Email");
        }

        if (pnum == null || pnum.trim().length() == 0) {
            flg = true;
            request.setAttribute("pnum", "Please Enter Phone number");
        }

        if (pass == null || pass.trim().length() == 0) {
            flg = true;
            request.setAttribute("pass", "Please Enter Password");
        }

        // Taking action according to validation
        if (flg == true) {
            // If something is missing
            // Go back to signup.jsp
            RequestDispatcher rd = request.getRequestDispatcher("SignupCustomer.jsp");
            rd.forward(request, response);
        } else {
            // If everything is ok, then add user data to database

            // Store Data to Bean file
            CustomerBean user = new CustomerBean();
            user.setFname(fname);
            user.setLname(lname);
            user.setEmail(email);
            user.setPnum(pnum);
            user.setPass(pass);

            // Use Bean file to add data to data base using Dao
            CustomerDao cd = new CustomerDao();
            cd.customerData(user);

            // After user is signed up, go to login.jsp
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }
    }
}


package WebCom.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebCom.Bean.LoginBean;
import WebCom.Dao.LoginDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Get User Input
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        boolean flg = false;

        // Validate User Input
        if(email == null || email.trim().length() == 0){
            flg = true;
            request.setAttribute("email", "Email is required");
        }
        if(pass == null || pass.trim().length() == 0){
            flg = true;
            request.setAttribute("pass", "Password is required");
        }

        // Taking action according to validation
        if(flg == true){
            // If there is some problem with user input, go back to login.jsp
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response);
        }else{
            // If user input is perfect, then check if user exits in CUSTOMER table in database
            // First store user input into Login Bean
            LoginBean lb = new LoginBean();
            lb.setEmail(email);
            lb.setPass(pass);

            // Now check if user exists in database
            LoginDao ld = new LoginDao();
            try {
                boolean check = ld.customerLogin(lb);
                // If user exists, then go to homepage
                if(check){
                    RequestDispatcher rd = request.getRequestDispatcher("Homepage.jsp");
                    rd.forward(request,response);
                }else{
                    // If user, does not exist in CUSTOMER database
                    RequestDispatcher rd = request.getRequestDispatcher("SignupCustomer.jsp");
                    rd.forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    
}

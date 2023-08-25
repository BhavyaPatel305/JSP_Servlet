package WebCom.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebCom.Bean.DeleteProductBean;
import WebCom.Dao.ProductDao;

@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get Admin Input
        String p_id = request.getParameter("p_id");

        // Validate Admin Input
        if (p_id == null || p_id.trim().length() == 0) {
            // If admin input is blank, go back to delete product . jsp file
            request.setAttribute("p_id", "Product ID is Required");
            RequestDispatcher rd = request.getRequestDispatcher("DeleteProduct.jsp");
            rd.forward(request, response);
        } else {
            // If admin input is valid, then delete the product from the database
            // First store admin input into Delete Product Bean
            DeleteProductBean dpb = new DeleteProductBean();
            dpb.setP_id(p_id);

            // Now using Dao file, update the database
            ProductDao pd = new ProductDao();
            try {
                pd.deleteProduct(dpb);
                // After product is deleted from database, go back to Admin Home page
                RequestDispatcher rd = request.getRequestDispatcher("AdminHomePage.jsp");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

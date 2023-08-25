package WebCom.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WebCom.Bean.ProductBean;
import WebCom.Dao.ProductDao;

@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Get Admin Input
        String p_name = request.getParameter("p_name");
        String p_price = request.getParameter("p_price");
        String p_original_price = request.getParameter("p_original_price");
        String p_image_url = request.getParameter("p_image_url");
        String p_video_url = request.getParameter("p_video_url");
        String p_description = request.getParameter("p_description");
        String p_specification = request.getParameter("p_specification");
        String p_reviews = request.getParameter("p_reviews");
        String p_avg_rating = request.getParameter("p_avg_rating");
        String p_in_stock = request.getParameter("p_in_stock");
        String p_shipping_info = request.getParameter("p_shipping_info");
        String p_category = request.getParameter("p_category");
        String p_size_chart = request.getParameter("p_size_chart");
        boolean flg = false;

        // Validate Admin Input
        if(p_name == null || p_name.trim().length() == 0){
            flg = true;
            request.setAttribute("p_name", "Product Name is required");
        }
        if(p_price == null || p_price.trim().length() == 0){
            flg = true;
            request.setAttribute("p_price", "Product Price is required");
        }

        // Taking action according to validation
        if(flg == true){
            // If there is some problem with admin input, go back to addProduct.jsp
            RequestDispatcher rd = request.getRequestDispatcher("AddProduct.jsp");
            rd.forward(request, response);
        }else{
            // If Admins input is ok, then insert product into the product table
            // First store admin input into Product Bean
            ProductBean pb = new ProductBean();
            pb.setP_name(p_name);
            pb.setP_price(p_price);
            pb.setP_original_price(p_original_price);
            pb.setP_image_url(p_image_url);
            pb.setP_video_url(p_video_url);
            pb.setP_description(p_description);
            pb.setP_specification(p_specification);
            pb.setP_reviews(p_reviews);
            pb.setP_avg_rating(p_avg_rating);
            pb.setP_in_stock(p_in_stock);
            pb.setP_shipping_info(p_shipping_info);
            pb.setP_category(p_category);
            pb.setP_size_chart(p_size_chart);
            
            // Now insert product into product table using ProductDao 
            ProductDao pd = new ProductDao();
            try {
                pd.addNewProduct(pb);
                // After Adding new product go back to admin home page
            } catch (SQLException e) {
                e.printStackTrace();
            }

            

        }
    }
}

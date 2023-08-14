package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.ProductBean;
import com.dao.ProductDao;
@WebServlet("/productController")
public class productController extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Get all the values & store in variables
        String pname = request.getParameter("pname");
        String price = request.getParameter("price");
        String qty = request.getParameter("qty");
        String category = request.getParameter("category");
        String err_msg = "";
        boolean flg = false;

        // Logic for validation
        if(pname == null || pname.trim().length() == 0){
            flg = true;
            request.setAttribute("pname","Please Enter Product Name");
        }
        if(price == null || price.trim().length() == 0){
            flg = true;
            request.setAttribute("price","Please Enter Price");
        }
        if(qty == null || qty.trim().length() == 0){
            flg = true;
            request.setAttribute("qty","Please Enter Quantity");
        }
        if(category == null || category.trim().length() == 0){
            flg = true;
            request.setAttribute("category","Please Enter Category");
        }

        

        if(flg == true){
            // Add content to it
            // We send error message using setAttribute, where "err_msg" is key and err_msg is value
            // We use requestDispatcher to go to a specific .jsp page
            RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
            // Go and take request and response variables
            rd.forward(request, response);
        }else{
            ProductBean bn = new ProductBean();
            bn.setPname(pname);
            bn.setPrice(price);
            bn.setQty(qty);
            bn.setCategory(category);

            ProductDao pd = new ProductDao();
            pd.productData(bn);

            

            // Then go to Login.jsp file
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);
        }
        
    }
    
}

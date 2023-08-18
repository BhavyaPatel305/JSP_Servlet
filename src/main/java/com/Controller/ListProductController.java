package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.Bean.ProductBean;

@WebServlet("/ListProductController")
public class ListProductController extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ProductDao pd = new ProductDao();
        ArrayList<ProductBean> data = pd.getAllProducts();
        request.setAttribute("list",data);
        RequestDispatcher rd = request.getRequestDispatcher("listProducts.jsp");
        rd.forward(request, response);
    }
    
}

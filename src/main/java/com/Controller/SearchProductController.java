package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.ProductBean;
import com.dao.ProductDao;

@WebServlet("/SearchProductController")
public class SearchProductController extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ProductDao pd = new ProductDao();
        ArrayList<ProductBean> data = pd.SearchProducts(request.getParameter("pname"));
        request.setAttribute("list",data);
        RequestDispatcher rd = request.getRequestDispatcher("showSearchProduct.jsp");
        rd.forward(request, response);
    }
    
}

package com.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.UserBean;
import com.dao.UserDao;

@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet {
    // jsp send
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        UserDao d = new UserDao();
        ArrayList<UserBean> user = d.getAllUsers();
        request.setAttribute("list",user);
        RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
        rd.forward(request, response);
    }

}

// AddUser.jsp {form -> fields } submit ->
// AddUserController -> data read , validate , db save
// dbSave-> UserDao -> addUser
// AddUserController -> rd->Home.jsp

// hyper link -> all users -> display

// link->ListController -> UserDao->getAllUsers()-> return users list ->
// send->jsp rd->jsp open
// jsp -> list get -> print

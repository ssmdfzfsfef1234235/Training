package com.offcn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求数据
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        HttpSession session = req.getSession();

        //判断，如果没有登录过，则此次登录算作登录成功
        if (!(username.equals(session.getAttribute("name")))){
            //存入session
            session.setAttribute("name",username);
        }

        req.getRequestDispatcher("Online.jsp").forward(req,resp);

    }
}

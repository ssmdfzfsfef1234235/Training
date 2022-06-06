package com.offcn.servlet;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import com.offcn.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求乱码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //请求获取参数
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        System.out.println("gender = " + gender);
        String address = req.getParameter("address");
        //数据打包
        User user = new User(null, name, Integer.parseInt(age), gender, address);

        System.out.println("user = " + user);

        int result = userService.registerUser(user);
        PrintWriter writer = resp.getWriter();
        //如果注册成功，返回响应“注册成功”
        if (result > 0){
            writer.println("注册成功！");
        }else {
            //如果注册失败，返回响应“用户已存在，注册失败”
            writer.println("用户已存在，注册失败");
        }

    }
}

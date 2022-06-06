package com.offcn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2.获取请求路径
        //http://localhost:8080/studentProject/addStudent.do
        //http://localhost:8080/studentProject/queryStudent.do
        //http://localhost:8080/studentProject/updateStudent.do
        String uri = req.getRequestURI();//   /studentProject/addStudent.do

        //3.截取方法名
        String methodName = uri.substring(uri.lastIndexOf("/") + 1, uri.lastIndexOf(".do"));// addStudent

        //4.反射获取方法
        Class<? extends BaseServlet> clazz = this.getClass();
        try {
            Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //5.执行方法
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

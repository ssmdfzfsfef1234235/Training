package com.offcn.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.Student;
import com.offcn.service.StudentService;
import com.offcn.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {

    private StudentService studentService=new StudentServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String keyword = req.getParameter("keyword");

        //后台查数据的结果
        List<Student> list = studentService.search(keyword);

        //判断查询到了数据，再回传
        if (list != null && list.size() > 0 ){
            //将list集合转换成json
            ObjectMapper objectMapper = new ObjectMapper();
            String listJson = objectMapper.writeValueAsString(list);

            //将json数据响应回页面
            resp.getWriter().print(listJson);
        }
    }
}

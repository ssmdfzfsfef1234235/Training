package com.offcn.servlet;

import com.offcn.bean.Product;
import com.offcn.service.Impl.ProductServiceImpl;
import com.offcn.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllServlet")
public class ShowAllServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.查询出所有商品的信息集合
        List<Product> list = productService.selectAll();

        //2.将集合添加到域对象内部，为了将来jsp页面好获取数据
        req.setAttribute("list",list);

        //3.转发到响应的jsp页面
        req.getRequestDispatcher("product.jsp").forward(req,resp);
    }
}

package com.offcn.servlet;

import com.offcn.bean.Product;
import com.offcn.service.Impl.ProductServiceImpl;
import com.offcn.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {

    private ProductService productService=new ProductServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置字符集
        req.setCharacterEncoding("utf-8");

        //2.解析id
        String pid = req.getParameter("pid");

        //3.根据ID从数据库中查询出这个ID对应的商品信息
        Product product = productService.selectById(Integer.parseInt(pid));

        //4.获取session
        //因为购物车中一定会添加n个商品，因此，每一个添加的单独商品，都存入集合，集合返回个页面进行遍历展示
        HttpSession session = req.getSession();

        //设置session的存活时间
        session.setMaxInactiveInterval(60*60*24*30);

        //为了浏览器退出后，携带JSESSIONID的Cookie还在，还能再度找到对应的Session，再度或取出购物车的数据
        ////只能自己手动创建Cookie了
        Cookie cookie = new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*60*24*30);

        //将Cookie添加到响应对象中进行返回
        resp.addCookie(cookie);

        List<Product> list =(List<Product>) session.getAttribute("list");

        //5.如果集合不存在则创建出来
        if (list == null){
            list = new ArrayList<>();
        }

        //5.将商品对象添加到list集合
        list.add(product);

        //6.将存储了商品信息的list集合转发到购物车页面
        //将集合添加到域对象
        session.setAttribute("list",list);

        //重定向到购物车页面，这里其实转发重定向均可，因为数据存在session域中，jsp能自己找到session获取数据，不需要我们传送
        resp.sendRedirect("http://localhost:8080/shoppingCar/shoppingCar.jsp");
    }

}

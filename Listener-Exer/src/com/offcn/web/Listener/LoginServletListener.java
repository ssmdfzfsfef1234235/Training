package com.offcn.web.Listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.LinkedList;
import java.util.List;

@WebListener
public class LoginServletListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    private ServletContext servletContext;

    private void update(HttpSessionBindingEvent httpSessionBindingEvent) {
        //1.将session中的数据获取出来
        HttpSession session = httpSessionBindingEvent.getSession();

        //判断当前的session数据的键是"name",就能确保得到的一定是当前用户名
        if ("name".equals(httpSessionBindingEvent.getName())){
            //根据键获取用户名
            String name=(String)session.getAttribute(httpSessionBindingEvent.getName());

            //2.存入list集合
            //从ServletContext对象中取出集合
            List<String> list = (List<String>) servletContext.getAttribute("list");

            //将数据存入集合
            list.add(name);

            //3.将集合在ServletContext对象内更新一遍
            servletContext.setAttribute("list",list);
        }
    }
    /**
     * 1.当服务器启动，ServletContext对象创建，就准备好集合，用于保存已经登录的用户名
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //1.获取ServletContext对象
        servletContext=servletContextEvent.getServletContext();

        //2.准备集合，用于已经登录的用户名
        List<String> list = new LinkedList<>();

        //3.将集合绑定到ServletContext对象中
        servletContext.setAttribute("list",list);
    }

    /**
     * 2.第一次添加session数据，将session数据同步到list集合中
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        update(httpSessionBindingEvent);

    }

    /**
     * 修改session数据，将session数据同步到list集合中
     */
    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        update(httpSessionBindingEvent);
    }

    /**
     * 4.当session销毁的时候，从集合中移除数据
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        //从session中得到当前用户数据
        HttpSession session = httpSessionEvent.getSession();
        String name = (String) session.getAttribute("name");

        //获取集合
        List<String> list = (List<String>) servletContext.getAttribute("list");

        //从集合中删除
        list.remove(name);

        //对servletContext同步修改后的集合
        servletContext.setAttribute("list",list);
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }


}

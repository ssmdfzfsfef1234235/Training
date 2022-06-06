package com.offcn.test.day9;


/**
 * 1、用最原始的方式书写代码，获取Java的数据库连接就相当于
 * 我们在黑窗口输入用户名、密码登录mysql服务，
 * 只有登录后，也就是Java代码获取到连接后，才能够继续后续的
 * 增删改查操作
 *
 * java.sql.Driver数据库驱动接口，所有数据库厂商都必须对这个接口提供实现类
 * java.sql.Connection与特定数据库的连接（会话）。在连接上下文中执行 SQL 语句并返回结果。
 */


import java.sql.*;
import java.util.Scanner;

public class JDBCTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.nextLine();

        System.out.println("请您输入密码");
        String password = sc.nextLine();
        testJdbcUtils(name,password);
    }

    public static void testJdbcUtils(String name, String password) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int columnCount = 0;
        try {
            connection = JDBCUtils.getConnection();

            String sql="select * from users where username = ? and password = ?";//where username = ? and password = ?
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setObject(1,name);
            preparedStatement.setObject(2,password);

            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            columnCount = metaData.getColumnCount();

            if (resultSet.next()){
                for (int i = 0; i < columnCount; i++) {
                    Object object = resultSet.getObject(i + 1);
                    System.out.println("object = " + object);

                }

                System.out.println("登录成功");
            }else {
                System.out.println("登录失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }

    }
}

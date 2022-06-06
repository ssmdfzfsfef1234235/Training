package com.offcn.homework.day9;

import org.junit.Test;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class JdbcUtilsTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String name = sc.nextLine();

        System.out.println("请您输入密码");
        String password = sc.nextLine();
//        testJdbcUtils(name,password);
    }
        @Test
    public void testJdbcUtils() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int columnCount = 0;
        try {
            connection = JDBCUtils.getConnection();

            String sql="select * from users ";//where username = ? and password = ?
            preparedStatement = connection.prepareStatement(sql);

//            preparedStatement.setObject(1,name);
//            preparedStatement.setObject(2,password);

            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            columnCount = metaData.getColumnCount();

            if (resultSet.next()){
                for (int i = 0; i < columnCount; i++) {
                    Object object1 = resultSet.getObject(i + 2);
                    System.out.println("object1 = " + object1);
                    Object object2 = resultSet.getObject(i + 3);
                    System.out.println("object2 = " + object2);
                    System.out.println("登录成功");
                }
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

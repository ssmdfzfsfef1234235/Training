package com.offcn.homework.day9;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private JDBCUtils(){}

    public static Connection getConnection() throws SQLException, IOException {

        //1.获取连接
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");;

        Properties properties = new Properties();
        properties.load(is);

        String driverClass = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void closeResource(Connection connection, Statement statement, ResultSet resultset) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) {

                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (resultset != null) {

                resultset.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

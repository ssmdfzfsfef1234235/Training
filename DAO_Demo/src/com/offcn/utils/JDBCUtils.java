package com.offcn.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    static {
        try {
            InputStream is= JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);

           dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(dataSource);
    }

    public static Connection getConnection() throws SQLException {

        Connection connection = threadLocal.get();

        if (connection == null){
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;

    }

}

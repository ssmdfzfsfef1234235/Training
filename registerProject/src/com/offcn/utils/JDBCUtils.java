package com.offcn.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    static{
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties p = new Properties();
            p.load(is);
            dataSource= DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection connection=threadLocal.get();

        if (connection == null){
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
    return connection;
    }

}

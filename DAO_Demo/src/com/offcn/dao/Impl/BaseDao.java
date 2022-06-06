package com.offcn.dao.Impl;

import com.offcn.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.xml.ws.handler.Handler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    /**
     * 负责增删改查的基本操作
     */
    /**
     * 增删改查询操作，返回影响行数
     * @param connection
     * @param sql
     * @param obj
     * @return
     * @throws SQLException
     */
    public static int update(Connection connection, String sql, Object... obj) throws SQLException {

        QueryRunner queryRunner = new QueryRunner();

        int count = queryRunner.update(connection, sql, obj);

        return count;
    }

    /**
     * 查一个的操作，返回查到的数据类
     * @param clazz
     * @param connection
     * @param sql
     * @param obj
     * @param <T>
     * @return
     * @throws SQLException
     */
    public<T>  T selectOne(Class<T> clazz,Connection connection,String sql,Object... obj) throws SQLException {

        QueryRunner queryRunner = new QueryRunner();

        T t = queryRunner.query(connection, sql, new BeanHandler<T>(clazz), obj);

        return t;
    }

    /**
     * 查所有操作，返回查询类数组
     * @param clazz
     * @param connection
     * @param sql
     * @param <T>
     * @return
     * @throws SQLException
     */
    public<T> List<T> selectAll(Class<T> clazz, Connection connection, String sql) throws SQLException {

        QueryRunner queryRunner = new QueryRunner();

        List<T> ts = queryRunner.query(connection, sql, new BeanListHandler<T>(clazz));

        return ts;
    }

    /**
     * 查特殊，返回结果
     * @param connection
     * @param sql
     * @param obj
     * @return
     * @throws SQLException
     */
    public Object selectSpe( Connection connection, String sql, Object... obj) throws SQLException {

        QueryRunner queryRunner = new QueryRunner();

        Object o = queryRunner.query(connection, sql, new ScalarHandler(), obj);

        return o;
    }

}

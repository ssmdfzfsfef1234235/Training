package com.offcn.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao <T>{
    /**
     * 增删改的通用操作
     * @return 返回影响到的行数
     */
    public int update(Connection connection,String sql,Object... obj) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        int update = queryRunner.update(connection, sql, obj);
        return update;
    }

    /**
     * 查一个
     * @param clazz
     * @param connection
     * @param sql
     * @param obj
     * @return 返回对应类
     * @throws SQLException
     */
    public T selectOne(Class<T> clazz,Connection connection,String sql,Object... obj) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        T query = queryRunner.query(connection, sql, new BeanHandler<T>(clazz), obj);
        return query;
    }

    /**
     * 查所有
     * @param clazz
     * @param connection
     * @param sql

     * @return 返回对应类集合
     * @throws SQLException
     */
    public List<T> selectAll(Class<T> clazz,Connection connection,String sql) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        List<T> query = queryRunner.query(connection, sql, new BeanListHandler<T>(clazz));
        return query;
    }

    /**
     * 查询总行数
     * @param connection
     * @param sql

     * @return 返回总行数
     * @throws SQLException
     */
    public Object selectTotalCount(Connection connection,String sql) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Object query = queryRunner.query(connection, sql, new ScalarHandler());
        return query;
    }

}

package com.offcn.dao.impl;

import com.offcn.bean.Student;
import com.offcn.dao.StudentDao;
import com.offcn.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectByKeyWord(String keyword) {

        List<Student> list = null;
        Connection connection =null;

        try {
            connection= JDBCUtils.getConnection();

            QueryRunner queryRunner = new QueryRunner();

            String sql="select * from student where sname like ?";

             list= queryRunner.query(connection, sql, new BeanListHandler<>(Student.class), "%" + keyword + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}

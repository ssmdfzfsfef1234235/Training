package com.offcn.dao.impl;

import com.offcn.bean.Student;
import com.offcn.dao.StudentDao;
import com.offcn.utils.JDBCUtils;
import com.offcn.utils.PageUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    QueryRunner queryRunner = new QueryRunner();

    public int selectCount(String sname ,String gender){

        StringBuffer sqlBuffer = new StringBuffer("select count(*) from student where 1=1");

        if (sname !=null&& !("".equals(sname))){
            sqlBuffer.append(" and sname like '%" + sname +"%'");
        }

        //and gender = '0'
        if ("0".equals(gender) || "1".equals(gender)){
            sqlBuffer.append(" and gender=" + gender);
        }

        String sql = sqlBuffer.toString();

        Connection connection=null;
        int count = 0;
        try {
            connection= JDBCUtils.getConnection();

            Object o = queryRunner.query(connection, sql, new ScalarHandler());
            Long number = (Long) o;
            count = number.intValue();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int deleteStudent(String ids) {

        Connection connection = null;
        int count = 0;
        try {
            connection = JDBCUtils.getConnection();

            String sql="delete from student where sid in("+ids+")";
            count = queryRunner.update(connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public Student selectById(Integer sid) {

        Connection connection = null;
        Student query = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql="select * from student where sid = ?";
             query= queryRunner.query(connection, sql, new BeanHandler<>(Student.class), sid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return query;
    }

    @Override
    public int updateStudent(Student student) {

        Connection connection = null;
        int count = 0;
        try {
            connection = JDBCUtils.getConnection();

            String sql="update student set sname=? , gender = ?,sbir=? ,hobby=? ,photo=? where sid=?";
             count= queryRunner.update(connection, sql, student.getSname(), student.getGender(), student.getSbir(), student.getHobby(), student.getPhoto(), student.getSid());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public List<Student> selectByPage(PageUtils pageUtils,String sname, String gender){
        StringBuffer sqlBuffer=new StringBuffer("select * from student where 1=1");

        //sname like '%内容%' and gender = '0'
        if (sname != null && !("".equals(sname))){
            sqlBuffer.append(" sname like '%"+sname+"%'");
        }
        //and gender = '0'
        if ("0".equals(gender) || "1".equals(gender)){
            sqlBuffer.append(" and gender=" + gender);
        }

        sqlBuffer.append(" limit ?,?");

        String sql = sqlBuffer.toString();

        Connection connection=null;
        List<Student> query = null;

        try {
            connection = JDBCUtils.getConnection();

            query = queryRunner.query(connection, sql, new BeanListHandler<>(Student.class), pageUtils.getStartIndex(), pageUtils.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return query;
    }

    @Override
    public int addStudent(Student student) {
        Connection connection =null;
        int update = 0;
        try {
            connection= JDBCUtils.getConnection();

            String sql="insert into student values(null,?,?,?,?,?)";
            update = queryRunner.update(connection, sql, student.getSname(), student.getGender(), student.getSbir(), student.getHobby(), student.getPhoto());

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return update;
    }
}

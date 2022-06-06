package com.offcn.dao.Impl;

import com.offcn.bean.Person;
import com.offcn.dao.PersonDao;
import com.offcn.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonDaoImpl extends BaseDao implements PersonDao {

    @Override
    public int insert(Person person) {
        int count = 0;
        Connection connection;
        try {
            connection = JDBCUtils.getConnection();
            String sql="insert into person values(null,?,?,?)";
            count = update(connection, sql, person.getPname(), person.getAge(), person.getGender());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int delete(int id) {
        int count = 0;
        Connection connection;
        try {
            connection = JDBCUtils.getConnection();
            String sql="delete from person where id = ?";
            count = update(connection, sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int update(int id,String name) {
        int count = 0;
        Connection connection;
        try {
            connection = JDBCUtils.getConnection();
            String sql="update person set pname = ? where id = ?";
            count = update( connection , sql , name , id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Person selectById(int id) {
        Person person = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="select * from person where id=?";
            person = selectOne(Person.class, connection, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public List<Person> selectAll() {
        List<Person> people = null ;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="select * from person";
            people = selectAll(Person.class, connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public Object selectSpe() {
        Object o = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="select count(*) from person";
            o = selectSpe(connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
}

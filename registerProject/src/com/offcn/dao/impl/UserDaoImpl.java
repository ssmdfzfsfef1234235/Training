package com.offcn.dao.impl;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public int insert(User user) {
        int count = 0;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="insert into user values(null,?,?,?,?)";
            count = update(connection, sql, user.getName(), user.getAge(), user.getGender(), user.getAddress());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public int delete(Integer id) {
        int count = 0;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="delete from user where id=?";
            count = update(connection, sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateAge(User user) {
        int count = 0 ;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="update user set age = ? where name = ?";
            count= update(connection, sql, user.getAge(), user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateGender(User user) {
        int count = 0 ;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="update user set gender = ? where name = ?";
            count= update(connection, sql, user.getGender(), user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int updateAddress(User user) {
        int count = 0 ;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="update user set address = ? where name = ?";
            count= update(connection, sql, user.getAddress(), user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public User selectByName(String name) {
        User user = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="select * from user where  name = ?";
            user = selectOne(User.class, connection, sql, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAll() {
        List<User> users = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="select * from user";
            users= selectAll(User.class, connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Object selectCount() {
        Object o = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql="select count(*) from user";
             o = selectTotalCount(connection, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return o;
    }
}

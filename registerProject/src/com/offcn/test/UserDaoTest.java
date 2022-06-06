package com.offcn.test;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.dao.impl.UserDaoImpl;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    private UserDao userDao =new UserDaoImpl();

    @Test
    public void insert() {
        User user = new User(null, "张三", 22, "女", "湖南邵阳");
        int insert = userDao.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    public void delete() {

        int delete = userDao.delete(1);
        System.out.println("delete = " + delete);

    }

    @Test
    public void updateAge() {
        User user = new User(null, "张三", 23, "女", "湖南邵阳");

        int i = userDao.updateAge(user);
        System.out.println("i = " + i);
    }

    @Test
    public void updateGender() {
        User user = new User(null, "张三", 23, "男", "湖南邵阳");

        int i = userDao.updateGender(user);
        System.out.println("i = " + i);
    }

    @Test
    public void updateAddress() {
        User user = new User(null, "张三", 23, "女", "湖南长沙");

        int i = userDao.updateAddress(user);
        System.out.println("i = " + i);
    }

    @Test
    public void selectByName() {
        User user = userDao.selectByName("张三");
        System.out.println("user = " + user);
    }

    @Test
    public void selectAll() {
        List<User> users = userDao.selectAll();
        System.out.println("users = " + users);
    }

    @Test
    public void selectCount() {
        Object o = userDao.selectCount();
        System.out.println("o = " + o);
    }
}
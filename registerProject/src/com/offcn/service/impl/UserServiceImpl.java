package com.offcn.service.impl;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.dao.impl.UserDaoImpl;
import com.offcn.service.UserService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

public class UserServiceImpl implements UserService {
    private UserDao userDao =new UserDaoImpl();

    @Override
    public int registerUser(User user) {
        int result = 0 ;
        //选查询，不存在再添加
        if (userDao.selectByName(user.getName()) == null){
             result= userDao.insert(user);
        }
        //存在不添加
        return result;
    }
    @Test
    public void testRegisterUser(){
        int result = 0 ;
        User user = new User(null, "王五", 23, "女", "娄底");
        if (userDao.selectByName(user.getName())==null){
            result= userDao.insert(user);
        }

    }
}

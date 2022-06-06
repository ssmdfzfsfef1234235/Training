package com.offcn.service;

import com.offcn.bean.User;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return 添加成功返回0，添加成功返回1
     */
    int registerUser(User user);
}

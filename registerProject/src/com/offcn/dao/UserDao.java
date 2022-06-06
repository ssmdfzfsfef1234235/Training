package com.offcn.dao;

import com.offcn.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 插入一个数据
     * @param user
     * @return 0表示失败，正整数表示成功
     */
    int insert(User user);

    /**
     * 根据ID删除一条记录
     * @param id
     * @return 0表示失败，正整数表示成功
     */
    int delete(Integer id);

    /**
     * 根据用户名修改年龄
     * @param user
     * @return 0表示失败，正整数表示成功
     */
    int updateAge(User user);

    /**
     * 根据用户名修改性别
     * @param user
     * @return 0表示失败，正整数表示成功
     */
    int updateGender(User user);

    /**
     * 根据用户名修改地址
     * @param user
     * @return 0表示失败，正整数表示成功
     */
    int updateAddress(User user);

    /**
     * 根据ID查询
     * @param name
     * @return 查到返回user查不到返回null
     */
    User selectByName(String name);

    /**
     * 查询全部用户数据
     * @return null表示失败，返回集合表示成功
     */
    List<User> selectAll();

    /**
     * 查询用户总数
     * @return 返回具体的行数表示成功
     */
    Object selectCount();
}

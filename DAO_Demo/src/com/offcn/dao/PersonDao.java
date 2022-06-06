package com.offcn.dao;

import com.offcn.bean.Person;

import java.util.List;

public interface PersonDao {
    /**
     * 添加一条数据
     * @return 如果成功返回影响的行数是个正整数，如果失败返回0
     */
    int insert(Person person);

    /**
     * 删除一条数据
     * @return 如果成功返回影响的行数是个正整数，如果失败返回0
     */
    int delete(int id);

    /**
     * 修改一条数据,根据ID修改name属性
     * @return
     */
    int update(int id,String name);

    /**
     * 查询一条数据
     * @return 如果返回对象，则查询成功，如果是null,则查询失败
     */
    Person selectById(int id);

    /**
     * 查询所有数据
     * @return
     */
    List<Person> selectAll();

    /**
     * 查询特殊值
     * @return
     */
    Object selectSpe();

}

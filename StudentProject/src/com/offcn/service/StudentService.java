package com.offcn.service;

import com.offcn.bean.Student;
import com.offcn.utils.PageUtils;

import java.util.List;

public interface StudentService {
    /**
     * 插入一条记录
     * @return  插入成功返回true
     */
    boolean addStudent(Student student);

    /**
     *  分页模糊查询符合条件的记录
     * @return  如果尾null，则没有符合条件的数据
     */
    List<Student> selectByPage(PageUtils pageUtils, String sname, String gender);

    /**
     *查询记录
     * @return 大于0的正整数怎么证明查到了相应内容
     */
    int selectCount(String sname ,String gender);

    /**
     * 删除学生
     * @param ids
     * @return  删除成功返回true
     */
    boolean deleteStudent(String ids);

    /**
     * 根据ID查询学生对象信息
     * @return null，表示没查到
     */
    Student selectById(String sid);

    /**
     * 修改学生对象
     * @return 修改成功返回true
     */
    boolean updateStudent(Student student);
}

package com.offcn.service;

import com.offcn.bean.Student;

import java.util.List;

public interface StudentService {
    /**
     *根据参数关键字查询数据库中对应的数据
     * @return 如果查询成功，则返回一个集合
     */
     List<Student> search(String keyword);
}

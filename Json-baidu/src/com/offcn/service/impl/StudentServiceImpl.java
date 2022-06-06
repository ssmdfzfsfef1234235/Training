package com.offcn.service.impl;

import com.offcn.bean.Student;
import com.offcn.dao.StudentDao;
import com.offcn.dao.impl.StudentDaoImpl;
import com.offcn.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao=new StudentDaoImpl();

    @Override
    public List<Student> search(String keyword) {
        return studentDao.selectByKeyWord(keyword);
    }

}

package com.offcn.service.Impl;

import com.offcn.bean.Student;
import com.offcn.dao.StudentDao;
import com.offcn.dao.impl.StudentDaoImpl;
import com.offcn.service.StudentService;
import com.offcn.utils.PageUtils;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean addStudent(Student student) {
        return studentDao.addStudent(student) > 0 ? true : false;
    }

    @Override
    public List<Student> selectByPage(PageUtils pageUtils, String sname, String gender) {
        return studentDao.selectByPage(pageUtils, sname, gender);
    }

    @Override
    public int selectCount(String sname, String gender) {
        return studentDao.selectCount(sname, gender);
    }

    @Override
    public boolean deleteStudent(String ids) {
        return studentDao.deleteStudent(ids) > 0 ? true : false;
    }

    @Override
    public Student selectById(String sid) {
        return studentDao.selectById(Integer.parseInt(sid));
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student) > 0 ? true : false;
    }
}

package com.offcn.test;

import com.offcn.bean.Student;
import com.offcn.dao.StudentDao;
import com.offcn.dao.impl.StudentDaoImpl;
import org.junit.Test;

public class StudentDaoTest {

    private StudentDao studentDao=new StudentDaoImpl();

    @Test
    public void test1(){
        int i = studentDao.selectCount(null, "1");
        System.out.println("i = " + i);
    }

    @Test
    public  void test2(){
        Student student = studentDao.selectById(1);
        System.out.println("student = " + student);
    }
    @Test
    public  void test3(){
        Student student = studentDao.selectById(1);
        int i = studentDao.updateStudent(student);
        System.out.println("i = " + i);
    }
}

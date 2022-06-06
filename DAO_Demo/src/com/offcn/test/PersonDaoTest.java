package com.offcn.test;

import com.offcn.bean.Person;
import com.offcn.dao.Impl.PersonDaoImpl;
import com.offcn.dao.PersonDao;
import com.offcn.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonDaoTest {

    private PersonDao personDao=new PersonDaoImpl() ;


    @Test
    public void  testInsert(){

        Person person = new Person();
        person.setPname("tianqi");
        person.setAge(27);
        person.setGender("女");

        int insert = personDao.insert(person);
        System.out.println(person);

    }
    @Test
    public void  testDelete() throws SQLException {
        int delete = personDao.delete(5);
        System.out.println("delete = " + delete);
    }
    @Test
    public void  testUpdate(){

        int zomba = personDao.update(5, "zomba");
        System.out.println("zomba = " + zomba);
    }
    @Test
    public void  testSelectOne(){
        Person person = personDao.selectById(4);
        System.out.println("person = " + person);

    }
    @Test
    public void  testSelectAll(){
        List<Person> people = personDao.selectAll();
        System.out.println("people = " + people);

    }
    @Test
    public void  testSelectSpe(){
        Object o = personDao.selectSpe();
        System.out.println("o = " + o);

    }


}

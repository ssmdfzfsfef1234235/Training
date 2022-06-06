package com.offcn.test.day9;

import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CRUDIntegrate {
    @Test
    public void testQueryAll(){
         String sql="select * from users ";
        List<Users> users = queryAll(Users.class, sql);
        System.out.println("users = " + users);

    }
    public static <T> List<T> queryAll(Class<T> clazz,String sql){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //2.预编译
            preparedStatement = connection.prepareStatement(sql);
            //3.执行sql获取结果集
            resultSet = preparedStatement.executeQuery();
            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取列数
            int columnCount = metaData.getColumnCount();
            //创建集合用于储存将来的结果集
            List<T> ts = new ArrayList<T>();
            //5.处理结果集
            while (resultSet.next()){
                T t = clazz.newInstance();
                //遍历列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object value = resultSet.getObject(i + 1);
                    //获取列名
                    String name = metaData.getColumnLabel(i + 1);
                    //反射将获取到的数据赋值给具体对象的对应字段
                    //②从类中解剖指定名称的字段
                    Field field = clazz.getDeclaredField(name);
                    //③暴力访问设置访问权限
                    field.setAccessible(true);
                    //④反射给具体的对象的具体的字段赋具体的值
                    field.set(t,value);

                }
                ts.add(t);

            }
        return ts;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }

  return null;
    }
    @Test
    public void testQueryOne(){
        String sql="select * from emp where eid = ?";
        Emp emp = queryOne(Emp.class, sql, 1);
        System.out.println("emp = " + emp);

//        String sql="select * from users where id = ?";
//        Users users = queryOne(Users.class, sql, 1);
//        System.out.println("users = " + users);
    }
    public static <T> T queryOne(Class<T> clazz,String sql,Object... obj){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //2.预编译
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < obj.length; i++) {
                preparedStatement.setObject(i+1,obj[i]);
            }
            //3.执行sql获取结果集
            resultSet = preparedStatement.executeQuery();
            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取列数
            int columnCount = metaData.getColumnCount();

            //5.处理结果集
            if (resultSet.next()){
                T t = clazz.newInstance();
                //遍历列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object value = resultSet.getObject(i + 1);
                    //获取列名
                    String name = metaData.getColumnLabel(i + 1);
                    //反射将获取到的数据赋值给具体对象的对应字段
                    //②从类中解剖指定名称的字段
                    Field field = clazz.getDeclaredField(name);
                    //③暴力访问设置访问权限
                    field.setAccessible(true);
                    //④反射给具体的对象的具体的字段赋具体的值
                    field.set(t,value);

                }
                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }

  return null;
    }
    @Test
    public void testUpdate(){
//        String sql="insert into emp values(?,?,?,?,?)";
//        update(sql,null,"张三","经理", Date.valueOf("2000-01-14"),18000);
        String sql="delete from emp where eid=?";
        update(sql,1);
//        String sql="update emp set ename ='wangwu' where eid=?";
//        update(sql,1);
    }
    public static void update(String sql,Object... obj){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            connection = JDBCUtils.getConnection();
            //2.预编译
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < obj.length; i++) {
                preparedStatement.setObject(i+1,obj[i]);
            }
            //3.执行sql返回受到影响的行数
            int i = preparedStatement.executeUpdate();
            System.out.println("i = " + i);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResource(connection,preparedStatement,null);
        }

    }
        @Test
    public void testBatch(){
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                //1.获取连接
                connection = JDBCUtils.getConnection();
                //2.预编译
                String sql="insert into users values (?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                //填充占位符
                for (int i = 0; i < 10; i++) {
                    preparedStatement.setObject(1,null);
                    preparedStatement.setObject(2,"xuxu");
                    preparedStatement.setObject(3,"123");
                    preparedStatement.addBatch();
                }
                //3.执行sql返回受到影响的行数
                int[] ints = preparedStatement.executeBatch();
                System.out.println(Arrays.toString(ints));

                preparedStatement.clearBatch();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //5.关闭资源
                JDBCUtils.closeResource(connection,preparedStatement,null);
            }
        }

}

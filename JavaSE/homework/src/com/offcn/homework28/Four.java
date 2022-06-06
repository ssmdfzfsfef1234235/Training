package com.offcn.homework28;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*4、有配置文件config.properties,内容如下:
className=com.zgjy.reflect.Person
methodName=eat
要求: 通过反射的方式,运行配置文件中Person类的eat方法*/
public class Four {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        InputStream resourceAsStream = Four.class.getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");
        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(o);
    }
}
class Person{
    public static void eat(){
        System.out.println("renzaichifan");
    }
}

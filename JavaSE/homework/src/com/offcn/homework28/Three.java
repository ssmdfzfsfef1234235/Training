package com.offcn.homework28;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/*已知一个类，定义如下：
	 package com.ujiuye.homework;
	 public class DemoClass {
		public void run() {
			System.out.println("welcome to ujiuye!");
		}
	 }
	(1) 写一个Properties格式的配置文件，配置类的完整名称。
	(2) 写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，用反射的方式运行run方法。*/
public class Three {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.获取流    E:\IDEA\CODE\JavaSE\homework\src\com\offcn\homework28\test.properties

        InputStream is = Three.class.getClassLoader().getResourceAsStream("test.properties");
        //2.加载配置文件
        Properties p = new Properties();
        p.load(is);
//        3.获取类
        String classname = p.getProperty("classname");
        Class<?> aClass = Class.forName(classname);
        //4.实例化
        Object o = aClass.newInstance();
        Method run = aClass.getMethod("run");
        run.invoke(o);

    }
}
class DemoClass {
    public void run() {
        System.out.println("welcome to ujiuye!");
    }
}

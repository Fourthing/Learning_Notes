//package com.niko.reflect;
//
//import com.niko.domain.Person;
//import com.niko.domain.Student;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.Properties;
//
///*
//* 框架类
//* */
//public class ReflectExample {
//    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        //可以创建任意类的对象
//        //可以执行任意方法
//
//        //这种操作的弊端是需要经常实时修改代码的
////        Person person=new Person();
////        person.eat();
//
////        Student student = new Student();
////        student.sleep();
//
//        //1.加载配置文件
//            //1.1创建Properties对象
//        Properties prop = new Properties();
//            //1.2加载配置文件，转换为一个集合
//                //1.2.1获取class目录下的配置文件
//        ClassLoader classLoader = ReflectExample.class.getClassLoader();
//        InputStream in = classLoader.getResourceAsStream("D:\\JavaLearning\\JavaWeb\\Demo01_JUnitTest\\src\\main\\java\\com\\niko\\application.properties");
//        prop.load(in);
//        in.close();
//
//        // 输出读取到的文件内容以确认
//        System.out.println("Successfully loaded configuration:");
//        prop.forEach((key, value) -> System.out.println(key + ": " + value));
//
//        //2.获取配置文件中定义的数据
//        String className = prop.getProperty("className");
//        String MethodName = prop.getProperty("methodName");
//
//        //3.加载该类进内存
//        Class cls=Class.forName(className);
//        //4.创建对象
//        Object obj=cls.getDeclaredConstructor().newInstance();
//        //5.获取方法对象
//        Method method=cls.getMethod(MethodName);
//        //6.执行方法
//        method.invoke(obj);
//
//    }
//}
package com.niko.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectExample {
    public static void main(String[] args) {
        try {
            // 加载配置文件
            Properties prop = new Properties();
            ClassLoader classLoader = ReflectExample.class.getClassLoader();
            InputStream in = classLoader.getResourceAsStream("src/application.properties");

            // 添加空检查
            if (in == null) {
                System.err.println("Configuration file not found: application.properties");
                return;
            }

            // 读取配置文件
            prop.load(in);
            in.close(); // 记得关闭输入流

            // 输出读取到的文件内容以确认
            System.out.println("Successfully loaded configuration:");
            prop.forEach((key, value) -> System.out.println(key + ": " + value));

            // 检查属性是否为空
            if (prop.isEmpty()) {
                System.out.println("Warning: The configuration file is empty.");
                return;
            }

            // 获取配置文件中定义的数据
            String className = prop.getProperty("className");
            String methodName = prop.getProperty("methodName");

            // 动态加载类和执行方法
            Class<?> cls = Class.forName(className);
            Object obj = cls.getDeclaredConstructor().newInstance(); // 使用反射的构造函数
            Method method = cls.getMethod(methodName);
            method.invoke(obj);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
package com.niko.reflect;

import com.niko.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectDemo4 {
    /*
    * 获取功能
        1. 获取成员变量们
           - `Field[] getFields()`
           - `Field getField(String name)`
           - `Field[] getDeclaredFields()`
           - `Field getDeclaredField(String name)`
        2. 获取构造方法们
           - `Constructor<?>[] getConstructors()`
           - `Constructor<?> getConstructor(类<?>...parameterTypes)`
           - `Constructor<?>[] getDeclaredConstructors()`
           - `Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)`
        3. 获取成员方法们
           - `Method[] getMethods()`
           - `Method getMethod(String name,类<?>...parameterTypes)`
           - `Method[] getDeclaredMethods()`
           - `Method getDeclaredMethod(String name,类<?>...parameterTypes)`
        4. 获取类名
           - `String getName()`
    * */
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //0.获取Person的Class对象
        Class personClass = Person.class;
        /*
        3. 获取成员方法们
           - `Method[] getMethods()`
           - `Method getMethod(String name,类<?>...parameterTypes)`
           - `Method[] getDeclaredMethods()`
           - `Method getDeclaredMethod(String name,类<?>...parameterTypes)`
        */
        //获取指定名称的方法
        Method eat_method=personClass.getMethod("eat");
        Person person=new Person();
        //执行方法
        eat_method.invoke(person);

        Method eat_method2=personClass.getMethod("eat",String.class);
        //执行方法
        eat_method2.invoke(person,"noodles");

        System.out.println("----------------");

        //获取所有public修饰的方法(包括一些Object的方法)
        Method[] methods=personClass.getMethods();
        for (Method method:methods){
            System.out.println(method);
            System.out.println(method.getName());
        }

        System.out.println("----------------");

        //获取类名
        System.out.println(personClass.getName());
    }
}

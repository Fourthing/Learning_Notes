package com.niko.reflect;

import com.niko.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo3 {
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
           2. 获取构造方法们
           - `Constructor<?>[] getConstructors()`
           - `Constructor<?> getConstructor(类<?>...parameterTypes)`
           - `Constructor<?>[] getDeclaredConstructors()`
           - `Constructor<?> getDeclaredConstructor(类<?>...parameterTypes)`
         */
        Constructor constructor=personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建对象1
        Object person=constructor.newInstance("张三",23);
        System.out.println(person);
        System.out.println("----------------");

        Constructor constructor2=personClass.getConstructor();
        System.out.println(constructor2);
        //创建对象2
        Object person2=constructor2.newInstance();
        System.out.println(person2);
        System.out.println("---------------");

        //空参的情况
        Object o=personClass.newInstance();
        System.out.println(o);
    }
}

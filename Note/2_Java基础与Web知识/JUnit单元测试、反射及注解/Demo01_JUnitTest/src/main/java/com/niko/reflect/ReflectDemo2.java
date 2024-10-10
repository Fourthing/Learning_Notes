package com.niko.reflect;

import com.niko.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
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
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //0.获取Person的Class对象
        Class personClass = Person.class;
        //1.`Field[] getFields()` :获取所有public修饰的成员变量
        Field[] Field = personClass.getFields();
        for (Field f : Field) {
            System.out.println(f.getName());
        }

        System.out.println("-----------");
        //2.`Field getField(String name)`: 获取指定的public修饰的成员变量
            Field a = personClass.getField("a");

            //获取成员变量a的值
            Person person = new Person();
                //忽略访问权限修饰符的安全检查
                a.setAccessible(true);
            Object value=a.get(person);
            System.out.println(value);

            //设置成员变量a的值
            a.set(person,"NiKo");
            System.out.println(person.toString());
            System.out.println("-----------");

        //3.`Field[] getDeclaredFields()`:获取所有的成员变量,不考虑修饰符(安全性不好)
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field f : declaredFields) {
            System.out.println(f);
        }
        //4.`Field getDeclaredField(String name)`:获取指定的单个成员变量,不考虑修饰符
        Field b=personClass.getDeclaredField("b");
        b.setAccessible(true);
        Object value2=b.get(person);
        System.out.println(value2);

    }
}

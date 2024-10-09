package com.niko.reflect;

import com.niko.domain.Person;

public class ReflectDemo{
    /*
    * 获取Class类的三种方式
    * */
    public static void main(String[] args) throws ClassNotFoundException {

        //1.Class.forName("全类名")
        Class clazz = Class.forName("com.niko.domain.Person");
        //这里sout输出对象一般会调用对象的toString方法输出一个字符串
        System.out.println(clazz);

        //2.类名.class
        Class clavv=Person.class;
        System.out.println(clavv);

        //3.对象.getClass()
        Person person=new Person();
        Class <? extends Person> clabb=person.getClass();
        System.out.println(clabb);

        //试比较三个对象
        System.out.println(clazz == clavv);
        System.out.println(clazz == clabb);
        System.out.println(clabb == clavv);
    }
}

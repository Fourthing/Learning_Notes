package com.niko.domain;

public class Person {
    private String name;
    private int age;
    public String a;
    private String b;
    String c;
    protected String d;
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
    public void eat(){
        System.out.println("Eating!");
    }
    public void eat(String food){
        System.out.println("Eating "+food+"!");
    }
}

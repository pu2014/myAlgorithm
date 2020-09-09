package com.面试题;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/9/8 18:17
 */
public class Test {
    public static void main(String[] args) {
        new Student();
    }
}
class Person{
    public  String name = "person";
    public Person(){
        sayName();
    }
    public void sayName(){
        System.out.println(name);
    }
}
class Student extends Person{
    public  String name = "student";
    public void sayName(){
        System.out.println(name);
    }
}

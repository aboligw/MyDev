package com.project.tutorial.random;


public class Person {
    private int age;
    private int name;

    public Person() {
        super();
    }

    public void displayMsg(String pMsg) {
        System.out.println("This is just a simple method to demonstrate reflection method calling " + pMsg);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }
}

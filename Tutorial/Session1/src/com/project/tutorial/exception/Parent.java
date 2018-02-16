package com.project.tutorial.exception;

import com.project.tutorial.report.MySecurityException;


public class Parent {
    private String fName;
    private String lName;
    private int age;


    public Parent(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    Parent() {
    }

    public void displayMsg() throws MySecurityException, ArithmeticException {
        System.out.println("this is parent");
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getFName() {
        return fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getLName() {
        return lName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

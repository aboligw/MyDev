package com.project.tutorial.abstractdemo;

public class Class1 {
    private int Test1() {
    return 0;
    }

    public static void main(String[] args) { 
        Class1 class1 = new B();
        System.out.println(class1.Test1());
    }
}
class B extends 
Class1{
    public int Test1(){
       return 9; 
    }
}

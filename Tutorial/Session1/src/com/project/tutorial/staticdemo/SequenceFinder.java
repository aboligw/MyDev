package com.project.tutorial.staticdemo;

public class SequenceFinder {
    static{
        System.out.println("This is static block");
    } {
        System.out.println("This is normal block");
    }
    
    public SequenceFinder() {
        System.out.println("this is constructor");
    }

    public static void main(String[] args) {
        SequenceFinder obj1 = new SequenceFinder();
        SequenceFinder obj2 = new SequenceFinder();
    }
}

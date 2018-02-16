package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

import java.io.File;

public class DeadlockDemo {

    public static File f1 = new File("Test1.txt");
    public static File f2 = new File("Test2.txt");

    public DeadlockDemo() {
        super();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Class1();
        Thread t2 = new Class2();


        t1.start();
        display(Thread.currentThread() + "woke up");
        t2.start();

    }


}

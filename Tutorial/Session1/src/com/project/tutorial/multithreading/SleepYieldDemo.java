package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

import java.io.File;

public class SleepYieldDemo {
    public SleepYieldDemo() {
        super();
    }
    public static File f = new File("Read.txt");

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Class1();
        Thread t2 = new Class2();


        t1.start();
        display(Thread.currentThread() + "woke up");
        t2.start();

    }


}

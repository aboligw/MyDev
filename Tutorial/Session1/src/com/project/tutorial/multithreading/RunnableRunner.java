package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

public class RunnableRunner {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new RunnableDemo());
        display("Name - " + t1.getName());
        display("Priority-" + t1.getPriority());
        t1.start();
        Thread.currentThread().sleep(1000);
        display("After sleeping" + t1.getState());
        t1.join();
        display("After ending " + t1.getState());
    }
}

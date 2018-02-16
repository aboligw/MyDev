package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

public class ThreadRunner {

    public static void main(String[] args) throws InterruptedException {
        ThreadClassDemo obj1 = new ThreadClassDemo();
        display("Name of thread -" + obj1.getName());
        display("Priority" + obj1.getPriority());
        obj1.start();
        Thread.currentThread().sleep(1000);
        display("Sleeping." + obj1.getState());
        obj1.join();
        display("Exiting main method." + obj1.getState());


    }
}

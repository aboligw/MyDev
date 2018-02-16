package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

public class RunnableDemo implements Runnable {
    public RunnableDemo() {
        super();
    }

    @Override
    public void run() {
        display("Enter run " + Thread.currentThread().getName());
        display("state is " + Thread.currentThread().getState());
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        display("Exit run()" + Thread.currentThread().getState());
        // TODO Implement this method
    }

}

package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

public class ThreadClassDemo extends Thread {
    public ThreadClassDemo() {
        super();
    }

    public synchronized void start() {
        display("In start() method." + this.getState());
        super.start();
        display("Exit start() method." + this.getState());
    }

    public void run() {
        display("In run now!" + this.getState());
        //       super.run();

        try {
            this.sleep(10000);
            //   display("Sleeping " + this.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        display("Exit run() method" + this.getState());
    }

}

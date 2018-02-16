package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Class1 extends Thread {
    public Class1() {
        super();
    }

    public void run() {
        System.out.println("In run Class1");
        this.reader();
        display("Exit run() Class1");

    }

    private synchronized void reader() {
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        File f1 = DeadlockDemo.f1;
        File f2 = DeadlockDemo.f2;
        String line1;
        //  synchronized (f1) {

        try {
            br1 = new BufferedReader(new FileReader(f1));
            br2 = new BufferedReader(new FileReader(f2));
            line1 = br1.readLine();
            while (line1 != null) {
                char[] c = line1.toCharArray();
                for (char ch : c) {
                    display("Class 1 - " + ch);
                    wait();
                    String line2 = br2.readLine();
                    display("In Class 1 - " + line2);
                }
                line1 = br1.readLine();
            } //while
        } catch (Exception e) {
            e.printStackTrace();
        }

        //       } //sync block
    }

}

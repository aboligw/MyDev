package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Class2 extends Thread {
    public Class2() {
        super();
    }

    public void run() {
        File f1 = DeadlockDemo.f1;
        File f2 = DeadlockDemo.f2;
        synchronized (f2) {
            synchronized (f1) {
                BufferedReader br2 = null;
                try {
                    br2 = new BufferedReader(new FileReader(f2));
                    String line2 = br2.readLine();
                    while (line2 != null) {
                        display("Class 2- " + line2);
                        f1.notify();
                        f2.wait();
                        line2 = br2.readLine();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

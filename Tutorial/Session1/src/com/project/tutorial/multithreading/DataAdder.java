package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;
import static com.project.tutorial.common.MyScanner.getString;

import java.io.File;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataAdder {
    public static int wordCnt = 0;
    public static String in = "Shlok";
    public static File out = new File("Output.txt");
    public static boolean flag = false;

    public DataAdder() {
        super();
    }

    public static void main(String[] args) throws InterruptedException {

        String ch = "y";
        while ("y".equalsIgnoreCase(ch)) {
            MenuThread tMenu = new MenuThread();
            tMenu.start();

            synchronized (tMenu) {
                tMenu.wait();
                switch (tMenu.getChoice()) {
                case 1:
                    //add to file
                    ExecutorService es = Executors.newFixedThreadPool(1);
                    AddThread t2 = new AddThread();
                    es.submit(t2);
                    es.shutdown();
                    break;
                case 2:
                    //Get count
                    display("Count is: " + DataAdder.wordCnt);
                    break;
                }
            }
            display("Want to continue?");
            ch = getString();


        }
    }

}

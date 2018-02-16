package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddThread extends Thread {
    public AddThread() {
        super();
    }

    public void run() {
        display("I am in add thread run()");
        write2File();
        display("Exit run() of add thread");
    }

    private void write2File() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(DataAdder.out));
            while (DataAdder.wordCnt <= 10000) {
                bw.write("\n" + DataAdder.in);
                DataAdder.wordCnt++;
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
            }
        }

    }

}

package com.project.tutorial.multithreading;

import static com.project.tutorial.common.MyScanner.display;
import static com.project.tutorial.common.MyScanner.getInt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MenuThread extends Thread {
    File f = new File("Menu.txt");
    private int choice;

    @Override
    public void run() {
        synchronized (this) {
            menuDisplay();
            display("Enter your choice");
            setChoice(getInt());
            notify();
        }
    }

    private void menuDisplay() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while (line != null) {
                display(line);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getChoice() {
        return choice;
    }

    private void setChoice(int i) {
        this.choice = i;
    }
}

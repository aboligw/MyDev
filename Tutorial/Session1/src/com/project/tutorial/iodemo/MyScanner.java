package com.project.tutorial.iodemo;

import static com.project.tutorial.common.MyScanner.display;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MyScanner {
    public MyScanner() {
        super();
    }

    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
            display("Enter the input now");
            String str = in.readLine();
            out.write(str);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                }

            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                }

        }

    }
}

package com.project.vb.common;

import java.util.Scanner;

public class MyScanner {
    public MyScanner() {
        super();
    }

    static Scanner scanner = new Scanner(System.in);

    public static void display(String s) {
        System.out.println(s);
    }

    public static int getInt() {
        return new Scanner(System.in).nextInt();
    }

    public static String getString() {
        return new Scanner(System.in).nextLine();
    }

    public static double getDouble() {
        return Double.parseDouble(getString());
    }

}


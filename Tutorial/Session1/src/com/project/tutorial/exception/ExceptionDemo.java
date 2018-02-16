package com.project.tutorial.exception;

import static com.project.tutorial.common.MyScanner.display;
import static com.project.tutorial.common.MyScanner.getInt;
import com.project.tutorial.report.MySecurityException;

public class ExceptionDemo {

    public static void main(String[] args) {
        int num;
        int deno;
        display("Enter numerator");
        num = getInt();
        display("Enter denominatoor");
        deno = getInt();
        checkThrow(num, deno);
        try {
            checkThrows(num, deno);
        } catch (MySecurityException e) {
            display("Div by 0");
        }
        unchecked(num, deno);
    }

    private static void checkThrows(int a, int b) throws MySecurityException {
        System.out.println("We are in checked exception" + a / b);

    }

    private static void unchecked(int num, int deno) {
        //   display("We r demonstrating unchecked exception");
        try {
            int ans = num / deno;
            display("Resuklts is :" + ans);
        } catch (RuntimeException e) {
            display("Its runtime exception");
        }
    }

    private static void checkThrow(int num, int deno) {
        try {
            if (0 == deno) {
                throw new MySecurityException("Deno is zero");
            } else {
                throw new NullPointerException("Deno is zero");
            }
            //  System.out.println("Result is eeeeeeee " + num / deno);
        } catch (MySecurityException e) {
            display("Caught" + e);
        } finally {
            System.exit(0);
        }
    }
}

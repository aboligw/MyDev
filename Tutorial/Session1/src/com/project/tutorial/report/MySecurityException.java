package com.project.tutorial.report;


public class MySecurityException extends Exception {

    public MySecurityException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public MySecurityException(Throwable throwable) {
        super(throwable);
    }

    public MySecurityException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public MySecurityException(String string) {
        super(string);
    }

    public MySecurityException() {
        super();
    }

    public String toString() {
        return ("You cannot access another subject report");
    }
}

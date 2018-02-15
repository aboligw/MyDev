package com.project.vb.common;


public class MyException extends Exception {
    private int code;

    public MyException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public MyException(Throwable throwable) {
        super(throwable);
    }

    public MyException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public MyException(String string) {
        super(string);
    }

    public MyException(int num) {
        super();
        this.code = num;
    }

    public String toString() {
        String str = " ";
        switch (this.code) {
        case -19:
            str = "Insert into Table Test failed";
            break;
        case -21:
            str = "No such student";
            break;
        case -11:
            str = "Invalid username";
            break;

        }
        return str;
    }
}

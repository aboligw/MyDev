package com.project.tutorial.jdbcdemo.user;

public class DbException extends Exception {
    public DbException(String string, Throwable throwable, boolean b, boolean b1) {
        super(string, throwable, b, b1);
    }

    public DbException(Throwable throwable) {
        super(throwable);
    }

    public DbException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public DbException(String string) {
        super(string);
    }

    public DbException() {
        super();
    }
}

package com.project.tutorial.executordemo;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<String> {
    public static int cnt;

    public CallableDemo() {
        super();
    }

    @Override
    public String call() throws Exception {
        System.out.println("I am in callable" + ++cnt);
        return "Success";
    }
}

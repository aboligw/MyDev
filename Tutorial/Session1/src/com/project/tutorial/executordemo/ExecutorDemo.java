package com.project.tutorial.executordemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
    public ExecutorDemo() {
        super();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService tp1 = Executors.newFixedThreadPool(1);
        ExecutorService tp2 = Executors.newFixedThreadPool(3);
        List<Callable<String>> l_tasks = new ArrayList<Callable<String>>();
        l_tasks.add(new CallableDemo());
        l_tasks.add(new CallableDemo());

        List<Future<String>> l_response = tp2.invokeAll(l_tasks);
        for (Future<String> l_resp : l_response) {
            System.out.println(l_resp.get());
        }
        tp2.shutdown();

        tp1.submit(new Runnable() {

            @Override
            public void run() {
                System.out.print("Async task");
            }
        });

        tp1.shutdown();
        System.out.println("In main");
    }
}

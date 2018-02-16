package com.project.tutorial.garbagecollectiondemo;


public class FinilizeDemo {
    public FinilizeDemo() {
        super();

    }

    public static void main(String[] args) throws Throwable {
        new FinilizeDemo();
        //obj1.finalize();
    }


    @Override
    protected void finalize() throws Throwable {
        // TODO Implement this method
        System.out.print("I am in finalize");
        super.finalize();
    }
}

package com.project.tutorial.exception;


public class ExceptionInInherDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Parent k = new Parent("Kiran", "Khamitkar", 30);
        Parent s = new Child();
        s.setLName("Shlok");
        s.setLName(k.getLName());
        try {
        s.displayMsg();
         }
        catch (Exception e) {
        System.out.println("Caught arith exception");
        }

    }
}

package com.project.tutorial.exception;

import com.project.tutorial.report.MySecurityException;


public class Child extends Parent {
    private String name;
    private String lName;

    public Child() {
        super();
    }

    public Child(String name, String lName) {
        super();
        this.name = name;
        this.lName = lName;
    }

    public void displayMsg() throws MySecurityException {
        System.out.println("We are in child class");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLName(String lName) {
        this.lName = super.getLName();
    }

    public String getLName() {
        return lName;
    }
}

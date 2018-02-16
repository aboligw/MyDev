package com.project.tutorial.jdbcdemo.model;


public class Student extends Model {
    private int id;
    private String name;
    private String branch;
    private String address;

    public Student() {
        super();
    }

    public Student(int id, String name, String branch, String address) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.address = address;
    }

    public String toString() {
        return "ID: " + id + " \nName: " + name + " \nBranch: " + branch + " \nAddress:" + address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}

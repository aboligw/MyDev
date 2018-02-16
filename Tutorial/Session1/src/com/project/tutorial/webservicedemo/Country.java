package com.project.tutorial.webservicedemo;


public class Country {
    private String id;
    private String name;

    public Country() {
        super();
    }

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

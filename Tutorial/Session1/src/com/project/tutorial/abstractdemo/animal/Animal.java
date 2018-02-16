package com.project.tutorial.abstractdemo.animal;

public abstract class Animal {
    private String name;
    private String type;
    
    public Animal(String p_name, String p_type) {
        this.name=p_name;
        this.type=p_type;
    }
    public abstract String getSound();
    public abstract String getCategory();
    
    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public void printDetails(){
        System.out.println("Type - " + getType());
        System.out.println("Name - " + getName());
        System.out.println("Sound - " + getSound());
        System.out.println("Category - " + getCategory());
    }
}

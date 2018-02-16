package com.project.tutorial.abstractdemo.animal;

public class Cat extends Animal{
    String category;
    String sound;
    public Cat(String p_name, String p_type) {
        super(p_name,p_type);
    }
    public String getSound(){
        return "MEOW";
    }
    public String getCategory(){
        return "Terrestrial";
    }
}

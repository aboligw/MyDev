package com.project.tutorial.abstractdemo.animal;
public class Dog extends Animal{
    String category;
    String sound;
    public Dog(String p_name, String p_type) {
        super(p_name,p_type);
    }
    public String getSound(){
        return "Woof Woof";
    }
    public String getCategory(){
        return "Terrestrial";
    }
}

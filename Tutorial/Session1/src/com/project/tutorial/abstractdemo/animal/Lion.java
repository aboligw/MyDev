package com.project.tutorial.abstractdemo.animal;
public class Lion extends Animal{
    String category;
    String sound;
    public Lion(String p_name, String p_type) {
        super(p_name,p_type);
    }
    public String getSound(){
        return "ROAR";
    }
    public String getCategory(){
        return "Terrestrial";
    }
}

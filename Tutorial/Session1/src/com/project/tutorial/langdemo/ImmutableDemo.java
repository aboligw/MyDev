package com.project.tutorial.langdemo;

public final class ImmutableDemo {
    private final String name;
    private final String surname;
    
    public ImmutableDemo(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public static void main(String[] args){
        ImmutableDemo obj1 = new ImmutableDemo("Narendra","Modi");
        System.out.println(obj1.name);
        System.out.println(obj1.surname);
        
       // obj1.name = "Asitkumar";
        
    }
}

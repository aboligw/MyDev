package com.project.tutorial.abstractdemo.animal;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        System.out.println("Enter the name of animal");
        Scanner sc=new Scanner(System.in);
        String name = sc.nextLine();
    
        System.out.println("Enter the type of animal");
        String type = sc.nextLine();
        
        switch (type){
        case "Cat":
            Cat c1 = new Cat(name,type);        
            c1.printDetails();
            break;
            
            case "Dog":
                Dog d1 = new Dog(name,type);        
                d1.printDetails();
                break;
        
            case "Lion":
                Lion l1 = new Lion(name,type);        
                l1.printDetails();
                break;
        }
    
    }
    
}

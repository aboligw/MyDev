package com.project.tutorial.abstractdemo.coffemachine;

import java.io.IOException;

import java.util.Scanner;

public class Starter {

    public static void main(String args[]){   
        boolean loopVar = true;
        String l_currItem = " ";
        String l_prevItem = " " ;
        while (loopVar){
        l_prevItem = l_currItem;    
        System.out.println("Enter the Desired Brand");
        System.out.println("1. Nescafe    2. BRU    3. MAXIM");
        Scanner sc = new Scanner(System.in);
        String ch = sc.nextLine();
        switch (ch){
        case "1":
            loopVar = false;
            Nescafe n1 = new Nescafe();
            n1.acceptCoffeeMenu();
            n1.acceptCoffeeType();
            l_currItem = n1.switchToCoffee();
            if (l_currItem.equals(l_prevItem)&& n1.printDecision){
                System.out.println("Making your Coffee");
            }
            else{
                n1.cleanMachine();  
            }
            System.out.println(n1);
            String moreDrink = n1.moreDrink();
            if (moreDrink.equals("Y")){
                n1.clearScreen();
                loopVar = true;
            }
            break;
        case "2":
            loopVar = false;
            Bru b1 = new Bru();
            b1.acceptCoffeeMenu();
            b1.acceptCoffeeType();
            l_currItem = b1.switchToCoffee();
            if (l_currItem.equals(l_prevItem)&& b1.printDecision){
                System.out.println("Making your Coffee");
            }
            else{
                b1.cleanMachine();
            }
            System.out.println(b1);
            moreDrink = b1.moreDrink();
            if (moreDrink.equals("Y")){
                b1.clearScreen();
                loopVar = true;
            }
            break;
        case "3":
            loopVar = false;
            Maxim m1 = new Maxim();
            m1.acceptCoffeeMenu();
            m1.acceptCoffeeType();
            l_currItem = m1.switchToCoffee();
            if (l_currItem.equals(l_prevItem)&& m1.printDecision){
                System.out.println("Making your drink");
            }
            else{
                m1.cleanMachine();
            }
            System.out.println(m1);
            moreDrink = m1.moreDrink();
            if (moreDrink.equals("Y")){
                m1.clearScreen();
                loopVar = true;
            }
            break;
        }
    }
    
    System.out.println("Thankyou for using this Coffee Machine.... See you next time");
    }
}
    


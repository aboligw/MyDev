package com.project.tutorial.abstractdemo.coffemachine;

import java.io.IOException;

import java.util.Scanner;

public abstract class CoffeeDispensor implements CoffeeMachine {
    private int milk;
    private int water;
    private int sugar;
    private int coffeeBean;
    private int teaPowder;
    private int temp;
    private String type;
    private String item;
    boolean printDecision = true;
    String result;
    protected static int waterQty = 500;
    protected static int sugarQty = 500;
    protected static int teaQty = 500;
    protected static int milkQty = 1000;
    protected static int coffeeBeanQty = 500;
    
    
    public void setMilk(int qty){
        this.milk = qty;
    }
    
    public void setSugar(int qty){
        this.sugar = qty;
    }
    
    public void setWater(int qty){
        this.water = qty;
    }
    
    public void setTemp(int qty){
        this.temp = qty;
    }
    
    public void setCoffeeBean(int qty){
        this.coffeeBean = qty;
    }
    
    public void setTeaPowder(int qty){
        this.teaPowder = qty;
    }
    //get choice of coffee
        public void acceptCoffeeMenu(){
            System.out.println("           MENU               ");
            System.out.println("1) " + EXPRESSO);
            System.out.println("2) " + AMERICANO);
            System.out.println("3) " + MILK);
            System.out.println("4) " + TEA);
            System.out.println("5) " + WATER);
            System.out.println("6) " + STEAM);
            System.out.println("7) " + CLEAN);
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);
                String choice = sc.nextLine();
    
            switch (choice) {
            case "1":
                this.item = EXPRESSO;
                break;
            case "2":
                this.item = AMERICANO;
                break;
            case "3":
                this.item = MILK;
                break;
            case "4":
                this.item = TEA;
                break;
            case "5":
                this.item = WATER;
                break;
            case "6":
                this.item = STEAM;
                break;
            case "7":
                this.item = CLEAN;
                break;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }
    //get choice of type
        public void acceptCoffeeType(){
            System.out.println("enter the type of coffee you want");
            System.out.println("1) HOT");
            System.out.println("2) COLD");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if(choice.equals("1") ){
                this.type = "HOT";
                }
            else{
                this.type = "COLD";
            }
            
        }
        public String switchToCoffee(){
            printDecision = true;
            switch (this.type){
            case "HOT":
                switch (this.item){
                case EXPRESSO:
                    if(waterQty > 0 && sugarQty > 0 && coffeeBeanQty > 0 && milkQty > 0){
                    getHotExpresso();
                    }
                    else{
                        printDecision = false;
                    }
                    break;
                case AMERICANO:
                    if(waterQty > 0 && coffeeBeanQty > 0){
                    getHotAmericano();
                    }
                    else{
                        printDecision = false;
                    }
                    break;
                case WATER:
                    if(waterQty > 0){
                    getHotWater();
                    }
                    else{
                        printDecision = false;
                    }
                    break;
                case TEA:
                    if(waterQty > 0 && sugarQty > 0 && teaQty > 0 && milkQty > 0){
                    getHotTea();
                    }
                    else{
                        printDecision = false;
                    }
                    break;
                case MILK:
                    if(milkQty > 0){
                    getHotMilk();
                    }
                    else{
                        printDecision = false;
                    }
                    break;
                case STEAM:
                    getSteam();
                    printDecision = false;
                    break;
                case CLEAN:
                    cleanMachine(); 
                    printDecision = false;
                    break; 
                }
                break;
            case "COLD":
                switch (this.item){
                    case EXPRESSO:
                    if(waterQty > 0 && sugarQty > 0 && coffeeBeanQty > 0 && milkQty > 0){
                        getColdExpresso();
                    }
                    else{
                        printDecision = false;
                    }
                        break;
                    case AMERICANO:
                    if(waterQty > 0 && coffeeBeanQty > 0){
                        getColdAmericano();
                    }
                    else{
                        printDecision = false;
                    }
                        break;
                    case WATER:
                    if(waterQty > 0){
                        getColdWater();
                    }
                    else{
                        printDecision = false;
                    }
                        break;
                    case TEA:
                    if(waterQty > 0 && sugarQty > 0 && teaQty > 0 && milkQty > 0){
                        getColdTea();
                    }
                    else{
                        printDecision = false;
                    }
                        break;
                    case MILK:
                    if(milkQty > 0){
                        getHotMilk();
                    }
                    else{
                        printDecision = false;
                    }
                        break;
                    case STEAM:
                        System.out.println("Steam cannot be COLD");
                        printDecision = false;
                        break;
                    case CLEAN:
                        cleanMachine();
                        printDecision = false;
                        break;
                }
                break;
            }
            return this.item;
        }
        
//display output
    @Override
    public String toString() {
        if (printDecision){    
     result ="Milk :" + this.milk; 
    result = result +"\n Coffee beans : " + this.coffeeBean;
    result = result +"\n Water : " + this.water;
    result = result +"\n sugar : " + this.sugar;
    result = result +"\n tea powder : " + this.teaPowder;
    result = result +"\n Temperature : " + this.temp;
    result = result +"\n Type : " + this.type;
        }
        else{
            if (this.item.equals(STEAM)){
            result = " ";
            }
            if (waterQty <= 0){
                result = "No more water avaiable";
            }
            if (milkQty <= 0){
                result = "No more milk avaiable";
            }
            if (teaQty <= 0){
                result = "No more tea powder avaiable";
            }
            if (coffeeBeanQty <= 0){
                result = "No more coffeebeans avaiable";
            }
            if (sugarQty <= 0){
                result = "No more sugar avaiable";
            }
        }
    return result;
    }
    public String moreDrink(){
        System.out.println("Press 'Y' to make another drink or 'N' to switch off Coffee machine");
        Scanner sc= new Scanner(System.in);
        return sc.nextLine();
    }
    public void clearScreen(){

        try{
            Runtime.getRuntime().exec("cls");
        } 
        catch (IOException e) {
            for (int i=0;i<30;i++)
            System.out.println();
        }
    }
}



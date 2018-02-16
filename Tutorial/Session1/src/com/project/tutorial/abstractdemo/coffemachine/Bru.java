package com.project.tutorial.abstractdemo.coffemachine;

public class Bru extends CoffeeDispensor{
    public Bru(){
        super();
    }
    public void getHotAmericano(){
        setMilk(0);
        setCoffeeBean(4);
        setWater(100);
        setTemp(90);
        setTeaPowder(0);
        setSugar(0);
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 4;
        }
    public void getHotExpresso(){
        setMilk(100);
        setCoffeeBean(4);
        setWater(80);
        setTemp(90);
        setTeaPowder(0);
        setSugar(20);                   
        waterQty = waterQty - 80;
        coffeeBeanQty = coffeeBeanQty - 4;
        sugarQty = sugarQty - 20;
        milkQty = milkQty - 100;
    }
    public void getHotTea(){
        setMilk(100);
        setCoffeeBean(0);
        setWater(100);
        setTemp(90);
        setTeaPowder(30);
        setSugar(30);                   
        waterQty = waterQty - 100;
        teaQty = teaQty - 30;
        sugarQty = sugarQty - 30;
        milkQty = milkQty - 100;
    }
    public void getHotWater(){
        setMilk(0);
        setCoffeeBean(0);
        setWater(100);
        setTemp(100);
        setTeaPowder(0);
        setSugar(0);            
        waterQty = waterQty - 100;
    }
    public void getHotMilk(){
        setMilk(100);
        setCoffeeBean(0);
        setWater(0);
        setTemp(100);
        setTeaPowder(0);
        setSugar(0);            
        milkQty = milkQty - 100;
    }
    public void getSteam(){
        System.out.println("Dispensing Steam from BRU");
    }
    public void cleanMachine(){
        System.out.println("Cleaned BRU machine");
    }
    
    public void getColdAmericano(){
        setMilk(0);
        setCoffeeBean(4);
        setWater(100);
        setTemp(0);
        setTeaPowder(0);
        setSugar(0);           
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 4;
        
    }
    public void getColdExpresso(){
        setMilk(100);
        setCoffeeBean(4);
        setWater(100);
        setTemp(0);
        setTeaPowder(0);
        setSugar(30);             
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 4;
        sugarQty = sugarQty - 30;
        milkQty = milkQty - 100;
    }
    public void getColdTea(){
        setMilk(90);
        setCoffeeBean(0);
        setWater(100);
        setTemp(0);
        setTeaPowder(30);
        setSugar(30);
        waterQty = waterQty - 100;
        teaQty = teaQty - 30;
        sugarQty = sugarQty - 30;
        milkQty = milkQty - 90;
    }
    public void getColdWater(){
        setMilk(0);
        setCoffeeBean(0);
        setWater(100);
        setTemp(0);
        setTeaPowder(0);
        setSugar(0);             
        waterQty = waterQty - 100;
    }
    public void getColdMilk(){
        setMilk(100);
        setCoffeeBean(0);
        setWater(0);
        setTemp(0);
        setTeaPowder(0);
        setSugar(0);             
        milkQty = milkQty - 100;
    }
}

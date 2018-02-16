package com.project.tutorial.abstractdemo.coffemachine;

public class Maxim extends CoffeeDispensor{
    public Maxim() {
        super();
    }
    public void getHotAmericano(){
        setMilk(0);
        setCoffeeBean(10);
        setWater(100);
        setTemp(80);
        setTeaPowder(0);
        setSugar(0); 
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 10;
    }
    public void getHotExpresso(){
        setMilk(100);
        setCoffeeBean(10);
        setWater(100);
        setTemp(90);
        setTeaPowder(0);
        setSugar(30);   
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 10;
        milkQty = milkQty - 100;
        sugarQty = sugarQty - 30;
    }
    public void getHotTea(){
        setMilk(80);
        setCoffeeBean(0);
        setWater(80);
        setTemp(90);
        setTeaPowder(20);
        setSugar(30);            
        waterQty = waterQty - 80;
        teaQty = teaQty - 20;
        sugarQty = sugarQty - 30;
        milkQty = milkQty - 80;
    }
    public void getHotWater(){
        setMilk(0);
        setCoffeeBean(0);
        setWater(80);
        setTemp(90);
        setTeaPowder(0);
        setSugar(0);           
        waterQty = waterQty - 80;
    }
    public void getHotMilk(){
        setMilk(100);
        setCoffeeBean(0);
        setWater(0);
        setTemp(90);
        setTeaPowder(0);
        setSugar(0);           
        milkQty = milkQty - 100;
    }
    public void getSteam(){
        System.out.println("Dispensing Steam from Maxim");
    }
    public void cleanMachine(){
        System.out.println("Cleaned Maxim machine");
    }
    
    public void getColdAmericano(){
        setMilk(0);
        setCoffeeBean(10);
        setWater(100);
        setTemp(0);
        setTeaPowder(0);
        setSugar(0);                   
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 10;
    }
    public void getColdExpresso(){
        setMilk(100);
        setCoffeeBean(10);
        setWater(100);
        setTemp(0);
        setTeaPowder(0);
        setSugar(30);             
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 10;
        milkQty = milkQty - 100;
        sugarQty = sugarQty - 30;
    }
    public void getColdTea(){
        setMilk(100);
        setCoffeeBean(0);
        setWater(100);
        setTemp(0);
        setTeaPowder(30);
        setSugar(60);            
        waterQty = waterQty - 100;
        teaQty = teaQty - 30;
        milkQty = milkQty - 100;
        sugarQty = sugarQty - 60;
    }
    public void getColdWater(){
        setMilk(0);
        setCoffeeBean(0);
        setWater(100);
        setTemp(0);
        setTeaPowder(0);
        setSugar(0);           
        waterQty = waterQty -100;
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

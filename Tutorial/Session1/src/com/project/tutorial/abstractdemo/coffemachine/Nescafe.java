package com.project.tutorial.abstractdemo.coffemachine;

public class Nescafe extends CoffeeDispensor{
    public Nescafe() {
        super();
    }
    public void getHotAmericano(){
        setMilk(0);
        setCoffeeBean(5);
        setWater(100);
        setTemp(90);
        setTeaPowder(0);
        setSugar(0); 
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 5;
        
    }
    public void getHotExpresso(){
        setMilk(100);
        setCoffeeBean(5);
        setWater(100);
        setTemp(90);
        setTeaPowder(0);
        setSugar(20);                   
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 5;
        sugarQty = sugarQty - 20;
        milkQty = milkQty - 100;
    }
    public void getHotTea(){
        setMilk(100);
        setCoffeeBean(0);
        setWater(100);
        setTemp(90);
        setTeaPowder(20);
        setSugar(20);           
        waterQty = waterQty - 100;
        teaQty = teaQty - 20;
        sugarQty = sugarQty - 20;
        milkQty = milkQty - 100;
    }
    public void getHotWater(){
        setMilk(0);
        setCoffeeBean(0);
        setWater(100);
        setTemp(90);
        setTeaPowder(0);
        setSugar(0);           
        waterQty = waterQty - 100;
        
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
        System.out.println("Dispensing Steam from Nescafe");
    }
    public void cleanMachine(){
        System.out.println("Cleaned Nescafe machine");
    }
    
    public void getColdAmericano(){
        setMilk(0);
        setCoffeeBean(5);
        setWater(100);
        setTemp(0);
        setTeaPowder(0);
        setSugar(0);                   
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 5;
        
    }
    public void getColdExpresso(){
        setMilk(100);
        setCoffeeBean(5);
        setWater(100);
        setTemp(0);
        setTeaPowder(0);
        setSugar(20);                   
        waterQty = waterQty - 100;
        coffeeBeanQty = coffeeBeanQty - 5;
        sugarQty = sugarQty - 20;
        milkQty = milkQty - 100;
    }
    public void getColdTea(){
        setMilk(100);
        setCoffeeBean(0);
        setWater(100);
        setTemp(0);
        setTeaPowder(20);
        setSugar(20);         
        waterQty = waterQty - 100;
        teaQty = teaQty - 20;
        sugarQty = sugarQty - 20;
        milkQty = milkQty - 100;
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

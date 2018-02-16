package com.project.tutorial.abstractdemo.coffemachine;

public interface CoffeeMachine {
    String EXPRESSO = "Get Expresso";
    String AMERICANO = "Get Americano";
    String MILK = "Get Milk";
    String TEA = "Get Tea";
    String WATER = "Get Water";
    String STEAM = "Get Steam";
    String CLEAN = "Clean Machine";
    
    void getHotAmericano();
    void getHotExpresso();
    void getHotTea();
    void getHotMilk();
    void getHotWater();
    void getColdAmericano();
    void getColdExpresso();
    void getColdTea();
    void getColdMilk();
    void getColdWater();
    void cleanMachine();
    void getSteam();
}


package com.project.tutorial.utildemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Datetime {
 //   Datetime d = new Datetime();
    
        public int example(int x){
        return x+2;
    }
    public void example(int x, int y){
        
    }
    
  /*  private double example(int x){
      Double d1;
      return d1.doubleValue(x);
    }*/
    public static void main(String[] args){
        Date d = new Date(2222222222222L);
        Date d1 = new Date();
    Datetime s = new Datetime();
    s.example(10);
        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd E hh.mm.ss a zzz");
        
        
        try {
            d1=ft.parse("2017.04.18 Fri 09.40.19 PM KST");
        } catch (ParseException e) {
        }

        Integer i=20;
        System.out.println(d1);
        System.out.println(d +"a");
        System.out.println("a" + i);
        
    }
}

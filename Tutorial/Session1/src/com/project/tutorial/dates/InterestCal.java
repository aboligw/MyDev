package com.project.tutorial.dates;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class InterestCal {
    public InterestCal() {
        super();
    }

    public static void main(String[] args) {
        Dates d = new Dates();
        //first date inp
        d.getDate(2);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d.getD1());
        
        //second date inp
        
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d.getD2());
        
        int leapcnt=0;
        int nonleapcnt = 0;
        
        System.out.println("Enter amount");
        Scanner sc = new Scanner(System.in);
        int amt=sc.nextInt();
        
        if(cal.get(cal.YEAR)==cal1.get(cal1.YEAR)) {
            if(d.isLeap(cal.getTime()))
                leapcnt+=d.daysDiff();
            else
                nonleapcnt+=d.daysDiff();
        }
        else{
            Calendar tempCal = Calendar.getInstance();
            Date temp = cal1.getTime();
            while(cal.getTime().before(temp)){
                if(cal.getTime()==temp)
                    break;
                if(d.isLeap(cal.getTime())){
                    setToLDY(cal, tempCal);
                    
                    if (temp.after(tempCal.getTime()))
                        d.setD2(tempCal.getTime());
                    else
                        d.setD2(cal1.getTime());
                    
                    leapcnt+=d.daysDiff();
                    
                }
                else{
                    setToLDY(cal, tempCal);
                    
                    if (temp.after(tempCal.getTime()))
                        d.setD2(tempCal.getTime());
                    else
                        d.setD2(cal1.getTime());
                    
                    nonleapcnt+=d.daysDiff();
                    
                }
                
                cal.setTime(tempCal.getTime());
                cal.add(cal.DATE,1);
                d.setD1(cal.getTime());
                //System.out.println(cal.getTime());
           }
        }
        System.out.println(nonleapcnt);
        System.out.println(leapcnt);
        double si =(((leapcnt*amt*5.0)/36600) + ((nonleapcnt*amt*5.0)/36500));
        System.out.println("Interset for period is :" + si);
    }

    private static void setToLDY(Calendar cal, Calendar tempCal) {
        tempCal.set(tempCal.YEAR, cal.get(cal.YEAR));
        tempCal.set(tempCal.MONTH, 11);
        tempCal.set(tempCal.DAY_OF_MONTH, 31);
    }
}

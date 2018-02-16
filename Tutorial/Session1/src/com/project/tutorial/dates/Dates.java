package com.project.tutorial.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Dates {
    private Date d1;
    private Date d2;
    
    public Dates() {
        super();
    }
    public Boolean isLeap(Date x){
        Calendar cal = Calendar.getInstance();
        cal.setTime(x);
        Boolean cv = ((cal.get(cal.YEAR)%4)==0) ? true : false;
        cv = ((cal.get(cal.YEAR)%4)==0) ? true : false;
        return cv;
    }
    public Date getInput(String p){
        System.out.println("Enter the " + p + " date in dd-mm-yyyy format");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        
        Date date=null;       
        try{
            date=ft.parse(str);
            Calendar cal = timeTruncate(date);
            return cal.getTime();
        }
        catch(ParseException e){
            date=new Date();
            System.out.println("Inappropriate date format used.will take system date ");    
        }
       return date;
   }
    public void setD1(Date d1) {
        this.d1 = d1;
    }

    public Date getD1() {
        return d1;
    }

    public void setD2(Date d2) {
        this.d2 = d2;
    }

    public Date getD2() {
        return d2;
    }
    public Boolean checkEqual(Date x,Date y){
        if(x.compareTo(y)== 0)
            return true;
        else
            return false;
    }
    public Boolean checkLess(Date x,Date y){
        if(x.compareTo(y)< 0)
            return true;
        else
            return false;
    }
    public Boolean checkGreater(Date x,Date y){
        if(x.compareTo(y)> 0)
            return true;
        else
            return false;
    }
    public void getDate(int x){
        if(x==1)
        this.setD1(this.getInput("desired "));
        else{
        this.setD1(this.getInput("First "));
        this.setD2(this.getInput("Second "));
        }
    }
    public void addDays(int x){
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.getD1());
        cal.add(cal.DATE, x);
        System.out.println("Updated date is " + cal.getTime());
    }
    public int daysDiff(){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(this.getD1());
        Date temp = this.getD1();
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(this.getD2());
        
        int count = 0;
        while((this.getD1()==this.getD2()) || this.checkLess(temp, this.getD2())){
            count++;
            cal1.setTime(temp);
            cal1.add(cal1.DATE, 1);
            temp = cal1.getTime();
        }
        return count;
    }
    public static void main(String[] args) {
        Dates d = new Dates();
        //Equal
        d.getDate(2);
        if(d.checkEqual(d.getD1(),d.getD2()))
            System.out.println("Equal");
        else
            System.out.println("Unequal");
        
        //Less
        d.getDate(2);
        if(d.checkLess(d.getD1(),d.getD2()))
            System.out.println("First is before");
        else
            System.out.println("First is not before");
       
        //Greater
        d.getDate(2);
        if(d.checkGreater(d.getD1(),d.getD2()))
            System.out.println("First is after");
        else
            System.out.println("First is not after"); 
        
        //Less than equal to
        d.getDate(2);
        if(d.checkLess(d.getD1(),d.getD2()) || d.checkEqual(d.getD1(), d.getD2()))
            System.out.println("First is before or equal");
        else
            System.out.println("First is not before or equal");
        
        //greater than equal to
        d.getDate(2);
        if(d.checkGreater(d.getD1(),d.getD2()) || d.checkEqual(d.getD1(), d.getD2()))
            System.out.println("First is after or equal");
        else
            System.out.println("First is not after or equal");
        
        //add days
        d.getDate(1);
        System.out.println("Enter no of days to add");
        Scanner sc = new Scanner(System.in);
        d.addDays(sc.nextInt());
        
        //sub days
        d.getDate(1);
        System.out.println("Enter no of days to minus");
        Scanner sc1 = new Scanner(System.in);
        d.addDays(-1*sc1.nextInt());
        
        //difference in days
        d.getDate(2);
        Integer count = d.daysDiff();
        System.out.println("Difference in dates is :" + count + " days");
        
        //Difference in months
        d.getDate(2);
        count = (int)(d.daysDiff()/30);
        System.out.println("Difference in dates is :" + count + " months");
    }

    private Calendar timeTruncate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        date = cal.getTime();
        return cal;
    }
}

package com.project.tutorial.langdemo;

import java.util.Scanner;

public class InbuiltBufferDemo {
    public static void main(String[] args){
        StringBuffer str1;
        StringBuffer str2;
        String cont = "Y";
        while(cont.equals("Y")){
        
        System.out.println("------------MENU------------");
        System.out.println("1> String Length");
        System.out.println("2> String Concatenate");
        System.out.println("3> String Compare");
        System.out.println("4> Substr finder");
        System.out.println("5> String Reverse");
        System.out.println("6> String Replace");
        System.out.println("Enter your choice");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        
        switch(ch){
        case 1:
            str1 = getString(" ");
            System.out.println("Length of the string is : " + str1.length());
            break;
        case 2:
            str1 = getString("first");
            str2= getString("second");
            System.out.println("Concatenated string is :" + str1.append(str2));
            break;
        case 3:
            str1 = getString("first");
            str2= getString("second");
            if(str1.toString().compareTo(str2.toString())==0)
                System.out.println("Strings are equal");
            else
                System.out.println("Strings are unequal");
            break;  
        case 4:
            str1 = getString("first");
            str2= getString("second");
            if(str1.indexOf(str2.toString())>=0)
                System.out.println("Substring found!");
            else
                System.out.println("Substring not found");
            break;
        case 5:
            str1 = getString(" ");
            str1.reverse();
            System.out.println("Reversed string is : " + str1);
            break;
        case 6:
            str1 = getString("parent");
            str2 = getString("target");
            System.out.println("Enter the starting and ending index");
            int x = getIdx();
            int y = getIdx();
            System.out.println("Replaced string is :" + str1.replace(x, y, str2.toString()));
            break;
        default:
            System.out.println("Enter valid choice");
            break;
        }
        System.out.println("Do you want to continue?");
        Scanner sc3 = new Scanner(System.in);
        cont = sc3.nextLine();
        }    
    }
    public static StringBuffer getString(String num){
        System.out.println("Enter the " + num + " string");
        Scanner sc1 = new Scanner(System.in);
        StringBuffer buff = new StringBuffer(sc1.nextLine());
        return buff;
    }
    public static int getIdx(){
        Scanner scidx = new Scanner(System.in);
        return scidx.nextInt();
    }
}

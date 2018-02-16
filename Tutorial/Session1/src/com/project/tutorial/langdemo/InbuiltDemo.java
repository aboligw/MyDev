package com.project.tutorial.langdemo;

import java.util.Scanner;

public class InbuiltDemo {
    public static void main(String[] args){
        String str1;
        String str2;
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
            System.out.println("Concatenated string is :" + str1.concat(str2));
            break;
        case 3:
            str1 = getString("first");
            str2= getString("second");
            if(str1.compareTo(str2)==0)
                System.out.println("Strings are equal");
            else
                System.out.println("Strings are unequal");
            break;  
        case 4:
            str1 = getString("first");
            str2= getString("second");
            if(str1.contains(str2))
                System.out.println("Substring found!");
            else
                System.out.println("Substring not found");
            break;
        case 5:
            str1 = getString(" ");
            System.out.println("Reversal  not possible with string object");
            break;
        case 6:
            str1 = getString("parent");
            str2 = getString("source");
            String str3 = getString("target");
            System.out.println("Replaced string is :" + str1.replace(str2, str3));
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
    public static String getString(String num){
        System.out.println("Enter the " + num + "string");
        Scanner sc1 = new Scanner(System.in);
        return sc1.nextLine();
    }
}

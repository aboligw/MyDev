package com.project.tutorial.langdemo;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        String str;
        
        char[] ch;
        char temp;
        System.out.println(Integer.toString(-34,1));
        System.out.println("Enter the string you want to reverse");
        Scanner sc=new Scanner(System.in);
        str=sc.nextLine();
        ch=str.toCharArray();
        int i;
        
        int mid = str.length()/2;
        System.out.println(ch);
        for(i=0;i<=mid;i++){
            temp=ch[i];
            ch[i]=ch[ch.length -1-i];
            ch[ch.length-1-i]=temp;
        }
        
        System.out.println("Reversed string is: ");
        System.out.println(ch);
    }
}

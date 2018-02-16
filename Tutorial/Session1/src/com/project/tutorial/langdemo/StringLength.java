package com.project.tutorial.langdemo;

import java.util.Scanner;

public class StringLength {
    public static void main(String[] args){
        String str;
        int counter = 0;
        
        System.out.println("Enter the string");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        
        for(char c:str.toCharArray()){
            counter ++;
        }
        System.out.println("Length of string is: "+ counter);
        
    }
}

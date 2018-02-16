package com.project.tutorial.langdemo;

import java.util.Scanner;

public class Palindrome {
   // char[] inp = new char[100];
    public static void main(String[] args){
    System.out.println("Enter the string");   
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    char[] inp = str.toCharArray();
    
    int mid=(str.length()/2);
    int flag=0;
    for(int i=0;i<=mid;i++){
        if(inp[i]!=inp[str.length()-1-i]){
            System.out.println("Not a Palindrome");
            flag=1;
            break;
        }
    }
    if(flag==0)
    System.out.println("Palindrome");
}
}

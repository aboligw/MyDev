package com.project.tutorial.langdemo;

import java.util.Scanner;

public class Concatenation {

    public static void main(String[] args) {
         
    char[] inp1arr = makeArrayFromInp();  
    char[] inp2arr = makeArrayFromInp();
    char[] outarr = new char[inp1arr.length+inp2arr.length];    
    int i=0;
        for(char c: inp1arr) {
        outarr[i]=c;  
        i++;
      }
    
     for(char c: inp2arr) {    
        outarr[i]=c;
        i++;
      }
    System.out.println("Concatenated String is:");
    System.out.println(outarr);
    }
    
public static char[] makeArrayFromInp(){ 
    String inp1;
    System.out.println("Enter String");
    Scanner sc1 = new Scanner(System.in);
    inp1 = sc1.nextLine();
    return inp1.toCharArray();
    }  
    
}


package com.project.tutorial.langdemo;

import java.util.Scanner;

public class CompareStr {
    public static void main(String[] args){
        
        int i;
        int j;
        int count=0;
        char[] inp1arr = makeArrayFromInp();
        char[] inp2arr = makeArrayFromInp();
        for(i=0,j=0;i<(inp1arr.length) && j<(inp2arr.length);i++,j++){
            if(inp1arr.length == inp2arr.length){
                if(inp1arr[i] == inp2arr[j])   
                count++;
            }
            else{
                break;
            }
        }
        if(count==inp1arr.length && count!=0){
            System.out.println("Strings are equal");
        }
        else{
            System.out.println("Strings are unequal");
        }       
    }
    public static char[] makeArrayFromInp(){ 
        String inp1;
        System.out.println("Enter String");
        Scanner sc1 = new Scanner(System.in);
        inp1 = sc1.nextLine();
        return inp1.toCharArray();
        }         
}

package com.project.tutorial.langdemo;

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        int i;
        int j;
        char curr;
        int count = 0;
        boolean flag = false;
        char[] inp1arr = makeArrayFromInp();
        char[] inp2arr = makeArrayFromInp();
        for(i=0;i<(inp1arr.length);i++){
            curr = inp1arr[i];
            for(j=0;j<inp2arr.length;j++){
                if(curr == inp2arr[j]){
                    inp2arr[j] = '*';
                    count++;
                }
                if(count!=0 && count == inp1arr.length){
                    flag = true;
                }
            }
        }
        if(flag){
            System.out.println("Second string is Anagram of first");
        }
        else
            System.out.println("Not an Anagram");
        
    Long endTime = System.currentTimeMillis();
    Long totTime = endTime-startTime;
    System.out.println("Total exec time is:");
    System.out.println(totTime);
    }
    
    public static char[] makeArrayFromInp(){ 
        String inp1;
        System.out.println("Enter String");
        Scanner sc1 = new Scanner(System.in);
        inp1 = sc1.nextLine();
        return inp1.toCharArray();
        }  
}

package com.project.tutorial.langdemo;

import java.util.Scanner;

public class ReplaceStr {
    public static void main(String[] args){
        char[] inp1arr = makeArrayFromInp();
        char[] inp2arr = makeArrayFromInp();
        char[] output = new char[200];
        int i= 0;
        
        
        System.out.println("Enter position where replace should happen");
        Scanner sc = new Scanner(System.in);
        String offStr = sc.nextLine();
        int offset = Integer.parseInt(offStr);
        int rem = 0;
        
        for(i=0;i<offset;i++){
            output[i]=inp1arr[i];
            rem = inp1arr.length-i;
        }
        for(int j=0;j<inp2arr.length;j++){
            output[i]= inp2arr[j];
            i++;
        }
        for(int k=i;k<=rem;k++){
            output[i]=inp1arr[k];
            i++;
        }
        System.out.println("output is: ");
        System.out.println(output);
    }
    public static char[] makeArrayFromInp(){ 
        String inp1;
        System.out.println("Enter String");
        Scanner sc1 = new Scanner(System.in);
        inp1 = sc1.nextLine();
        return inp1.toCharArray();
        }  
        

}

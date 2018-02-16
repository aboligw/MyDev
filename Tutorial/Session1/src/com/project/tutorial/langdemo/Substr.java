package com.project.tutorial.langdemo;

import java.util.Scanner;

public class Substr {
    public static void main(String[] args) {
        char[] inp1arr = makeArrayFromInp();  
        char[] inp2arr = makeArrayFromInp();
        int currIdx = 0;
        boolean flag = false;
        int i = 0;  
        int k=0;
        int count =0;
            for(int j=0;j<=inp1arr.length-1;j++){
                if(flag == true){
                    break;
                }
                else{
                i=0;
                count=0;
                char curr = inp2arr[i];
                if(inp1arr[j]==curr){
                    currIdx = j+1;
                    count++;
                    if(inp2arr.length==1){
                        flag = true;
                        break;
                    }
                    for(k=currIdx,i=1;(k<=(currIdx+inp2arr.length)&&k<inp1arr.length) && i<=inp2arr.length-1;i++,k++){
                        if(inp1arr[k] == inp2arr[i]){
                            count++;    
                        }
                        if(count!=0 && count == inp2arr.length){
                            flag = true;
                        }
                    }                    
                }
                }
            }
            if(flag==true){
                System.out.println("Substring found in parent");
            }
            else
                System.out.println("Not a substring");
    }
    public static char[] makeArrayFromInp(){ 
        String inp1;
        System.out.println("Enter String");
        Scanner sc1 = new Scanner(System.in);
        inp1 = sc1.nextLine();
        return inp1.toCharArray();
        }  
}

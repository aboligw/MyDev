package com.project.tutorial.langdemo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCounter {

    public static void main(String[] args) {
        int count = 0;
        
        System.out.println("Enter parent text");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println("You have Entered:  " + input);
        
        System.out.println("Text occurances to count?");
        Scanner sc1 = new Scanner(System.in);
        String subStrIp = sc1.nextLine();
        
        Pattern p =Pattern.compile(subStrIp);
        Matcher m =p.matcher(input);
        while(m.find()){
            count ++;
        }
        System.out.println("Substring appears " + count + "times.");
        
    }
}

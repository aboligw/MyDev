package com.project.tutorial.langdemo;

public class LangTester {
    public LangTester() {
        super();
    }

    public static void main(String[] args) {
        int i = 10;
        double d = -10.564345d;
        Long l= 10L;
        Short s = 10;
        Character c = 'f';
        
        
        char[] c1 = new char[8];
        Boolean x = true;
        Float f = 10.9F;
        i=(int)d;
        double d1 = Math.floor(d);
        System.out.println(d1);
   //     String s4 = new String(chars, 1, 3);
       //  String s5 = new String(s2);
        String s1 ="abc";
        String s2="abc";
        
        System.out.println(Integer.toString(-34));
        //l=i;
        //l=d;
        
     if(s1==s2){
            System.out.println(s1);
       }
    }
}

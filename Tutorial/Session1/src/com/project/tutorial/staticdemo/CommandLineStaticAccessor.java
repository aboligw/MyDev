package com.project.tutorial.staticdemo;
import com.project.demo2.Test2;

public class CommandLineStaticAccessor {
    public CommandLineStaticAccessor() {
        super();
    }

    public static void main(String[] args) {
        switch (args[0]){
                         case "str":
                           System.out.println(Test2.str);
                           break;
                         case "num":
                           System.out.println(Test2.num);
                           break;
                        default:
            System.out.println("enter valid argument");
            break;
        }
        }
            }

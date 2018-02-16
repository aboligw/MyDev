package com.project.tutorial.staticdemo;

//import com.project.demo2.Test2;
import static com.project.demo2.Test2.*;
//import static com.project.demo2.Test2.str;
public class StaticVarAccessor {
    static int objCtr=0;
    static void PrintCtr(){
        System.out.println("object counter is -->" + StaticVarAccessor.objCtr);
    }
    public StaticVarAccessor() {
        StaticVarAccessor.objCtr++;
        StaticVarAccessor.PrintCtr();
    }

    public static void main(String[] args) {
        System.out.println(str);
        int result=0;
        result = PrintStr(3);
        System.out.println("Output of method is --> " + num + "/3 = " + result);
    
        /*  StaticVarAccessor obj1 = new StaticVarAccessor();
        StaticVarAccessor obj2 = new StaticVarAccessor();
        StaticVarAccessor obj3 = new StaticVarAccessor();
        StaticVarAccessor obj4 = new StaticVarAccessor();
        System.out.println("Constructor was called " + StaticVarAccessor.objCtr + "times"); */
    }
}

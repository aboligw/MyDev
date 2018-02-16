package com.project.tutorial.langdemo;
import java.lang.*;
public class WrapperValPrinter {
    private static final String STRING = "String";
    private static final String LONG = "Long";
    private static final String SHORT = "Short";
    private static final String INTEGER = "Integer";
    private static final String DOUBLE = "Double";
    private static final String FLOAT = "Float";
    private static final String BYTE = "Byte";
    private static final String BOOLEAN = "Boolean";
    
    public static void main(String[] args) {
       String s;
       Integer i;
       Byte b;
       Boolean bo;
       Double d;
       Float f;
       Long l;
       Short sh;
       
       String val = args[0].toString();
       
       for (int j=1;j<args.length;j++){
           switch (args[j]){
           case STRING:
               s = val;
               System.out.println("\nString : " + s);
               break;
           case INTEGER:
               i = Integer.parseInt(val);
               System.out.println("Hello");
               System.out.println("\nInteger : " + i);
               break;
           case LONG:
               l = Long.valueOf(val);
               System.out.println("\nLong : " + l);
                break;
           case SHORT:
               sh = Short.valueOf(val);
               System.out.println("\nShort : " + sh);
               break;
           case FLOAT:
               f = Float.valueOf(val);
               System.out.println("\nFloat : " + f);
               break;
           case DOUBLE:
               d = Double.valueOf(val);
               System.out.println("\nDouble : " + d);
               break;
           case BYTE:
               b = Byte.valueOf(val);
               System.out.println("\nByte : " + b);
               break;
           case BOOLEAN:
               bo = Boolean.valueOf(val);
              System.out.println("\nBoolean : " + bo);
               break;
           }
       }
    }
}

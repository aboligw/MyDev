package com.project.tutorial.reflectiondemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Scanner;

public class AnimalDataExtracter {
    public static void main(String[] args) {
        System.out.println("Enter string now!");
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] inArr = in.split(",");
        String name = "com.project.tutorial.reflectiondemo.".concat(inArr[0]);
        try {
            Class<?> c = Class.forName(name);
            Constructor<?> ctor = c.getConstructor();
            Object object = ctor.newInstance();
            Class aClass = c.getSuperclass();
            /*        for (int i = 1; i < 4; i++) {
                String[] inarF = inArr[i].split(":");
                Field f1 = aClass.getField(inarF[0]);
                if (f1.getType().isAssignableFrom(Double.TYPE)) {
                    f1.set(object, Double.parseDouble(inarF[1]));
                } else if (f1.getType().isAssignableFrom(Character.TYPE)) {
                    f1.set(object, (inarF[1]).charAt(0));
                } else if (f1.getType().isAssignableFrom(Integer.TYPE)) {
                    f1.set(object, Integer.parseInt(inarF[1]));
                } else {
                    f1.set(object, inarF[1]);
                }
            }*/

            for (int i = 1; i < 4; i++) {
                String[] inarM = inArr[i].split(":");
                Method[] allMethods = aClass.getDeclaredMethods();
                for (Method m : allMethods) {
                    String mname = m.getName();
                    System.out.println(mname);
                    if (mname.endsWith(inarM[0]) && m.getParameterCount() == 1) {
                        if (m.getParameterTypes()[0].isAssignableFrom(Integer.TYPE)) {
                            try {
                                m.invoke(object, Integer.parseInt(inarM[1]));
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        } else if (m.getParameterTypes()[0].isAssignableFrom(Character.TYPE)) {
                            try {
                                m.invoke(object, inarM[1].charAt(0));
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                m.invoke(object, inarM[1]);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            System.out.println("Output is:" + c.getSimpleName() + object);
        }


        catch (NoSuchMethodException e) {
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException | InvocationTargetException e) {
        }


        //catch (NoSuchFieldException e) {
        // e.printStackTrace();
        //}
    }


}

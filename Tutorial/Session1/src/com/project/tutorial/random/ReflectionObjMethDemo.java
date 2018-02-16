package com.project.tutorial.random;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionObjMethDemo {
    public ReflectionObjMethDemo() {
        super();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
                                                  IllegalAccessException, InvocationTargetException {
        Class c = Class.forName("com.project.tutorial.random.Person");
        Constructor<?> con = c.getConstructor();
        Object o = con.newInstance();
        Method[] m = c.getDeclaredMethods();
        for (Method m1 : m) {
            if ("displayMsg".equals(m1.getName())) {
                m1.invoke(o, new Object[] { "This is bullshit" });

            }
        }
    }
}

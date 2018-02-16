package com.project.tutorial.collectiondemo;

import java.util.LinkedList;
import java.util.Vector;

public class ListDemo {
    public ListDemo() {
        super();
    }

    public static void main(String[] args) {
        Employee e1=new Employee(1,"emp1",1000.0,1);
        Employee e2=new Employee(2,"emp2",2000.0,2);
        Employee e3=new Employee(3,"emp3",300.0,3); 
        Employee e4=new Employee(5,"emp4",300.0,4);
        Employee e5=new Employee(6,"emp3",300.0,5);
        Employee e7=new Employee(7,"emp7",30009.0,6);
        ListDemo listDemo = new ListDemo();
        LinkedList<Employee> l1 = new LinkedList<Employee>();
        
        l1.add(e1);
        l1.add(e2);
        l1.add(e3);
        l1.add(e4);
        l1.add(e5);
        
        CompareDemo.display(l1);
        
        l1.add(3,e7);
        CompareDemo.display(l1);
        
        System.out.println("     ");
        Vector<Employee> v = new Vector<Employee>();
        v.addAll(l1);
        CompareDemo.display(v);
        System.out.println("     ");
        e1.setId(10);
        CompareDemo.display(v);
        
        System.out.println("     ");
        CompareDemo.display(l1);
        
    }
}

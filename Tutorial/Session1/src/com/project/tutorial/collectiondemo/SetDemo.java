package com.project.tutorial.collectiondemo;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public SetDemo() {
        super();
    }
    public static void main(String[] args){
        
        Employee e1 = new Employee(1,"emp1",11000.0,11);
        Employee e2 = new Employee(2,"emp2",13000.0,12);
        Employee e3 = new Employee(3,"emp3",16000.0,13);
        Employee e4 = new Employee(4,"emp4",10000.0,14);
        Employee e5 = new Employee(5,"emp5",15000.0,15);
        Employee e6 = new Employee(6,"emp6",12000.0,16);
        Employee e7 = new Employee(1,"emp7",5000,17);
        
        Set<Employee> s1 = new HashSet<Employee>();
        Set<Employee> s2 = new HashSet<Employee>();
        
        s1.add(e1);
        s1.add(e2);
        s1.add(e3);
        s1.add(e1);
        s1.add(e7);
        s1.add(e4);
        CompareDemo.display(s1);
        s2.add(e1);
        s2.add(e2);
        s2.add(e3);
        s2.add(e5);
        s2.add(e6);
        System.out.println("   ");
        CompareDemo.display(s2);
        //Union
        s1.addAll(s2);
        System.out.println("Union is :");
        CompareDemo.display(s1);
        
        //Intersection
        s1.retainAll(s2);
        System.out.println("Intersection result - ");
        CompareDemo.display(s1);
        
        //get
            int hc = e3.hashCode();
            System.out.println(hc);
        
    }
}

package com.project.tutorial.collectiondemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CompareDemo {
    public CompareDemo() {
        super();
    }

    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<Employee>();

        Employee e1 = new Employee(1, "emp1", 1000.0, 3);
        Employee e2 = new Employee(2, "emp2", 2000.0, 2);
        Employee e3 = new Employee(3, "emp3", 300.0, 2);
        Employee e4 = new Employee(5, "emp4", 300.0, 1);
        Employee e5 = new Employee(6, "emp3", 300.0, 8);

        empList.add(e2);
        empList.add(e1);
        empList.add(e5);
        empList.add(e4);
        empList.add(e3);
        empList.add(e2);

        display(empList);
        /*Delete element*/
        empList.remove(e5);
        System.out.println("After Delete");
        display(empList);

        /*Search element*/
        if (empList.contains(e5)) {
            System.out.println("Obejct found in list at index" + empList.indexOf(e5));
        } else
            System.out.println("Absent in list");

        //Display element
        if (empList.contains(e5)) {
            System.out.println("Element is present in the list. Here are its values");
            System.out.println("ID - " + e5.getId());
            System.out.println("Name - " + e5.getName());
            System.out.println("Salary - " + e5.getSalary());
        } else
            System.out.println("Absent in list");

        //Highest paid Salary
        Collections.sort(empList, new EmpSalSorter());
        display(empList);
        //Collections.reverse(empList);
        System.out.println("Highest paid employee is:" + empList.get(0));

        //Sort descending by name
        Collections.sort(empList, new EmpNameSorter());
        //    Collections.reverse(empList);
        System.out.println("After sorting on name");
        display(empList);

    }

    public static void display(Collection<Employee> p_list) {
        Iterator<Employee> it;
        it = p_list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        /* for(int i=0;i<p_list.size();i++){
            System.out.print(p_list.get(i)+"\n");
        }*/
    }
}

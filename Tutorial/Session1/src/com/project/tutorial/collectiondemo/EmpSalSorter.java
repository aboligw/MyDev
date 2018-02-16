package com.project.tutorial.collectiondemo;

import java.util.Comparator;

public class EmpSalSorter implements Comparator{
    public EmpSalSorter() {
        super();
    }

    @Override
    public int compare(Object e1, Object e2) {
        return ((Employee)e2).getSalary().compareTo(((Employee)e1).getSalary());
        
    }
}

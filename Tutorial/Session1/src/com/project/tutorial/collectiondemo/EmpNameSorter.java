package com.project.tutorial.collectiondemo;

import java.util.Comparator;

public class EmpNameSorter implements Comparator{
    public EmpNameSorter() {
        super();
    }

    @Override
    public int compare(Object e1, Object e2) {
        //if(e1.getClass())
        return ((Employee)e2).getName().compareTo(((Employee)e1).getName());
        
    }
}

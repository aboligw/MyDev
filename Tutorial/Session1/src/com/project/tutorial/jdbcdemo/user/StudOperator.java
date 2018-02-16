package com.project.tutorial.jdbcdemo.user;

import com.project.tutorial.jdbcdemo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudOperator {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Shabot", "AppleTree", "Seoul");
        Student s2 = new Student(2, "Kiran", "PineTree", "Seoul");
        StudentBD bdObj = StudentBD.getInstance();
        List<Student> studList = new ArrayList<Student>();

        s1.setActionMode("+");
        s2.setActionMode("+");

        studList.add(s1);
        studList.add(s2);
        bdObj.update(studList);
        studList.clear();

        s2.setAddress("Sangam-Dong");
        s2.setActionMode("*");
        studList.add(s2);


        bdObj.update(studList);
        bdObj.select(null, null, null, 2);

    }


}

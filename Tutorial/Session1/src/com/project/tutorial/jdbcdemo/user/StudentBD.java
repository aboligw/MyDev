package com.project.tutorial.jdbcdemo.user;

import com.project.tutorial.jdbcdemo.model.Student;
import com.project.tutorial.jdbcdemo.service.StudInfoFacade;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class StudentBD {
    private static StudentBD obj = null;
    private StudInfoFacade f = StudInfoFacade.getInstance();

    private StudentBD() {
        super();
    }

    public static StudentBD getInstance() {
        if (obj == null) {
            obj = new StudentBD();
        }
        return obj;
    }

    void update(List<Student> studList) {
        try {
            int x = f.update(studList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DbException e) {
            System.out.println("Error in insert/update: " + e.getMessage());
        }
    }


    void select(String name, String address, String branch, int id) {
        List<Student> l = new ArrayList<Student>();
        l = f.select(name, address, branch, id);
        for (Student s : l) {
            System.out.println(s);
        }
    }
}

package com.project.vb.service;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.ConnectionManager;
import com.project.vb.common.MyException;
import com.project.vb.model.Student;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class StudentFacade {

    private StudentDao StudentDaoObj = BeanGetter.getBean("studentDao", StudentDao.class);

    private StudentFacade() {
        super();
    }


    public List<Student> select(int roll, String name, int clas) throws SQLException {
        System.out.println("Inside facade");
        List<Student> list = new ArrayList<Student>();
        //int user = 0;
        Connection con = ConnectionManager.getConnection();
        try {
            list = StudentDaoObj.select(con, roll, name, clas);

        } finally {
            con.close();
        }
        return list;
    }

    public Student selectStudentRollNo(String uId) throws SQLException {
        Student s = new Student();
        Connection con = ConnectionManager.getConnection();
        try {
            s = StudentDaoObj.selectStudentRollNo(con, uId);
        } catch (MyException e) {
            System.out.println(e.toString());
        } finally {
            con.close();
        }
        return s;
    }

    public List<Integer> selectStudFromSchool(int i) throws SQLException {
        List<Integer> list = new ArrayList<Integer>();
        Connection con = ConnectionManager.getConnection();
        try {
            list = StudentDaoObj.selectStudFromSchool(con, i);
        } finally {
            con.close();
        }
        return list;
    }
}

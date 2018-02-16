package com.project.tutorial.jdbcdemo.service;

import com.project.tutorial.jdbcdemo.ConnectionManager;
import com.project.tutorial.jdbcdemo.model.Model;
import com.project.tutorial.jdbcdemo.model.Student;
import com.project.tutorial.jdbcdemo.user.DbException;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class StudInfoFacade {
    private static StudInfoFacade facObj = null;
    private StudentDAO servObj = StudentDAO.getInstance();


    private StudInfoFacade() {
        super();
    }

    public static StudInfoFacade getInstance() {
        if (facObj == null) {
            facObj = new StudInfoFacade();
        }
        return facObj;
    }

    public int update(List<Student> l) throws SQLException, DbException {
        Connection con = ConnectionManager.getConnection();
        try {
            for (Student s : l) {
                if (Model.INSERT_MODE.equals(s.getActionMode())) {
                    servObj.insert(con, s);
                } else if (Model.MODIFY_MODE.equals(s.getActionMode())) {
                    servObj.update(con, s);
                } else if (Model.DELETE_MODE.equals(s.getActionMode())) {
                    servObj.delete(con, s);
                }

            }
            con.commit();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            con.rollback();
        } finally {
            con.close();
        }
        return -1;
    }
    Integer x = new Integer(5);
    boolean y = genMethod(x);

    public List<Student> select(String name, String address, String branch, int id) {
        List<Student> studList = new ArrayList<Student>();
        Connection con = ConnectionManager.getConnection();
        try {
            studList = servObj.select(con, name, address, branch, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studList;
    }

    public <T> boolean genMethod(T t) {
        return true;
    }
}

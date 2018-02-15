package com.project.vb.service;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.ConnectionManager;
import com.project.vb.output.MyReport;
import com.project.vb.output.ProgressReport;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class MarksFacade {
    private MarksDao daoObj = BeanGetter.getBean("marksDao", MarksDao.class);


    private MarksFacade() {
        super();
    }


    public void insert(List<String> list, int e) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        try {
            daoObj.insert(con, list, e);
        } finally {
            con.close();
        }
    }

    public List<ProgressReport> select(int r, int s) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        List<ProgressReport> list = new ArrayList<ProgressReport>();
        try {
            list = daoObj.select(con, r, s);
            if (list == null) {
                System.out.println("Facade list is null");
            }
        } finally {
            con.close();
        }
        return list;
    }

    public List<MyReport> studReportselect(int s) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        List<MyReport> list = new ArrayList<MyReport>();
        try {
            list = daoObj.studReportselect(con, s);
            if (list == null) {
                System.out.println("Facade list is null");
            }
        } finally {
            con.close();
        }
        return list;
    }
}

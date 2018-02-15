package com.project.vb.service;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.ConnectionManager;
import com.project.vb.output.AttendanceReport;
import com.project.vb.output.MyAttendance;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class AttendanceFacade {
    private AttendanceDao daoObj = BeanGetter.getBean("attendanceDao", AttendanceDao.class);
    //private AttendanceDao daoObj = new AttendanceDao();
    /*private static AttendanceFacade obj = null;


    private AttendanceFacade() {
        super();
    }

    public static AttendanceFacade getInstance() {
        if (obj == null) {
            obj = new AttendanceFacade();
        }
        return obj;
    }*/

    public void bulkInsert(List<String> list, int lec) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        try {
            daoObj.bulkInsert(con, list, lec);
        } finally {
            con.close();
        }
    }

    public List<AttendanceReport> select(int classId, int lecNo, int tId) throws SQLException {
        List<AttendanceReport> list = new ArrayList<AttendanceReport>();
        Connection con = ConnectionManager.getConnection();
        try {
            list = daoObj.select(con, classId, lecNo, tId);
        } finally {
            con.close();
        }
        return list;
    }

    public List<MyAttendance> selectStudAttendance(int i) throws SQLException {
        List<MyAttendance> outList = new ArrayList<MyAttendance>();
        Connection con = ConnectionManager.getConnection();
        try {
            outList = daoObj.selectStudAttendance(con, i);
        } finally {
            con.close();
        }
        return outList;
    }
}

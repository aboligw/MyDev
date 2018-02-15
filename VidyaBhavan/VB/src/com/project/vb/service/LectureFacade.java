package com.project.vb.service;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.ConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class LectureFacade {
    private LectureDao daoObj = BeanGetter.getBean("lectureDao", LectureDao.class);
    private static LectureFacade obj = null;


    private LectureFacade() {
        super();
    }

    public static LectureFacade getInstance() {
        if (obj == null) {
            obj = new LectureFacade();
        }
        return obj;
    }


    public int insert(int subId, int classId, int teacherId, int duration, Date dateOfLec,
                      int lecNo) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        try {
            return daoObj.insert(con, subId, classId, teacherId, duration, dateOfLec, lecNo);
        } finally {
            con.close();
        }

    }

    public int select(Date d, int clsId, int lecNo, int teacherId) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        try {
            return daoObj.select(con, d, clsId, lecNo, teacherId);
        } finally {
            con.close();
        }

    }
}

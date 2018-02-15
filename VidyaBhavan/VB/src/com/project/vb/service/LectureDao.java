package com.project.vb.service;

import com.project.vb.common.DbConstants;
import com.project.vb.common.DbProcedureInvoke;
import com.project.vb.common.ProcParameter;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;

public class LectureDao extends DbProcedureInvoke {


    public LectureDao() {
        super();
    }


    int insert(Connection con, int subId, int classId, int teacherId, int duration, Date dateOfLec, int lecNo) {
        int returnId = 0;
        ProcParameter[] p = new ProcParameter[8];

        p[0] = new ProcParameter(1, subId);
        p[1] = new ProcParameter(2, classId);
        p[2] = new ProcParameter(3, teacherId);
        p[3] = new ProcParameter(5, duration);
        p[4] = new ProcParameter(4, dateOfLec);
        p[5] = new ProcParameter(6, lecNo);
        p[6] = new ProcParameter(7, null, OracleTypes.INTEGER);
        p[7] = new ProcParameter(8, null, OracleTypes.INTEGER);

        try {
            callProc(con, DbConstants.PA_LECTURE_I_LECTURE, p);
            if ((Integer) p[7].getValue() == 0) {
                returnId = (Integer) p[6].getValue();
            } else {
                System.out.println("Insert unsuccessful?????");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnId;
    }

    int select(Connection con, Date d, int clsId, int lecNo, int teacherId) {

        int returnId = 0;
        ProcParameter[] p = new ProcParameter[6];

        p[0] = new ProcParameter(1, d);
        p[1] = new ProcParameter(2, clsId);
        p[2] = new ProcParameter(3, lecNo);
        p[3] = new ProcParameter(4, teacherId);
        p[4] = new ProcParameter(5, null, OracleTypes.INTEGER);
        p[5] = new ProcParameter(6, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_LECTURE_S_LECTURE, p);
            if ((Integer) p[5].getValue() == 0) {
                returnId = (Integer) p[4].getValue();
            } else {
                System.out.println("Lecture table RNF");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnId;
    }
}

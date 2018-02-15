package com.project.vb.service;

import com.project.vb.common.DbConstants;
import com.project.vb.common.DbProcedureInvoke;
import com.project.vb.common.MyException;
import com.project.vb.common.ProcParameter;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;

public class ExamDao extends DbProcedureInvoke {
    public ExamDao() {
        super();
    }

    public int insert(Connection con, int subId, int totMks, int classId) throws MyException {
        int returnId = 0;
        ProcParameter[] p = new ProcParameter[4];
        p[0] = new ProcParameter(1, subId);
        p[1] = new ProcParameter(2, totMks);
        p[2] = new ProcParameter(3, classId);
        p[3] = new ProcParameter(4, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_TEST_I_TEST, p);
            if ((Integer) p[3].getValue() == 0) {
                return returnId;
            } else {
                throw new MyException((Integer) p[3].getValue());
                //                System.out.println("Insert into exam unsuccessful?????");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnId;
    }

    int select(Connection con, int subId, int clsId, int testNo) {
        int returnId = 0;
        ProcParameter[] p = new ProcParameter[5];

        p[0] = new ProcParameter(1, subId);
        p[1] = new ProcParameter(2, clsId);
        p[2] = new ProcParameter(3, testNo);
        p[3] = new ProcParameter(4, null, OracleTypes.INTEGER);
        p[4] = new ProcParameter(5, null, OracleTypes.INTEGER);

        try {
            callProc(con, DbConstants.PA_TEST_S_TEST, p);
            if ((Integer) p[4].getValue() == 0) {
                returnId = (Integer) p[3].getValue();
            } else {
                System.out.println("Test table RNF");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return returnId;
    }
}

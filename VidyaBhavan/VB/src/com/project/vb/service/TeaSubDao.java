package com.project.vb.service;

import com.project.vb.common.DbConstants;
import com.project.vb.common.DbProcedureInvoke;
import com.project.vb.common.ProcParameter;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;

public class TeaSubDao extends DbProcedureInvoke {


    public TeaSubDao() {
        super();
    }


    public int select(Connection con, int t) {
        int sub = 0;
        ProcParameter[] p = new ProcParameter[2];
        p[0] = new ProcParameter(1, t);
        p[1] = new ProcParameter(2, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_TEASUBLINK_S_TEASUBLINK, p);
            sub = (Integer) p[1].getValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sub;
    }


}

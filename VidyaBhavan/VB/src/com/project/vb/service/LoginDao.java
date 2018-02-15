package com.project.vb.service;

import com.project.vb.common.DbConstants;
import com.project.vb.common.DbProcedureInvoke;
import com.project.vb.common.MyException;
import com.project.vb.common.ProcParameter;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.jdbc.driver.OracleTypes;


public class LoginDao extends DbProcedureInvoke {


    public LoginDao() {
        super();
    }


    public int select(Connection con, String uname, String pwd, String role) throws MyException {
        int returncode = 0;
        ProcParameter[] p = new ProcParameter[4];
        p[0] = new ProcParameter(1, uname);
        p[1] = new ProcParameter(2, pwd);
        p[2] = new ProcParameter(3, role);
        p[3] = new ProcParameter(4, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_LOGIN_S_LOGIN, p);
            returncode = (Integer) p[3].getValue();
            if(returncode!=0)
            throw new MyException(returncode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returncode;
    }

}

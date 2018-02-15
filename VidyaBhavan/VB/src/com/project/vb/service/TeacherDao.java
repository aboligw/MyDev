package com.project.vb.service;

import com.project.vb.common.DbConstants;
import com.project.vb.common.DbProcedureInvoke;
import com.project.vb.common.ProcParameter;
import com.project.vb.model.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleTypes;

public class TeacherDao extends DbProcedureInvoke {
   

    public TeacherDao() {
        super();
    }

   

    public Teacher select(Connection con, String userId, int id, String name) {
        List<Teacher> tList = new ArrayList<Teacher>();
        ProcParameter[] p = new ProcParameter[4];
        p[0] = new ProcParameter(1, userId);
        p[1] = new ProcParameter(2, id);
        p[2] = new ProcParameter(3, name);
        p[3] = new ProcParameter(4, null, OracleTypes.CURSOR);
        try {
            callProc(con, DbConstants.PA_TEACHER_S_TEACHER, p);
            ResultSet rs = (ResultSet) p[3].getValue();
            while (rs.next()) {
                Teacher tRow = new Teacher();
                tRow.setUserId(rs.getString("USER_ID"));
                tRow.setId(rs.getInt("TEACHER_ID"));
                tRow.setName(rs.getString("TEACHER_NAME"));
                tList.add(tRow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tList.get(0);
    }
}

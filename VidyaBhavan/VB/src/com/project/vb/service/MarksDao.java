package com.project.vb.service;

import com.project.vb.common.DbConstants;
import com.project.vb.common.DbProcedureInvoke;
import com.project.vb.common.ProcParameter;
import com.project.vb.output.MyReport;
import com.project.vb.output.ProgressReport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleTypes;

public class MarksDao extends DbProcedureInvoke {
    public MarksDao() {
        super();
    }

    public void insert(Connection con, List<String> list, int eNo) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO REPORT(STUD_ID,TEST_ID,MARKS_OBT) VALUES(?,?,?)");
            for (String str : list) {
                ps.setInt(1, Integer.parseInt(str.split(",")[0]));
                ps.setInt(2, eNo);
                ps.setString(3, str.split(",")[1]);
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException e) {
            System.out.println("Dao values:" + eNo);
            e.printStackTrace();
        }
    }

    public List<ProgressReport> select(Connection con, int r, int s) {
        int returnCode = 0;
        List<ProgressReport> list = new ArrayList<ProgressReport>();
        ProcParameter[] p = new ProcParameter[4];
        p[0] = new ProcParameter(1, r);
        p[1] = new ProcParameter(2, s);
        p[2] = new ProcParameter(3, null, OracleTypes.CURSOR);
        p[3] = new ProcParameter(4, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_REPORT_S_REPORT, p);
            returnCode = (Integer) p[3].getValue();
            if (returnCode == 0) {
                ResultSet rs = (ResultSet) p[2].getValue();
                while (rs.next()) {
                    ProgressReport data =
                        new ProgressReport(rs.getInt("STUD_ID"), rs.getString("NAME"), rs.getString("SUB_NAME"),
                                           rs.getInt("CLASS_ID"), rs.getInt("TEST_NUM"), rs.getInt("TOT_MKS"),
                                           rs.getInt("MARKS_OBT"));
                    list.add(data);
                }
                return list;
            } else {
                System.out.println("Error while fetching TEST data from database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<MyReport> studReportselect(Connection con, int s) {
        int returnCode = 0;
        List<MyReport> list = new ArrayList<MyReport>();
        ProcParameter[] p = new ProcParameter[3];
        p[0] = new ProcParameter(1, s);
        p[1] = new ProcParameter(2, null, OracleTypes.CURSOR);
        p[2] = new ProcParameter(3, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_REPORT_S_MYREPORT, p);
            returnCode = (Integer) p[2].getValue();
            if (returnCode == 0) {
                ResultSet rs = (ResultSet) p[1].getValue();
                while (rs.next()) {
                    MyReport data =
                        new MyReport(rs.getInt("STUD_ID"), rs.getString("NAME"), rs.getString("SUB_NAME"),
                                     rs.getInt("TEST_NUM"), rs.getInt("TOT_MKS"), rs.getInt("MARKS_OBT"));
                    list.add(data);
                }
                return list;
            } else {
                System.out.println("Error while fetching TEST data from database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

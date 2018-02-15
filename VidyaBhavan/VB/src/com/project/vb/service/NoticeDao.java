package com.project.vb.service;

import com.project.vb.common.DbConstants;
import com.project.vb.common.DbProcedureInvoke;
import com.project.vb.common.ProcParameter;
import com.project.vb.output.MyNotices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleTypes;


public class NoticeDao extends DbProcedureInvoke {
    public NoticeDao() {
        super();
    }

    boolean insert(Connection con, int s, String str, Date dt, List<Integer> list) {
        try {
            PreparedStatement ps =
                con.prepareStatement("INSERT INTO NOTICE(NOTICE_ID,NOTICE_DATA,SUB_ID,NOTICE_DATE) " +
                                     "VALUES(NOTICE_ID_SEQ.NEXTVAL,?,?,?)");
            ps.setString(1, str);
            ps.setInt(2, s);
            ps.setDate(3, dt);
            ps.executeUpdate();

            PreparedStatement p =
                con.prepareStatement("INSERT INTO STUDNOTE_LINK(NOTICE_ID,STUD_ID,NOTICE_NUM) " +
                                     "VALUES(NOTICE_ID_SEQ.CURRVAL,?," +
                                     "(SELECT (NVL(MAX(NOTICE_NUM),0)+1) FROM STUDNOTE_LINK WHERE STUD_ID = ?))");
            for (Integer r : list) {
                p.setInt(1, r);
                p.setInt(2, r);
                p.addBatch();
            }
            p.executeBatch();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return false;
    }

    List<MyNotices> select(Connection con, int roll) {
        List<MyNotices> list = new ArrayList<MyNotices>();
        ProcParameter[] p = new ProcParameter[3];
        p[0] = new ProcParameter(1, roll);
        p[1] = new ProcParameter(2, null, OracleTypes.CURSOR);
        p[2] = new ProcParameter(3, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_NOTICE_S_NOTICE, p);
            if (0 == (Integer) p[2].getValue()) {
                ResultSet rs = (ResultSet) p[1].getValue();
                while (rs.next()) {
                    MyNotices n =
                        new MyNotices(rs.getInt("STUD_ID"), rs.getString("NAME"), rs.getString("SUB_NAME"),
                                      rs.getInt("NOTICE_NUM"), rs.getDate("NOTICE_DATE"), rs.getString("NOTICE_DATA"));

                    list.add(n);
                }
                return list;
            } else {
                System.out.println("Error while getting notice");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

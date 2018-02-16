package com.project.tutorial.jdbcdemo.service;

import com.project.tutorial.jdbcdemo.DbConstants;
import com.project.tutorial.jdbcdemo.ProcParameter;
import com.project.tutorial.jdbcdemo.model.Student;
import com.project.tutorial.jdbcdemo.user.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleTypes;

public class StudentDAO extends AbstractTableDAO<Student> {

    private static StudentDAO daoObj = null;

    private StudentDAO() {
        super();
    }

    public static StudentDAO getInstance() {
        if (daoObj == null) {
            daoObj = new StudentDAO();
        }
        return daoObj;
    }

    @Override
    public boolean insert(Connection con, Student s) throws SQLException, DbException {
        boolean returnVal = false;
        int returncode = 0;
        //Connection con = getConnection();
        ProcParameter[] p = new ProcParameter[5];
        p[0] = new ProcParameter(1, s.getId());
        p[1] = new ProcParameter(2, s.getName());
        p[2] = new ProcParameter(3, s.getBranch());
        p[3] = new ProcParameter(4, s.getAddress());
        p[4] = new ProcParameter(5, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_STUDENT_I_STUDENT, p);
            //  con.commit();
            returnVal = true;
            returncode = (Integer) p[4].getValue();
        } catch (SQLException e) {
            e.printStackTrace();

            //  con.rollback();
        } finally {
            if (0 != returncode) {
                throw new DbException("Returncode from proc" + returncode);
            }
            //con.close();
        }
        return returnVal;
    }

    @Override
    public boolean update(Connection con, Student s) throws SQLException, DbException {
        boolean returnVal = false;
        //Connection con = getConnection();
        ProcParameter[] p = new ProcParameter[5];
        p[0] = new ProcParameter(1, s.getId());
        p[1] = new ProcParameter(2, s.getName());
        p[2] = new ProcParameter(3, s.getBranch());
        p[3] = new ProcParameter(4, s.getAddress());
        p[4] = new ProcParameter(5, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_STUDENT_U_STUDENT, p);
            //       con.commit();
            returnVal = true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DbException(e.getMessage());
            //     con.rollback();
        } finally {
            //    con.close();
        }
        return returnVal;
    }

    public List<Student> select(Connection con, String name, String address, String branch,
                                int id) throws SQLException {
        List<Student> l = new ArrayList<Student>();

        ProcParameter[] p = new ProcParameter[2];
        StringBuilder sb = new StringBuilder("select * from Student where 1=1");
        if (name != null) {
            sb.append(" and NAME = '" + name + "'");
        } else if (address != null) {
            sb.append(" and ADDRESS = '" + address + "'");
        } else if (branch != null) {
            sb.append(" and BRANCH = '" + branch + "'");
        } else if (id != 0) {
            sb.append(" and ID = " + id);
        }
        Statement s = con.createStatement();

        try {
            ResultSet rs = s.executeQuery(sb.toString());
            while (rs.next()) {
                Student studOut = new Student();
                studOut.setId(rs.getInt("ID"));
                studOut.setAddress(rs.getString("ADDRESS"));
                studOut.setName(rs.getString("NAME"));
                studOut.setBranch(rs.getString("BRANCH"));
                l.add(studOut);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //  con.close();
        }
        return l;
    }

    @Override
    public boolean delete(Connection con, Student s) throws SQLException {
        boolean returnVal = false;
        //Connection con = getConnection();
        ProcParameter[] p = new ProcParameter[2];
        p = new ProcParameter[] { new ProcParameter(1, s.getId()), new ProcParameter(2, null, OracleTypes.INTEGER) };
        try {
            callProc(con, DbConstants.PA_STUDENT_D_STUDENT, p);
            //con.commit();
            returnVal = true;
        } catch (SQLException e) {
            e.printStackTrace();
            // con.rollback();
        } finally {
            // con.close();
        }
        return returnVal;
    }
}

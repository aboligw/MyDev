package com.project.vb.service;

import com.project.vb.common.DbConstants;
import com.project.vb.common.DbProcedureInvoke;
import com.project.vb.common.MyException;
import com.project.vb.common.ProcParameter;
import com.project.vb.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleTypes;


public class StudentDao extends DbProcedureInvoke {


    public StudentDao() {
        super();
    }


    public List<Student> select(Connection con, int roll, String name, int clas) {
        List<Student> list = new ArrayList<Student>();
        ProcParameter[] p = new ProcParameter[4];
        p[0] = new ProcParameter(1, roll);
        p[1] = new ProcParameter(2, name);
        p[2] = new ProcParameter(3, clas);
        p[3] = new ProcParameter(4, null, OracleTypes.CURSOR);
        try {
            callProc(con, DbConstants.PA_STUDENT_S_STUDENT, p);

            ResultSet rs = (ResultSet) p[3].getValue();
            while (rs.next()) {

                Student s = new Student();
                s.setId(rs.getInt("STUD_ID"));
                s.setName(rs.getString("NAME"));
                s.setClassId(rs.getInt("CLASS_ID"));
                s.setContact(rs.getInt("PARENTS_CONTACT_NO"));
                s.setAddress(rs.getString("ADDRESS"));
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Student selectStudentRollNo(Connection con, String uId) throws MyException {
        Student s = new Student();
        ProcParameter[] p = new ProcParameter[3];
        p[0] = new ProcParameter(1, uId);
        p[1] = new ProcParameter(2, null, OracleTypes.CURSOR);
        p[2] = new ProcParameter(3, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_STUDENT_GET_STUDENT_ROLL, p);
            if ((Integer) p[2].getValue() == 0) {
                ResultSet rs = (ResultSet) p[1].getValue();
                while (rs.next()) {
                    s.setId(rs.getInt("STUD_ID"));
                    s.setName(rs.getString("NAME"));
                    s.setUserId("USER_ID");
                    System.out.println("DAO found" + s);
                }
            } else {
                throw new MyException((Integer) p[2].getValue());
                //System.out.println("Select rollno failed");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    List<Integer> selectStudFromSchool(Connection con, int clas) {
        int returnCode = 0;
        List<Integer> list = new ArrayList<Integer>();
        ProcParameter[] p = new ProcParameter[3];
        p[0] = new ProcParameter(1, clas);
        p[1] = new ProcParameter(2, null, OracleTypes.CURSOR);
        p[2] = new ProcParameter(3, null, OracleTypes.INTEGER);
        try {
            callProc(con, DbConstants.PA_STUDENT_GET_STUDENT_FROM_SCHOOL, p);
            returnCode = (Integer) p[2].getValue();
            if (returnCode == 0) {
                ResultSet rs = (ResultSet) p[1].getValue();
                while (rs.next()) {
                    list.add(rs.getInt("STUD_ID"));
                }
            } else {
                System.out.println("No student in school");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

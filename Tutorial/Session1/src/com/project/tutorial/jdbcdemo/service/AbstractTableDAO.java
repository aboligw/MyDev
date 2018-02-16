package com.project.tutorial.jdbcdemo.service;

import com.project.tutorial.jdbcdemo.ProcParameter;
import com.project.tutorial.jdbcdemo.user.DbException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTableDAO<T> {
    public abstract boolean insert(Connection con, T s) throws SQLException, DbException;

    public abstract boolean update(Connection con, T s) throws SQLException, DbException;

    //public abstract Student select(Connection con, T s) throws SQLException;

    public abstract boolean delete(Connection con, T s) throws SQLException;

    public void callProc(Connection con, String procName, ProcParameter[] inParam) throws SQLException {
        List<Integer> outList = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder("{call ");
        sb.append(procName).append("(");
        int length = (null == inParam ? 0 : inParam.length);
        for (int i = 0; i < length; i++) {
            sb.append("?,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")}");

        CallableStatement cs = con.prepareCall(sb.toString());
        for (int i = 0; i < (null == inParam ? 0 : inParam.length); i++) {
            if (null != inParam[i].getValue())
                cs.setObject(inParam[i].getIndex(), inParam[i].getValue());
            if (inParam[i].getType() != -1) {
                cs.registerOutParameter(inParam[i].getIndex(), inParam[i].getType());
                outList.add(i);
            }
        }
        cs.executeUpdate();
        for (int i : outList) {
            inParam[i].setValue(cs.getObject(inParam[i].getIndex()));
        }
    }
}

package com.project.vb.service;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.ConnectionManager;
import com.project.vb.output.MyNotices;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class NoticeFacade {
    private NoticeDao daoObj = BeanGetter.getBean("noticeDao", NoticeDao.class);


    private NoticeFacade() {
        super();
    }


    public boolean insert(int s, String str, Date dt, List<Integer> list) throws SQLException {
        Connection con = ConnectionManager.getConnection();
        try {
            return daoObj.insert(con, s, str, dt, list);
        } finally {
            con.close();
        }
    }

    public List<MyNotices> select(int roll) throws SQLException {
        List<MyNotices> list = new ArrayList<MyNotices>();
        Connection con = ConnectionManager.getConnection();
        try {
            return daoObj.select(con, roll);
        } finally {
            con.close();
        }
    }
}

package com.project.vb.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.output.MyNotices;
import com.project.vb.service.NoticeFacade;

import java.sql.Date;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class NoticeBD {
    public NoticeBD() {
        super();
    }
    NoticeFacade f = BeanGetter.getBean("noticeFacade", NoticeFacade.class);

    public boolean insert(int s, String str, Date dt, List<Integer> list) {
        try {
            return f.insert(s, str, dt, list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<MyNotices> select(int roll) {
        List<MyNotices> list = new ArrayList<MyNotices>();
        try {
            return f.select(roll);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

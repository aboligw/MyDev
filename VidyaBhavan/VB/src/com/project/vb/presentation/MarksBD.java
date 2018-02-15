package com.project.vb.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.output.MyReport;
import com.project.vb.output.ProgressReport;
import com.project.vb.service.MarksFacade;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class MarksBD {
    private MarksFacade f = BeanGetter.getBean("marksFacade", MarksFacade.class);

    public MarksBD() {
        super();
    }

    public void bulkInsert(List<String> list, int eNo) {
        try {
            f.insert(list, eNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ProgressReport> select(int r, int s) {
        List<ProgressReport> list = new ArrayList<ProgressReport>();
        try {
            list = f.select(r, s);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<MyReport> studReportselect(int s) {
        List<MyReport> list = new ArrayList<MyReport>();
        try {
            list = f.studReportselect(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

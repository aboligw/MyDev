package com.project.vb.presentation;

import com.project.vb.common.BeanGetter;
import com.project.vb.service.ExamFacade;

import java.sql.SQLException;


public class ExamBD {
    private ExamFacade f = BeanGetter.getBean("examFacade", ExamFacade.class);

    public ExamBD() {
        super();
    }

    public int insert(int subId, int totMks, int classId) {
        try {
            return f.insert(subId, totMks, classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int select(int subId, int clsId, int testNo) {
        try {
            return f.select(subId, clsId, testNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

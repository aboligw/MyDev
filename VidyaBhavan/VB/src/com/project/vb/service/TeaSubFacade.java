package com.project.vb.service;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;

public class TeaSubFacade {
    private TeaSubDao daoObj = BeanGetter.getBean("teaSubDao", TeaSubDao.class);


    public TeaSubFacade() {
        super();
    }


    public int select(int t) throws SQLException {

        //boolean returnStat = true;
        int sub = 0;
        Connection con = ConnectionManager.getConnection();
        try {
            sub = daoObj.select(con, t);

        } finally {
            con.close();
        }
        return sub;
    }


}

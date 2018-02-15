package com.project.vb.service;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.ConnectionManager;
import com.project.vb.model.Teacher;

import java.sql.Connection;
import java.sql.SQLException;

public class TeacherFacade {

    private TeacherDao TeacherDaoObj = BeanGetter.getBean("teacherDao", TeacherDao.class);

    private TeacherFacade() {
        super();
    }


    public Teacher select(String userId, int id, String name) throws SQLException {
        Teacher t = new Teacher();
        Connection con = ConnectionManager.getConnection();
        try {
            t = TeacherDaoObj.select(con, userId, id, name);
            if (t != null) {
                return t;
            }
        } finally {
            con.close();
        }
        return null;
    }
}

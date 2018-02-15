package com.project.vb.service;

import com.project.vb.common.BeanGetter;
import com.project.vb.common.ConnectionManager;
import com.project.vb.common.MyException;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginFacade {

    private LoginDao loginDaoObj = BeanGetter.getBean("loginDao", LoginDao.class);

    private LoginFacade() {
        super();
    }


    public boolean select(String uname, String pwd, String role) throws SQLException {
        System.out.println("Inside facade");
        boolean returnStat = true;
        int user = 0;
        Connection con = ConnectionManager.getConnection();
        try {
            user = loginDaoObj.select(con, uname, pwd, role);
            if (user != 0) {
                returnStat = false;
            }
            /*    if (user == -11)
                    System.out.println("Invalid user name");
                else if (user == -12)
                    System.out.println("Invalid password");
                else if (user == -13)
                    System.out.println("Invalid role");
            }*/
        } catch (MyException e) {
            returnStat = false;
            System.out.println(e.toString());
        } finally {
            con.close();
        }
        return returnStat;
    }
}

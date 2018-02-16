package com.project.vidyabhavan.online.presentation.Common.JavaClasses;

import com.project.vb.common.BeanGetter;
import com.project.vb.model.Login;
import com.project.vb.presentation.LoginBD;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CommonUtils {
    public CommonUtils() {
        super();
    }

    public static Date formatDate(String str) {
        Date dt = null;
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        try {
            dt = new Date(sd.parse(str).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static boolean doLoginUser(Login user) {
        LoginBD bdObj = BeanGetter.getBean("loginBD", LoginBD.class);
        boolean loginStatus = bdObj.select(user.getUserId(), user.getPwd(), user.getRole());
        return loginStatus;
    }
}

package com.project.vidyabhavan.online.webservices;


import com.project.vb.model.Login;
import com.project.vb.presentation.LoginBD;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "Login", serviceName = "LoginService", portName = "LoginPort")
public class LoginWs {
    public LoginWs() {
        super();
    }

    @WebMethod
    public String loginUser(@WebParam(name = "arg0") Login credentials) {
        LoginBD bdObj =null; // BeanGetter.getBean("loginBD", LoginBD.class);
        boolean x = bdObj.select(credentials.getUserId(), credentials.getPwd(), credentials.getRole());
        if (x) {
            return "Login is successful from WEBSERVICE";
        } else {
            return "FALIURE --- webservice";
        }
    }
}

package com.project.vidyabhavan.SpringWebservice;

import com.project.vb.common.BeanGetter;
import com.project.vb.presentation.LoginBD;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoginEndPoint {

    @PayloadRoot(namespace = "http://localhost:7000/VidyaBhavan/login", localPart = "loginUserRequest")
    @ResponsePayload
    public LoginUserResponse authenticateUserJdomService(@RequestPayload LoginUserRequest in) {

        String user = in.getUserName();
        String pass = in.getPassword();
        LoginUserResponse out = new LoginUserResponse();
        LoginBD bdObj = BeanGetter.getBean("loginBD", LoginBD.class);

        boolean loginStat = bdObj.select(user, pass, "TEACHER");
        if (loginStat) {
            out.setMessage("Login OKAY!");
        } else {
            out.setMessage("Login FAILED!");
        }
        return out;
    }
}

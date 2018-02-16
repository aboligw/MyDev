package com.project.vidyabhavan.SpringWebservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "loginUserRequest", namespace = "http://localhost:7000/VidyaBhavan/login")
public class LoginUserRequest {
    private String userName;
    private String password;

    public LoginUserRequest() {
        super();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

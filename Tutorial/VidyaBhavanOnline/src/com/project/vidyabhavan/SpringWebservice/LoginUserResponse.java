package com.project.vidyabhavan.SpringWebservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "loginUserResponse", namespace = "http://localhost:7000/VidyaBhavan/login")
public class LoginUserResponse {
    private String message;

    public LoginUserResponse() {
        super();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

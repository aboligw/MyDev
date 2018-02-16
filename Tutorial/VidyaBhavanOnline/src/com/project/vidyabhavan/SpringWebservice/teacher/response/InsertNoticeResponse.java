package com.project.vidyabhavan.SpringWebservice.teacher.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "insertNoticeResponse", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
public class InsertNoticeResponse {
    private String message;

    public InsertNoticeResponse() {
        super();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

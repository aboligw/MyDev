package com.project.vidyabhavan.SpringWebservice.teacher.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "insertExamResponse", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
public class InsertExamResponse {
    private String message;

    public InsertExamResponse() {
        super();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

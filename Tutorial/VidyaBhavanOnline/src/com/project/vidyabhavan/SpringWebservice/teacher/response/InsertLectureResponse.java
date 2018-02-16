package com.project.vidyabhavan.SpringWebservice.teacher.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "insertLectureResponse", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
public class InsertLectureResponse {
    private String message;

    public InsertLectureResponse() {
        super();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


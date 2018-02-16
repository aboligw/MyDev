package com.project.vidyabhavan.SpringWebservice.teacher.request;

import com.project.vb.model.Lecture;
import com.project.vb.model.Login;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "insertLectureRequest", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
public class InsertLectureRequest {
    private Login login;
    private Lecture lecture;
    private String dateStr;

    public InsertLectureRequest() {
        super();
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Lecture getLecture() {
        return lecture;
    }
}

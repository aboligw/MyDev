package com.project.vidyabhavan.SpringWebservice.teacher.request;

import com.project.vb.model.Exam;
import com.project.vb.model.Login;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "insertExamRequest", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
public class InsertExamRequest {
    private Login login;
    private Exam exam;


    public InsertExamRequest() {
        super();
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Exam getExam() {
        return exam;
    }

}

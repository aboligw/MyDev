package com.project.vidyabhavan.SpringWebservice.teacher.request;

import com.project.vb.model.Login;
import com.project.vb.model.Student;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "studInfoRequest", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
@XmlType(name = "studInfoRequest", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
public class StudInfoRequest {
    private Login login;
    private Student student;

    public void setLogin(Login login) {
        this.login = login;
    }

    public Login getLogin() {
        return login;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

}

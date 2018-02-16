package com.project.vidyabhavan.SpringWebservice.teacher.request;

import com.project.vb.model.Login;
import com.project.vb.model.Notice;
import com.project.vb.model.Student;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "insertNoticeRequest", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
public class InsertNoticeRequest {
    private Login login;
    private Notice notice;
    private Student student;
    private int criteria;
    private int classNo;
    private String dateStr;


    public InsertNoticeRequest() {
        super();
    }


    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
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

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setCriteria(int criteria) {
        this.criteria = criteria;
    }

    public int getCriteria() {
        return criteria;
    }
}

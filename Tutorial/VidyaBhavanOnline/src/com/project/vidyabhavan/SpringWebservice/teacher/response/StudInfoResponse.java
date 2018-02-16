package com.project.vidyabhavan.SpringWebservice.teacher.response;

import com.project.vb.model.Student;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "studInfoResponse", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
@XmlType(name = "studInfoResponse", namespace = "http://localhost:7000/VidyaBhavan/Teacher")
public class StudInfoResponse {
    private List<Student> studOut;

    public StudInfoResponse() {
        super();
    }

    public void setStudOut(List<Student> studOut) {
        this.studOut = studOut;
    }

    public List<Student> getStudOut() {
        return studOut;
    }
}

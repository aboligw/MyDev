package com.project.vb.model;

import com.project.vb.common.BeanGetter;
import static com.project.vb.common.MyScanner.display;
import static com.project.vb.common.MyScanner.getInt;
import static com.project.vb.common.MyScanner.getString;
import com.project.vb.presentation.LectureBD;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Lecture {
    private int lecId;
    private int subId;
    private int teacherId;
    private int classId;
    private int duration;
    private Date dateOfLec;
    private int lecNo;

    LectureBD l = BeanGetter.getBean("lectureBD", LectureBD.class);

    public Lecture() {
        super();
    }

    void gatherLecData(int teacherId) {
        this.setTeacherId(teacherId);

        display("Enter date of Lecture");
        this.setDateOfLec(getString());

        display("Enter duration");
        this.setDuration(getInt());

        display("Enter class No");
        //if(CorrectClassInput)
        this.setClassId(getInt());

        TeaSubLink ts = new TeaSubLink();
        int sub = ts.select(teacherId);
        System.out.println("Subject is :" + sub);
        this.setSubId(sub);
        this.setLecId(l.insert(subId, classId, teacherId, duration, dateOfLec, lecNo));
    }

    public int selectLectID(Date d, int clsId, int lecNo, int teacherId) {
        return l.select(d, clsId, lecNo, teacherId);
    }

    public String toString() {
        return "LEC ID: " + lecId + "\nSUB ID: " + subId + "\nCLASS: " + classId + "\nTEACHER: " + teacherId +
               "\nDURATION: " + duration + "\nDate: " + dateOfLec + "\n Lec no: " + lecNo;
    }

    public void setLecId(int lecId) {
        this.lecId = lecId;
    }

    public int getLecId() {
        return lecId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getSubId() {
        return subId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDateOfLec(String str) {
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.dateOfLec = new Date(sd.parse(str).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDateOfLec() {
        return dateOfLec;
    }

    public void setLecNo(int lecNo) {
        this.lecNo = lecNo;
    }

    public int getLecNo() {
        return lecNo;
    }


}

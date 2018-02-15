package com.project.vb.model;


import com.project.vb.common.BeanGetter;
import static com.project.vb.common.MyScanner.display;
import static com.project.vb.common.MyScanner.getInt;
import static com.project.vb.common.MyScanner.getString;
import com.project.vb.output.MyNotices;
import com.project.vb.presentation.NoticeBD;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

public class Notice {
    private int noticeId;
    private String data;
    private int subId;
    private Date noteDate;
    private NoticeBD bdObj = BeanGetter.getBean("noticeBD", NoticeBD.class);

    public Notice() {
        super();
    }

    public void sendNotice(int s) {
        List<Integer> list = new ArrayList<Integer>();
        showNoticeMenu();
        int choice = getInt();
        switch (choice) {
        case 1:
            display("Enter roll number");
            int r = getInt();
            list.add(r);
            break;
        case 2:
            display("Enter class number");
            int c = getInt();
            Student stud = new Student();
            list = stud.getStudFromSchool(c);
            break;
        case 3:
            Student schoolStud = new Student();
            list = schoolStud.getStudFromSchool(0);
            break;
        }
        display("Enter notice text");
        String str = getString();
        display("you entered :" + str);
        Date dt = null;
        display("Enter date(dd-MM-yyyy) format ");
        String dtStr = getString();
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        try {
            dt = new Date(sd.parse(dtStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //display(str);
        boolean result = bdObj.insert(s, str, dt, list);
        if (!result)
            display("Notice is not inserted in db");
    }

    public void getNotices(int roll) {
        List<MyNotices> list = new ArrayList<MyNotices>();
        list = bdObj.select(roll);
        for (MyNotices n : list) {
            System.out.println(n);
        }
    }

    private void showNoticeMenu() {
        display("Select target");
        display("1> Student    2> Class   3> School");
        display("enter your choice");
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getSubId() {
        return subId;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }

    public Date getNoteDate() {
        return noteDate;
    }


}

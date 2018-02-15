package com.project.vb.output;

import java.sql.Date;

public class MyNotices {
    private int roll;
    private String name;
    private String sub;
    private int num;
    private Date dt;
    private String data;

    public MyNotices() {
        super();
    }

    public MyNotices(int roll, String name, String sub, int num, Date dt, String data) {
        this.roll = roll;
        this.name = name;
        this.sub = sub;
        this.num = num;
        this.dt = dt;
        this.data = data;
    }

    public String toString() {
        return roll + "  " + name + "  " + sub + "  " + num + "  " + dt + "  " + data;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getRoll() {
        return roll;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getSub() {
        return sub;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Date getDt() {
        return dt;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

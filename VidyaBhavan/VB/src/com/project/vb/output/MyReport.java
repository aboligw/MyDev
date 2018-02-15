package com.project.vb.output;


public class MyReport {
    private int roll;
    private String name;
    private String sub;
    private int tNo;
    private int totMks;
    private int obtMks;

    public MyReport() {
        super();
    }

    public MyReport(int roll, String name, String sub, int tNo, int totMks, int obtMks) {
        this.roll = roll;
        this.name = name;
        this.sub = sub;
        this.tNo = tNo;
        this.totMks = totMks;
        this.obtMks = obtMks;
    }

    public String toString() {
        return roll + "  " + name + "  " + sub + "  " + tNo + "  " + totMks + "  " + obtMks;
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

    public void setTNo(int tNo) {
        this.tNo = tNo;
    }

    public int getTNo() {
        return tNo;
    }

    public void setTotMks(int totMks) {
        this.totMks = totMks;
    }

    public int getTotMks() {
        return totMks;
    }

    public void setObtMks(int obtMks) {
        this.obtMks = obtMks;
    }

    public int getObtMks() {
        return obtMks;
    }
}

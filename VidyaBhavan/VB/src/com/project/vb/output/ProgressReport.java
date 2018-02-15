package com.project.vb.output;


public class ProgressReport {
    private int roll;
    private String name;
    private String subject;
    private int cls;
    private int testNo;
    private int totMks;
    private int obtMks;

    public ProgressReport(int roll, String name, String sub, int cls, int testNo, int totMks, int obtMks) {
        this.roll = roll;
        this.name = name;
        this.subject = sub;
        this.cls = cls;
        this.testNo = testNo;
        this.totMks = totMks;
        this.obtMks = obtMks;
    }

    public String toString() {
        return roll + "  " + name + "  " + subject + "  " + cls + "  " + testNo + "  " + totMks + "  " + obtMks + "\n";
    }

    public ProgressReport() {
        super();
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

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setCls(int cls) {
        this.cls = cls;
    }

    public int getCls() {
        return cls;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public int getTestNo() {
        return testNo;
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

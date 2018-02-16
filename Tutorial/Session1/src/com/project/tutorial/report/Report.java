package com.project.tutorial.report;

import java.util.HashMap;

public class Report {//implements Comparable{
    private int studentId;
    private int testId;
    private int obtMks;
    
    public Report() {
        super();
    }
    public String display(HashMap<Integer,Test> t){
        Test temp=t.get(this.getTestId());
        return "\n"+temp.getSub()+":  "+this.getObtMks()+"/"+temp.getTotMks();
     }

    
  /*  public int compareTo(Object object) {
        System.out.println("In Compareto now");
        if(this.testId>((Report)object).getTestId()) return 1;
        if(this.testId<((Report)object).getTestId()) return -1;
        return 0;
    }*/

    
    public int hashCode() {
        System.out.println("In hashcode now");
        return this.getTestId();
    }

    public boolean equals(Report p){
        System.out.println("In equals now");
        return((this.testId == p.getTestId()) && (this.studentId==(p.getStudentId())));
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getTestId() {
        return testId;
    }

    public void setObtMks(int obtMks) {
        this.obtMks = obtMks;
    }

    public int getObtMks() {
        return obtMks;
    }

    public String toString(){
        return "In Report tostring override";
    }
  
}

package com.project.vb.model;

import com.project.vb.common.BeanGetter;
import static com.project.vb.common.MyScanner.display;
import static com.project.vb.common.MyScanner.getInt;
import com.project.vb.presentation.ExamBD;

public class Exam {
    private int testId;
    private int subId;
    private int totMks;
    private int classId;
    private int testNum;

    private ExamBD bdObj = BeanGetter.getBean("examBD", ExamBD.class);

    public Exam() {
        super();
    }

    void gatherExamData(int tId) {
        display("Enter class?");
        this.setClassId(getInt());

        display("Enter total Marks");
        this.setTotMks(getInt());

        TeaSubLink ts = new TeaSubLink();
        this.setSubId(ts.select(tId));

        bdObj.insert(subId, totMks, classId);
    }

    int selectTestId(int subId, int clsId, int testNo) {
        return bdObj.select(subId, clsId, testNo);
    }

    public String toString() {
        return "testId: " + testId + "\nsubId: " + subId + "\ntotMks: " + totMks + "\nclassId: " + classId +
               "\ntestNum: " + testNum;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getTestId() {
        return testId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getSubId() {
        return subId;
    }

    public void setTotMks(int totMks) {
        this.totMks = totMks;
    }

    public int getTotMks() {
        return totMks;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getClassId() {
        return classId;
    }

    public void setTestNum(int testNum) {
        this.testNum = testNum;
    }

    public int getTestNum() {
        return testNum;
    }


}

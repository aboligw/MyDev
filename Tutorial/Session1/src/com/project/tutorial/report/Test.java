package com.project.tutorial.report;
import static com.project.tutorial.common.MyScanner.*;

public class Test {
    private static int testID =0;
    private int testNo;
    private String sub;
    private int totMks;
//    private int obtMks;
    private Boolean completeFlag=false;
    public Test() {
        super();
    }

    public void getTestInfo(){
        System.out.println("Enter Subject");
        this.setSub(getString());
        System.out.println("Enter total Marks");
        this.setTotMks(getInt());
        Test.testID++;
        this.setTestNo(Test.testID);
  //      this.obtMks = 0;
        this.setCompleteFlag(false);
    }

    public void setTestNo(int testID) {
        this.testNo = testID;
    }

    public int getTestNo() {
        return testNo;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getSub() {
        return sub;
    }

    public void setTotMks(int totMks) {
        this.totMks = totMks;
    }
    public int getTotMks() {
        return totMks;
    }
 /*   public void setObtMks(int obtMks) {
        this.obtMks = obtMks;
    }

    public int getObtMks() {
        return obtMks;
    }*/
    public void setCompleteFlag(Boolean completeFlag) {
        this.completeFlag = completeFlag;
    }

    public Boolean getCompleteFlag() {
        return completeFlag;
    }
}

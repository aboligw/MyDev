package com.project.tutorial.report;

import static com.project.tutorial.common.MyScanner.getInt;
import static com.project.tutorial.common.MyScanner.getString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Student {
    private String name;
    private int rollNo;
    private HashSet<Report> mks;

    public Student() {
        super();
    }

    public void getStudInfo() {
        System.out.println("Enter roll number");
        this.rollNo = getInt();
        System.out.println("Enter the name");
        this.name = getString();
        this.mks = new HashSet<Report>();
        return;
    }

    public void takeTest(Test t) {
        Report r = new Report();
        r.setStudentId(this.rollNo);
        r.setTestId(t.getTestNo());
        r.setObtMks(0);
        this.mks.add(r);
    }

    public void reportCard(HashMap<Integer, Student> s, HashMap<Integer, Test> t, Teacher teach) { // throws MySecurityException {
        Iterator<Report> i = this.getMks().iterator();
        ArrayList<String> d = new ArrayList<String>();

        while (i.hasNext()) {
            Report r = i.next();
            d.add(r.display(t));

        }
        Collections.sort(d);

        StringBuffer output = new StringBuffer();
        String[] x1 = (d.get(0)).split(":");
        String prev = x1[0];
        String curr = x1[0];

        output.append("Roll No: " + this.getRollNo() + "\nName: " + this.getName() + "\n" + teach.getSubject());
        for (int j = 0; j < d.size(); j++) {

            String[] loopDelim = (d.get(j)).split(":");
            curr = loopDelim[0].trim();
            System.out.println("LoopDelim[0] before ....." + loopDelim[0]);
            if (prev.equals(curr)) {
                if (curr.equals(teach.getSubject())) {
                    output.append(loopDelim[1]);
                }
            } else {
                prev = loopDelim[0];
                System.out.println("Hello ....." + teach.getSubject());
                System.out.println("Hello curr ....." + curr);
                System.out.println("LoopDelim[0] ....." + loopDelim[0]);
                if (curr.equals(teach.getSubject())) {
                    output.append(loopDelim[1]);
                }
            }
        }
        System.out.println(output.toString());
    }

    public String displayMks(Collection<Report> mksSet, HashMap<Integer, Test> t) {
        Iterator<Report> i = mksSet.iterator();
        StringBuffer mksArr = new StringBuffer();
        while (i.hasNext()) {
            Report r = i.next();
            mksArr.append(r.display(t));
        }
        return mksArr.toString();
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public HashSet<Report> getMks() {
        return mks;
    }
}

package com.project.vb.model;

import com.project.vb.common.BeanGetter;
import static com.project.vb.common.MyScanner.display;
import static com.project.vb.common.MyScanner.getInt;
import com.project.vb.output.MyReport;
import com.project.vb.output.ProgressReport;
import com.project.vb.presentation.MarksBD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


public class Marks {
    private int studId;
    private int testId;
    private int marks;
    private MarksBD bdObj = BeanGetter.getBean("marksBD", MarksBD.class);

    public Marks() {
        super();
    }

    public void uploadMarks(int i) throws IOException {
        File marksFile = new File("Marks.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(marksFile));
            String line = br.readLine();
            String[] arr = line.split(",");
            int clsId = Integer.parseInt(arr[0]);
            int testNo = Integer.parseInt(arr[1]);
            TeaSubLink t = new TeaSubLink();
            Exam e = new Exam();
            int eNo = e.selectTestId(t.select(i), clsId, testNo);
            System.out.println(eNo);
            List<String> list = new ArrayList<String>();
            while (line != null) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                list.add(line);
            }
            bdObj.bulkInsert(list, eNo);
            //insert Attendance rec*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    void getReportCard(int tId) {
        display("Enter roll number");
        int r = getInt();

        TeaSubLink t = new TeaSubLink();
        int s = t.select(tId);
        List<ProgressReport> list = new ArrayList<ProgressReport>();
        list = bdObj.select(r, s);
        try {
            FileWriter fileOut = new FileWriter("ProgressReport.txt");
            for (ProgressReport out : list) {
                fileOut.write(out.toString());
            }
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void myReport(int i) {
        List<MyReport> list = new ArrayList<MyReport>();
        list = bdObj.studReportselect(i);
        if (list == null) {
            display("No report available now!");
        } else {
            display("ROLL NAME     SUBJECT  TEST# TOTAL OBT_MKS");
            for (MyReport x : list) {
                display(x.toString());
            }
        }
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public int getStudId() {
        return studId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getTestId() {
        return testId;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}

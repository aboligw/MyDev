package com.project.tutorial.enumdemo;

import static com.project.tutorial.common.MyScanner.display;
import static com.project.tutorial.common.MyScanner.getDouble;
import static com.project.tutorial.common.MyScanner.getInt;
import static com.project.tutorial.common.MyScanner.getString;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class InterestReporter {
    double principle;
    double roi;
    Date endDate;
    Date startDate;
    Rounding round;
    boolean start = true;
    private int graceDays;
    private int period;

    public InterestReporter() {
        super();
    }

    private void getData() {
        display("Enter principle amount");
        setPrinciple(getDouble());
        display("Enter Rate of Interest");
        setRoi(getDouble());
        display("Enter start date");
        setStartDate(getString());
        display("Enter endDate");
        setEndDate(getString());
        display("Enter Grace period");
        int x = getInt();
        for (Grace t : Grace.values()) {
            if (x == t.num())
                this.graceDays = t.days();
        }
    }

    private void intCalc(List<MonthlyPayment> ar) {
        if (this.getStartDate().compareTo(this.getEndDate()) >= 0) {
            return;
        }
        Calendar dueDate = Calendar.getInstance();
        if (this.start) {
            dueDate.setTime(this.getStartDate());
            dueDate.add(dueDate.MONTH, 1);
            dueDate.add(dueDate.DATE, this.graceDays);
            //     this.start = false;

        } else {
            dueDate.setTime(this.getStartDate());
            dueDate.add(dueDate.MONTH, 1);
        }
        if (dueDate.getTime().compareTo(this.endDate) >= 0) {
            dueDate.setTime(this.getEndDate());
        }
        Date newStartDate = dueDate.getTime();
        int totdiff = calDiffDays(dueDate);

        display("New dueDate " + dueDate.getTime());
        display("Days Diff is " + totdiff);
        double prin = calcPrin(this.principle, totdiff);
        double intAmt = calcIntAmt(this.principle, totdiff, this.roi);
        //   display("Principal :" + prin);
        //   display("Interest" + intAmt);
        addtoList(newStartDate, prin, intAmt, ar);
        this.startDate = newStartDate;
    }

    public static void main(String[] args) {
        InterestReporter obj = new InterestReporter();
        obj.getData();
        List<MonthlyPayment> ar = new ArrayList<MonthlyPayment>();
        Calendar temp = Calendar.getInstance();
        temp.setTime(obj.getEndDate());
        obj.period = obj.calDiffDays(temp);
        while (obj.getStartDate().compareTo(obj.getEndDate()) < 0) {
            obj.intCalc(ar);
        }
        System.out.println("Due Date                 Principle      Interest       Total       Ceiling           Floor");
        for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
        }
    }

    public void setPrinciple(double principle) {
        this.principle = principle;
    }

    public double getPrinciple() {
        return principle;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public double getRoi() {
        return roi;
    }

    public void setEndDate(String x) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.endDate = sf.parse(x);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setStartDate(String startDate) {
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.startDate = sf.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getStartDate() {
        return startDate;
    }


    private double calcPrin(double d, int totdiff) {
        return ((d * totdiff) / this.period);
    }

    private double calcIntAmt(double d, int totdiff, double r) {
        if (this.start && totdiff >= this.graceDays) {
            totdiff = totdiff - this.graceDays;
            this.start = false;
        }
        return ((d * totdiff * r) / 36500);
    }

    private int calDiffDays(Calendar dueDate) {
        int totdiff = 0;
        display("Final dueDate is" + dueDate.getTime());
        // display("Start date is" + getStartDate());
        while (this.getStartDate().compareTo(dueDate.getTime()) < 0) {
            totdiff++;
            dueDate.add(dueDate.DATE, -1);
        }
        return totdiff;
    }

    private void addtoList(Date newStartDate, double prin, double intAmt, List<MonthlyPayment> ar) {
        MonthlyPayment d = new MonthlyPayment();
        d.setD(newStartDate);
        d.setInterest(intAmt);
        d.setPrin(prin);
        d.setTotal(prin + intAmt);
        d.setDownTotal(Math.floor(d.getTotal()));
        d.setUpTotal(Math.ceil(d.getTotal()));
        ar.add(d);
    }
}

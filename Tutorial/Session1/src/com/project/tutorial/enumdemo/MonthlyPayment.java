package com.project.tutorial.enumdemo;

import java.util.Date;

public class MonthlyPayment {
    public Date d;
    public double prin;
    public double interest;
    public double total;
    public double upTotal;
    public double downTotal;

    public String toString() {
        String resultPrin = String.format("%.2f", prin);
        String Rinterest = String.format("%.2f", interest);
        return ".." + d + "   " + resultPrin + "   " + Rinterest + "   " + total + "    " + upTotal + "      " +
               downTotal;
    }

    public void setUpTotal(double upTotal) {
        this.upTotal = upTotal;
    }

    public double getUpTotal() {
        return upTotal;
    }

    public void setDownTotal(double downTotal) {
        this.downTotal = downTotal;
    }

    public double getDownTotal() {
        return downTotal;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public Date getD() {
        return d;
    }

    public void setPrin(double prin) {
        this.prin = prin;
    }

    public double getPrin() {
        return prin;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}

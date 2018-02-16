package com.project.tutorial.report;

import static com.project.tutorial.common.MyScanner.getInt;
import static com.project.tutorial.common.MyScanner.getString;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class RepGenerator {
    public RepGenerator() {
        super();
    }

    public static void main(String[] args) throws MySecurityException {
        HashMap<Integer, Student> sMap = new HashMap<Integer, Student>();
        HashMap<Integer, Test> tMap = new HashMap<Integer, Test>();
        Teacher teacher = new Teacher();
        System.out.println("Enter what is ur subject?");
        teacher.setSubject(getString()); //teachers subject
        String ch = "Y";
        int choice = 0;

        while (ch.equalsIgnoreCase("Y")) {
            choice = displayMenu();
            switch (choice) {
            case 1:
                //add new student to db
                Student s1 = new Student();
                s1.getStudInfo();
                if (sMap.containsKey(s1.getRollNo())) {
                    System.out.println("Roll number should be unique.");
                } else {
                    sMap.put(s1.getRollNo(), s1);
                }
                displayDB(sMap, tMap);
                break;
            case 2:
                Test t = new Test();
                t.getTestInfo();
                tMap.put(t.getTestNo(), t);
                System.out.println("Enter roll numbers");
                String strInp = getString();
                Scanner scan = new Scanner(strInp);
                scan.useDelimiter(",");
                while (scan.hasNext()) {
                    int roll = Integer.parseInt(scan.next());
                    if (sMap.containsKey(roll)) {
                        Student temp = sMap.get(roll);
                        //null pointer exception logic here
                        temp.takeTest(t);
                        sMap.put(temp.getRollNo(), temp);
                        displayDB(sMap, tMap);
                    } else {
                        System.out.println("This roll number is not in database");
                    }

                }
                scan.close();
                break;
            case 3:
                //check paper

                System.out.println("Enter roll number");
                Student cpTemp = sMap.get(getInt());
                //null ptr exception
                checkPaper(cpTemp, tMap);
                displayDB(sMap, tMap);
                break;
            case 4:
                //generate and diaplay report card
                System.out.println("Enter desired roll number");
                Student disps = sMap.get(getInt());
                System.out.println("Enter the subject to generate report");

                if (teacher.getSubject().equals(getString()))
                    disps.reportCard(sMap, tMap, teacher);
                else
                    throw new MySecurityException("In my exception");
                // catch (MySecurityException e) {
                //    System.out.println(e);
                // }
                break;
            }
            System.out.println("Continue?");
            ch = getString();
        }
    }


    public static void checkPaper(Student s, HashMap<Integer, Test> t) {
        System.out.println("Enter Subject");
        String subcp = getString();

        Test updObj = new Test();
        updObj = findTestMapElementToUpd(t, subcp);

        if (updObj.getCompleteFlag()) {
            System.out.println("Enter marks obtained");
            //find report set entry for stud and upd obt mks
            Report tempRep = new Report();
            Iterator<Report> irep = s.getMks().iterator();
            while (irep.hasNext()) {
                tempRep = irep.next();
                if (tempRep.getTestId() == updObj.getTestNo()) {
                    tempRep.setObtMks(getInt());
                    s.getMks().add(tempRep);
                }
            }
        } else {
            System.out.println("roll no + subject unchecked paper not present");
        }
    }

    public static Test findTestMapElementToUpd(HashMap<Integer, Test> t, String subcp) {
        Test updObj = new Test();
        Collection<Test> vs = t.values();
        Iterator<Test> icp = vs.iterator();

        while (icp.hasNext()) {
            Test tcp = icp.next();
            if (tcp.getSub().equalsIgnoreCase(subcp) && false == tcp.getCompleteFlag()) {
                updObj = tcp;
                updObj.setCompleteFlag(true);
                break;
            }
        }
        return updObj;
    }

    public static void displayDB(HashMap<Integer, Student> m, HashMap<Integer, Test> t) {
        Collection<Student> c = m.values();
        Iterator<Student> i = c.iterator();
        while (i.hasNext()) {
            Student dispStud = i.next();
            System.out.println("Roll No: " + dispStud.getRollNo() + "\nName: " + dispStud.getName() + "\n" +
                               dispStud.displayMks(dispStud.getMks(), t));
        }

    }

    public static int displayMenu() {
        System.out.println("------------------MENU------------------");
        System.out.println("1. Add new Student to database");
        System.out.println("2.Take test");
        System.out.println("3.Check Papers");
        System.out.println("4.Generate report card");
        System.out.println("enter your choice");
        return getInt();
    }

}

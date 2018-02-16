package com.project.tutorial.student;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Runner {
    public Runner() {
        super();
    }

    public static void main(String[] args) {
        Student s1 = new Student(1,"Abhinav","Suman","Sharma","02-08-1998","Male",25884866,"Pune");   
        Student s2 = new Student(2,"Bharti","Kumar","Shinde","16-03-1998","Female",25044866,"Pune");
        Student s3 = new Student(3,"Caroline","Frank","Golsalves","10-09-1998","Female",25885100,"Pune");
        Student s4 = new Student(4,"Kevin","Govind","Sharma","22-12-1999","Male",25753983,"Pune");
        Student s5 = new Student(5,"Linda","Mark","Sebestian","15-05-1998","Female",29845309,"Pune");
        Student s6 = new Student(6,"Shone","Oliver","Dennis","25-05-1998","Male",25216740,"Pune");
      
        
        HashMap<Integer,Student> m1=new HashMap<Integer,Student>(); 
        //Initialize hashmap
        
        m1.put(s4.getRoll_no(),s4);
        m1.put(s5.getRoll_no(),s5);
        m1.put(s3.getRoll_no(),s3);
        m1.put(s6.getRoll_no(),s6);
        m1.put(s2.getRoll_no(),s2);
        m1.put(s1.getRoll_no(),s1);
        
        String ch = "y";
        while("y".equals(ch) || "Y".equals(ch)){
            int caseNo=diplayMenu();
            switch(caseNo){
            case 1:      
                //Display all records
                showData(m1);
                break;
            case 2:
            //Search for Student
                System.out.println("\nEnter rollno to find");
                Scanner sc = new Scanner(System.in);
                System.out.println(m1.get(sc.nextInt()));
                break;
            case 3:
            //Delete Student
                System.out.println("\nEnter rollno to delete");
                Scanner sc_d = new Scanner(System.in);
                sc_d = new Scanner(System.in);
                m1.remove(sc_d.nextInt());
                showData(m1);
                break;
            case 4:
            //Insert Student
                Scanner sc_i=new Scanner(System.in);
                Student s_new = getNewStudentData(sc_i);
                m1.put(s_new.getRoll_no(),s_new);
                    showData(m1);
           //     else{
                    System.out.println("This rollnumber is already associated to another student");
                    System.out.println("Choose another roll number");
            //    }
                break;
            case 5:
            //Modify
                System.out.println("\nEnter rollno to modify");
                sc = new Scanner(System.in);
                if(m1.containsKey(sc.nextInt())){
                    System.out.println("Enter new data");
                    Student s_upd = getNewStudentData(sc);
                    m1.put(s_upd.getRoll_no(),s_upd);
                    showData(m1);
                }
                else
                    System.out.println("Roll number not present");
                break;
            default:
                System.out.println("Invalid choice")    ;
                break;
            }    
            System.out.println("Do you Want to continue?");
            Scanner choice = new Scanner(System.in);
            ch = choice.nextLine();
        }
    }

    private static void showData(HashMap<Integer, Student> m1) {
        Collection<Student> s = m1.values();
        Set<Integer> t = m1.keySet();
   //     System.out.println(t.getClass());
   //     System.out.println(s.getClass());
        System.out.println("Welcome.........................");
        
        for (Student x : s)
            System.out.println(x + "\n");
    }
    private static int diplayMenu(){
        System.out.println("----------------MENU-----------------");
        System.out.println("1. Display All Records");
        System.out.println("2. Search for a student");
        System.out.println("3. Delete a student");
        System.out.println("4. Add new student");
        System.out.println("5. Modify student details");
        System.out.println("Enter your choice");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    private static Student getNewStudentData(Scanner sc) {
        System.out.println("Enter Student Details:");
        Student s_new = new Student();

        System.out.println("Roll number:");
        sc = new Scanner(System.in);
        s_new.setRoll_no(sc.nextInt());

        System.out.println("First Name:");
        sc = new Scanner(System.in);
        s_new.setF_name(sc.nextLine());

        System.out.println("Middle Name:");
        sc = new Scanner(System.in);
        s_new.setM_name(sc.nextLine());

        System.out.println("Last Name:");
        sc = new Scanner(System.in);
        s_new.setL_name(sc.nextLine());

        System.out.println("Gender:");
        sc = new Scanner(System.in);
        s_new.setGender(sc.nextLine());

        System.out.println("Contact:");
        sc = new Scanner(System.in);
        s_new.setEmer_contact(sc.nextLong());

        System.out.println("Birthdate:\n");
        sc = new Scanner(System.in);
        s_new.dobOrganiser(sc.nextLine());

        System.out.println("Address:");
        sc = new Scanner(System.in);
        s_new.setAddress(sc.nextLine());
        return s_new;
    }
}

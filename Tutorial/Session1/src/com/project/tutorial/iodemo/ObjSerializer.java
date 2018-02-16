package com.project.tutorial.iodemo;

import com.project.tutorial.student.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjSerializer {
    public ObjSerializer() {
        super();
    }

    public static void main(String[] args) {
        Student s = new Student(001, "Aboli", "Kiran", "Khamitkar", "25-05-2014", "Male", 87656, "Pune");
        System.out.println("Before serialization" + s);
        try {
            FileOutputStream fileOut = new FileOutputStream("Stud.ser");
            ObjectOutputStream objout = new ObjectOutputStream(fileOut);
            objout.writeObject(s);
            objout.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Student stud = null;
        try {
            FileInputStream fIn = new FileInputStream("Stud.ser");
            ObjectInputStream objIn = new ObjectInputStream(fIn);
            stud = (Student) objIn.readObject();
            fIn.close();
            objIn.close();
            System.out.println("Object is \n" + stud);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

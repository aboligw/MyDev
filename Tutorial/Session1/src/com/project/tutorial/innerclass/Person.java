package com.project.tutorial.innerclass;


public class Person {
    String name;
    int age;
    char gender;

    public static interface MyInterface {
        void greet();
    }

    public Person() {
        super();
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public static void statMeth() {
        System.out.println("HEllo static method");
    }

    public void displayData() {
        System.out.println(name + " is a " + gender + " aged" + age);
    }

    class Doctor {
        public static final String occupation = "Doctor";
        int age = 35;

        void newAgePrint() {
            System.out.println("New inner age is " + age);
            System.out.println("New outer age is " + Person.this.age);
        }

        public void printData() {
            displayData();
            System.out.println("He is a " + occupation);
        }
    }

    static class Carpenter implements MyInterface {
        public static final String occupation = "Carpenter";

        public void printData() {
            statMeth();
            System.out.println("He is a " + occupation);
        }

        @Override
        public void greet() {
            System.out.println("Ststic class interface access");
        }
    }
}

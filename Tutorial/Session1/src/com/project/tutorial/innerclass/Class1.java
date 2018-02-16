package com.project.tutorial.innerclass;


public class Class1 {
    public Class1() {
        super();
    }

    public static void main(String[] args) {
        Class1 cl = new Class1();

        Person p = new Person("Kiran", 30, 'M');
        Person.MyInterface an = new Person.MyInterface() {
            public void myMethod() {
                System.out.println("Hello anonymous");
            }

            @Override
            public void greet() {
                System.out.println("In the interface using anaon");
            }
        };
        Person.Doctor d = p.new Doctor();
        Person.Carpenter c = new Person.Carpenter();
        /*  System.out.println(p.age);
        System.out.println("This -s tp------------------------------------");
        System.out.println(d.age);*/
        d.newAgePrint();
        d.printData();
        System.out.println("This -s tp------------------------------------");
        c.printData();

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Now finalize is executing!");
        super.finalize();
    }
}

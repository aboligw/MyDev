package com.project.tutorial.collectiondemo;

public class Employee implements Comparable{
    public Employee() {
        super();
    }
    
    public Employee(int p_id, String p_name, double p_salary, int p_token) {
        id=p_id;
        name=p_name;
        salary=p_salary;
        token=p_token;
    }

    private Integer id;
    private String name;
    private Double salary;
    private Integer token;

    public void setToken(Integer token) {
        this.token = token;
    }

    public Integer getToken() {
        return token;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }


    @Override
    public int compareTo(Object object) {
        System.out.println("In Compareto now");
        if(this.salary>((Employee)object).getSalary()) return 1;
        if(this.salary<((Employee)object).getSalary()) return -1;
        return 0;
    }

    @Override
    public int hashCode() {
     //   System.out.println("In hashcode now");
        return this.getId();
    }

    public boolean equals(Object p){
   //     System.out.println("In equals now");
        return(this.id == ((Employee)p).getId() && this.name.equals(((Employee)p).getName()) && this.salary == ((Employee)p).getSalary()) ;
    }
    @Override
    public String toString() {
        // TODO Implement this method
        return "Id: "+id+" Name: "+name+" Sal: "+ salary+ "token" + token;
    }
}

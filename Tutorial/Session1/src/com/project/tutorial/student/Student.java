package com.project.tutorial.student;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Student {
    // extends Class1{// implements Externalizable {
    private int roll_no;
    private String f_name;
    private transient String m_name;
    private String l_name;
    private Date dob;
    private String gender;
    private long emer_contact;
    private String address;

    public Student() {
        super();
    }

    public Student(int p_roll_no, String p_f_name, String p_m_name, String p_l_name, String p_dob, String p_gender,
                   long p_emer_contact, String p_address) {
        this.roll_no = p_roll_no;
        this.f_name = p_f_name;
        this.m_name = p_m_name;
        this.l_name = p_l_name;
        dobOrganiser(p_dob);
        this.gender = p_gender;
        this.emer_contact = p_emer_contact;
        this.address = p_address;
    }

    public String toString() {
        return "\nRoll No : " + roll_no + "\nNAME: " + f_name + " " + m_name + " " + l_name + "\nDOB: " + dob +
               "\nGender: " + gender + "\nContact: " + emer_contact + "\nAddress: " + address;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_name() {
        return m_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setEmer_contact(Long emer_contact) {
        this.emer_contact = emer_contact;
    }

    public Long getEmer_contact() {
        return emer_contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void dobOrganiser(String p_dob) {
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.dob = ft.parse(p_dob);
        } catch (ParseException e) {
            this.dob = new Date();
        }
    }

    //   @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(roll_no);
        out.writeObject(f_name);
        out.writeObject(m_name);
        out.writeObject(l_name);
        out.writeObject(new Date());
        out.writeObject("");
        out.writeLong(0L);
        out.writeObject("");

    }

    // @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.roll_no = in.readInt();
        this.f_name = (String) in.readObject();
        this.m_name = (String) in.readObject();
        this.l_name = (String) in.readObject();
        this.dob = (Date) in.readObject();
        this.gender = (String) in.readObject();
        this.emer_contact = in.readLong();
        this.address = (String) in.readObject();

    }
}

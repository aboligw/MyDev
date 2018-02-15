package com.project.vb.model;

import com.project.vb.common.BeanGetter;
import com.project.vb.presentation.TeacherBD;


public class Teacher {
    private String userId;
    private int id;
    private String name;
    TeacherBD bdObj = BeanGetter.getBean("teacherBD", TeacherBD.class);

    public Teacher() {
        super();
    }

    public Teacher(String userId) {
        this(userId, 0, null);
    }

    public Teacher(String userId, int id, String name) {
        this.userId = userId;
        this.id = id;
        this.name = name;
    }

    public boolean selectTeacher() {


        Teacher t = new Teacher();
        t = bdObj.select(this.getUserId(), 0, null);
        if (t != null) {
            this.setId(t.getId());
            this.setName(t.getName());
            return true;
        }
        return false;
    }


    public String toString() {
        return "Login ID: " + userId + " Id: " + id + " Name: " + name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

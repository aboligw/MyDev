package com.project.tutorial.jdbcdemo;


public class ProcParameter {
    private int index;
    private Object value;
    private int type;

    public ProcParameter() {
        super();
    }

    public ProcParameter(int index, Object value) {
        this(index, value, -1);
    }

    public ProcParameter(int index, Object value, int type) {
        this.index = index;
        this.value = value;
        this.type = type;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}

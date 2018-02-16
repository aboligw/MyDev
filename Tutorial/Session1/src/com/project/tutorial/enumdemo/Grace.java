package com.project.tutorial.enumdemo;


public enum Grace {
    ZERO(0, 15),
    ONE(1, 20),
    TWO(2, 25);
    private final int num;
    private final int days;

    Grace(int num, int days) {
        this.days = days;
        this.num = num;
    }

    public int num() {
        return num;
    }

    public int days() {
        return days;
    }


}

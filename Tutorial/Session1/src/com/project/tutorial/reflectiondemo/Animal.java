package com.project.tutorial.reflectiondemo;


public class Animal {
    public int height;
    public String color;
    public char gender;

    public String getSound() {
        return "ANIMAL";
    }

    public String toString() {
        return "height: " + height + "color: " + color + "gender: " + gender; // + getSound();
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public char getGender() {
        return gender;
    }

    public Animal() {
        super();
    }

    class Dog {
        public String getSound() {
            return "WOOF WOOF";
        }
    }
}

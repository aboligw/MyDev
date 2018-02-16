package com.project.tutorial.jdbcdemo.model;


public abstract class Model {
    private String actionMode = null;
    public static final String INSERT_MODE = "+";
    public static final String DELETE_MODE = "-";
    public static final String MODIFY_MODE = "*";

    public void setActionMode(String actionMode) {
        this.actionMode = actionMode;
    }

    public String getActionMode() {
        return actionMode;
    }
}

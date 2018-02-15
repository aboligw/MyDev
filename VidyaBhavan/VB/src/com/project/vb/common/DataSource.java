package com.project.vb.common;


public class DataSource {
    private String driverClass;
    private String uri;
    private String username;
    private String password;

    public DataSource() {
        super();
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

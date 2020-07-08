package com.beans;

import java.io.Serializable;

public class Users implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String userName;
    private String pwd;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPws(String pwd) {
        this.pwd = pwd;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

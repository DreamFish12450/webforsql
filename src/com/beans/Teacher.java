package com.beans;

import java.io.Serializable;

public class Teacher implements Serializable { /*java对象序列化，告诉JVM此类可被序列化，可被默认的序列化机制序列化，便于存储和传输*/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String Tno;  /*编号*/
    private String Tname;    /*姓名*/
    private String Tsex;     /*性别*/
    private int Tage;        /*年龄*/
    private String Ttitle;    /*职称*/
    private String Tphone;      /*电话号码*/

    public String getTno() {
        return Tno;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public String getTsex() {
        return Tsex;
    }

    public void setTsex(String tsex) {
        Tsex = tsex;
    }

    public int getTage() {
        return Tage;
    }

    public void setTage(int tage) {
        Tage = tage;
    }

    public String getTtitle() {
        return Ttitle;
    }

    public void setTtitle(String ttitle) {
        Ttitle = ttitle;
    }

    public String getTphone() {
        return Tphone;
    }

    public void setTphone(String tphone) {
        Tphone = tphone;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

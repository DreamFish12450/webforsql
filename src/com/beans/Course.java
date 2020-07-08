package com.beans;

import java.io.Serializable;

public class Course implements Serializable { /*java对象序列化，告诉JVM此类可被序列化，可被默认的序列化机制序列化，便于存储和传输*/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String Cno;  /*编号*/
    private String openSemester;    /*姓名*/
    private String Cname;     /*性别*/
    private int Chours;        /*年龄*/
    private String natureofAssessment;    /*职称*/
    private int Credit;      /*电话号码*/

    public String getCno() {
        return Cno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public String getOpenSemester() {
        return openSemester;
    }

    public void setOpenSemester(String openSemester) {
        this.openSemester = openSemester;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public int getChours() {
        return Chours;
    }

    public void setChours(int chours) {
        Chours = chours;
    }

    public String getNatureofAssessment() {
        return natureofAssessment;
    }

    public void setNatureofAssessment(String natureofAssessment) {
        this.natureofAssessment = natureofAssessment;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int credit) {
        Credit = credit;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

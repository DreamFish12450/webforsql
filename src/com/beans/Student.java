package com.beans;

import java.io.Serializable;

public class Student implements Serializable { /*java对象序列化，告诉JVM此类可被序列化，可被默认的序列化机制序列化，便于存储和传输*/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String Sno;  /*编号*/
    private String Sname;    /*姓名*/
    private String Ssex;     /*性别*/
    private int Sage;        /*年龄*/
    private String sourceOfStudents;
    private String classNumber;

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public int getSage() {
        return Sage;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public String getSourceOfStudents() {
        return sourceOfStudents;
    }

    public void setSourceOfStudents(String sourceOfStudents) {
        this.sourceOfStudents = sourceOfStudents;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String cno) {
        classNumber = cno;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

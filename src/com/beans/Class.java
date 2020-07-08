package com.beans;

import java.io.Serializable;

public class Class implements Serializable { /*java对象序列化，告诉JVM此类可被序列化，可被默认的序列化机制序列化，便于存储和传输*/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String Mno;
    private String classNumber;
    private int classSize;
    private String isExperimental;
    private String className;

    public String getMno() {
        return Mno;
    }

    public void setMno(String mno) {
        Mno = mno;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    public String getIsExperimental() {
        return isExperimental;
    }

    public void setIsExperimental(String isExperimental) {
        this.isExperimental = isExperimental;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

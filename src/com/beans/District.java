package com.beans;

import java.io.Serializable;

public class District implements Serializable { /*java对象序列化，告诉JVM此类可被序列化，可被默认的序列化机制序列化，便于存储和传输*/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String district;
    private int stucount;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getStucount() {
        return stucount;
    }

    public void setStucount(int stucount) {
        this.stucount = stucount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

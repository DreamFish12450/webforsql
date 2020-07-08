package com.beans;

import java.io.Serializable;

public class Credit implements Serializable { /*java对象序列化，告诉JVM此类可被序列化，可被默认的序列化机制序列化，便于存储和传输*/

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String sno;
    private int totalcredits;

    public int getTotalcredits() {
        return totalcredits;
    }

    public void setTotalcredits(int totalcredits) {
        this.totalcredits = totalcredits;
    }

    public String getSno() {
        return this.sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}

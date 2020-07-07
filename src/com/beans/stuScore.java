package com.beans;

public class stuScore {
     private String sno;
    private String sname;
    private String cname;
    public String getSno() {
        return sno;
    }
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }



    public String getOpen_semester() {
        return open_semester;
    }

    public void setOpen_semester(String open_semester) {
        this.open_semester = open_semester;
    }

    public int  getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String cno;
    private String open_semester;
    private int score;
}

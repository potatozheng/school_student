package com.softeem.dto;

import java.util.Date;

/**
 * 班级
 */
public class Tbclass {
    private int cid;//班级号
    private String cdepart;//院系
    private int cnum;//班级人数
    private Date cyear;//入学年份
    private String instructor;//辅导员

    public Tbclass() {
    }

    public Tbclass(int cid, String cdepart, int cnum, Date cyear, String instructor) {
        this.cid = cid;
        this.cdepart = cdepart;
        this.cnum = cnum;
        this.cyear = cyear;
        this.instructor = instructor;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCdepart() {
        return cdepart;
    }

    public void setCdepart(String cdepart) {
        this.cdepart = cdepart;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public Date getCyear() {
        return cyear;
    }

    public void setCyear(Date cyear) {
        this.cyear = cyear;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Tbclass{" +
                "cid=" + cid +
                ", cdepart='" + cdepart + '\'' +
                ", cnum=" + cnum +
                ", cyear=" + cyear +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}

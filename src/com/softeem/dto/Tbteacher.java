package com.softeem.dto;

/**
 * 教师基本信息
 */
public class Tbteacher {
    private int tid;//教工编号
    private String password;//密码
    private String tname;//姓名
    private String tdepart;//院系
    private String major;//专业方向
    private String rank;//职称
    private int state;//标识

    public Tbteacher() {
    }

    public Tbteacher(int tid, String password, String tname, String tdepart, String major, String rank, int state) {
        this.tid = tid;
        this.password = password;
        this.tname = tname;
        this.tdepart = tdepart;
        this.major = major;
        this.rank = rank;
        this.state = state;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTdepart() {
        return tdepart;
    }

    public void setTdepart(String tdepart) {
        this.tdepart = tdepart;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Tbteachar{" +
                "tid=" + tid +
                ", password='" + password + '\'' +
                ", tname='" + tname + '\'' +
                ", tdepart='" + tdepart + '\'' +
                ", major='" + major + '\'' +
                ", rank='" + rank + '\'' +
                ", state=" + state +
                '}';
    }
}

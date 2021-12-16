package com.softeem.dto;

import java.util.Date;

/**
 * 课程表
 */
public class Tbschedule {
    private int currid;//排课id
    private int cno;//课程号
    private int cid;//班级id
    private int tid;//授课教师编号
    private Date lessonsTime;//授课时间
    private String rid;//授课地点

    public Tbschedule() {
    }

    public Tbschedule(int currid, int cno, int cid, int tid, Date lessonsTime, String rid) {
        this.currid = currid;
        this.cno = cno;
        this.cid = cid;
        this.tid = tid;
        this.lessonsTime = lessonsTime;
        this.rid = rid;
    }

    public int getCurrid() {
        return currid;
    }

    public void setCurrid(int currid) {
        this.currid = currid;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Date getLessonsTime() {
        return lessonsTime;
    }

    public void setLessonsTime(Date lessonsTime) {
        this.lessonsTime = lessonsTime;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Tbschedule{" +
                "currid=" + currid +
                ", cno=" + cno +
                ", cid=" + cid +
                ", tid=" + tid +
                ", lessonsTime=" + lessonsTime +
                ", rid='" + rid + '\'' +
                '}';
    }
}

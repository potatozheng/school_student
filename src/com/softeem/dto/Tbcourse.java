package com.softeem.dto;

/**
 * 课程基本信息
 */
public class Tbcourse {
    private int cno;//课程号
    private String course;//课程名
    private String semester;//开课学期
    private int period;//学时
    private int score;//学分

    public Tbcourse() {
    }

    public Tbcourse(int cno, String course, String semester, int period, int score) {
        this.cno = cno;
        this.course = course;
        this.semester = semester;
        this.period = period;
        this.score = score;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Tbcourse{" +
                "cno=" + cno +
                ", course='" + course + '\'' +
                ", semester='" + semester + '\'' +
                ", period=" + period +
                ", score=" + score +
                '}';
    }
}

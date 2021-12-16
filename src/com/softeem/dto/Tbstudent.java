package com.softeem.dto;

import java.util.Date;

/**
 * 学生表
 */
public class Tbstudent {
    private int sid;//学号
    private String password;//密码
    private String sname;//姓名
    private String ssex;//性别
    private Date birthday;//生日
    private String sdepart;//院系
    private String clbum;//班级
    private String address;//地址
    private String phone;//联系电话
    private String remark;//备注
    private int state;//标识

    public Tbstudent() {
    }

    public Tbstudent(int sid, String password, String sname, String ssex, Date birthday, String sdepart, String clbum, String address, String phone, String remark, int state) {
        this.sid = sid;
        this.password = password;
        this.sname = sname;
        this.ssex = ssex;
        this.birthday = birthday;
        this.sdepart = sdepart;
        this.clbum = clbum;
        this.address = address;
        this.phone = phone;
        this.remark = remark;
        this.state = state;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSdepart() {
        return sdepart;
    }

    public void setSdepart(String sdepart) {
        this.sdepart = sdepart;
    }

    public String getClbum() {
        return clbum;
    }

    public void setClbum(String clbum) {
        this.clbum = clbum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Tbstudent{" +
                "sid=" + sid +
                ", password='" + password + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", birthday=" + birthday +
                ", sdepart='" + sdepart + '\'' +
                ", clbum='" + clbum + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                '}';
    }
}

package com.softeem.dto;

/**
 * 教室
 */
public class Tbroom {
    private String rid;//教室编号
    private int capacity;//容量
    private int multimedia;//是否是多媒体教室(1:是 0:不是)
    private int state;//教室状态(1:使用 0:闲置)

    public Tbroom() {
    }

    public Tbroom(String rid, int capacity, int multimedia, int state) {
        this.rid = rid;
        this.capacity = capacity;
        this.multimedia = multimedia;
        this.state = state;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(int multimedia) {
        this.multimedia = multimedia;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Tbroom{" +
                "rid='" + rid + '\'' +
                ", capacity=" + capacity +
                ", multimedia=" + multimedia +
                ", state=" + state +
                '}';
    }
}

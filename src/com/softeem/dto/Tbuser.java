package com.softeem.dto;

/**
 * 用户类
 */
public class Tbuser {
    private int uid;//用户id
    private String username;//用户名
    private String password;//密码
    private int type;//类型

    public Tbuser() {
    }

    public Tbuser(int uid, String username, String password, int type) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tbuser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}

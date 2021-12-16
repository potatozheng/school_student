package com.softeem.dao;

import com.softeem.dto.Tbstudent;

import java.util.List;

/**
 * 学生类的接口
 */
public interface TbstudentDao {
    //学生登录
    public Tbstudent login(String name);

    //学生信息添加
    public boolean addStudent(Tbstudent tbstudent);

    //学生密码修改
    public boolean updatePwd(int sid,String pwd);

    //学生信息修改
    public boolean updateStudent(Tbstudent tbstudent,int sid);

    //学生信息删除
    public boolean deletcStudent(int sid);

    //根据学生学号查询
    public Tbstudent findBySid(int sid);

    //根据学生名字查询
    public Tbstudent findBySname(String sname);

    //根据学生院系查询
    public List<Tbstudent> findByTdepart(String tdepart);

    //根据学生的班级查询
    public List<Tbstudent> findByClbum(String clbum);

}

package com.softeem.dao;

import com.softeem.dto.Tbteacher;
import java.sql.SQLException;
import java.util.List;

/**
 * 教师类的接口
 */
public interface TbteacherDao {
    //教师登录
    public Tbteacher login(String name);
    //教师信息添加
    public boolean addTeacher(Tbteacher tbteacher) throws SQLException;
    //教师密码修改
    public boolean updatePwd(int tid,String pwd) throws SQLException;
    //教师信息修改
    public boolean updateTeacher(Tbteacher tbteacher,int tid) throws SQLException;
    //教师信息删除
    public boolean deletcTeacher(int tid);
    //根据教师编号查询
    public Tbteacher findByTid(int tid);
    //根据教师名字查询
    public Tbteacher findByTname(String tname);
    //根据教师院系查询
    public List<Tbteacher> findByTdepart(String tdepart);
    //根据教师的专业方法查询
    public List<Tbteacher> findByMajor(String major);
    //根据教师的职称查询
    public List<Tbteacher> findByRank(String rank);
}

package com.softeem.dao;

import com.softeem.dto.Tbcourse;

import java.util.List;

/**
 * 课程类的接口
 */
public interface TbcourseDao {
    //添加课程
    public boolean addTbcourse(Tbcourse tbcourse);
    //删除课程信息
    public boolean deleteByCno(int cno);
    //修改课程信息
    public boolean updateByClass(Tbcourse tbcourse,int cno);
    //根据课程号查询课程信息
    public Tbcourse findByCno(int cno);
    //根据课程名修改课程信息
    public List<Tbcourse> findByCourse(String course);
}

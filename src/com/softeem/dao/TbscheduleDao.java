package com.softeem.dao;

import com.softeem.dto.Tbschedule;

/**
 * 课程表信息接口
 */
public interface TbscheduleDao {
    //添加课程表信息
    public boolean addTbschedule(Tbschedule tbschedule);

    //修改课程表信息
    public boolean updateByTbschedule(Tbschedule tbschedule,int currid);

    //删除课程表信息
    public boolean deleteByCurrid(int currid);

    //根据课程号查询课程信息
    public Tbschedule findByCno(int Cno);

}

package com.softeem.dao;

import com.softeem.dto.Tbclass;

import java.util.List;

/**
 * 班级类的接口
 */
public interface TbclassDao {
    //添加班级
    public boolean addTbclass(Tbclass tbclass);
    //删除班级
    public boolean deleteByCid(int cid);
    //修改班级信息
    public boolean updateByClass(Tbclass tbclass,int cid);
    //根据班级号查询班级信息
    public Tbclass findByCid(int cid);
    //根据院系查询班级信息
    public List<Tbclass> findByCdepart(String cdepart);
    //根据辅导员查询班级信息
    public List<Tbclass> findByInstructor(String instructor);
}

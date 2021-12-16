package com.softeem.dao;


import com.softeem.dto.Tbroom;

/**
 * 教室类的接口
 */
public interface TbroomDao {
    //添加教室信息
    public boolean addTbroom(Tbroom tbroom);

    //修改教室信息
    public boolean updateByTbroom(Tbroom tbroom,int rid);

    //删除教室信息
    public boolean deleteByRid(String rid);

    //根据教室编号查询教室信息
    public Tbroom findByRid(String rid);

}

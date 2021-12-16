package com.softeem.dao.impl;

import com.softeem.dao.TbroomDao;
import com.softeem.dto.Tbroom;
import com.softeem.utils.DBUtils;

/**
 * 教室信息的sql处理
 */
public class TbroomDaoImpl implements TbroomDao {
    @Override
    public boolean addTbroom(Tbroom tbroom) {
        String sql = "insert into tbroom(rid,capacity,multimedia,state) value(?,?,?,?)";
        return DBUtils.exeUpdate(sql,
                tbroom.getRid(),
                tbroom.getCapacity(),
                tbroom.getMultimedia(),
                tbroom.getState());
    }

    @Override
    public boolean updateByTbroom(Tbroom tbroom,int rid) {
        String sql = "update tbroom set capacity=?,multimedia=?,state=? where rid = ?";
        return DBUtils.exeUpdate(sql,
                tbroom.getCapacity(),
                tbroom.getMultimedia(),
                tbroom.getState(),
                rid);
    }

    @Override
    public boolean deleteByRid(String rid) {
        String sql = "delete from tbroom where rid = ?";
        return DBUtils.exeUpdate(sql,rid);
    }

    @Override
    public Tbroom findByRid(String rid) {
        String sql = "select capacity,multimedia,state from tbroom where rid = ?";
        return DBUtils.queryOne(Tbroom.class,sql,rid);
    }
}

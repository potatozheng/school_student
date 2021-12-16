package com.softeem.dao.impl;

import com.softeem.dao.TbscheduleDao;
import com.softeem.dto.Tbschedule;
import com.softeem.dto.Tbteacher;
import com.softeem.utils.DBUtils;

/**
 * 课程表信息的sql处理
 */
public class TbscheduleDaoImpl implements TbscheduleDao {
    @Override
    public boolean addTbschedule(Tbschedule tbschedule) {
        String sql = "insert into tbschedule(currid, cno, cid, tid, lessonsTime, rid) value(?,?,?,?,?,?)";
        return DBUtils.exeUpdate( sql,
                tbschedule.getCurrid(),
                tbschedule.getCno(),
                tbschedule.getCid(),
                tbschedule.getTid(),
                tbschedule.getLessonsTime(),
                tbschedule.getRid());
    }

    @Override
    public boolean updateByTbschedule(Tbschedule tbschedule,int currid) {
        String sql = "update tbschedule set cno=?, cid=?, tid=?, lessonsTime=?, rid=? where currid = ?";
        return DBUtils.exeUpdate(sql,
                tbschedule.getCno(),
                tbschedule.getCid(),
                tbschedule.getTid(),
                tbschedule.getLessonsTime(),
                tbschedule.getRid(),
                currid);
    }

    @Override
    public boolean deleteByCurrid(int currid) {
        String sql = "delete from tbschedule where currid = ?";
        return DBUtils.exeUpdate(sql,currid);
    }

    @Override
    public Tbschedule findByCno(int cno) {
        String sql = "select currid,cid,tid,lessonsTime,rid from tbschedule where cno = ?";
        return DBUtils.queryOne(Tbschedule.class,sql,cno);
    }
}

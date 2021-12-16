package com.softeem.dao.impl;

import com.softeem.dao.TbteacherDao;
import com.softeem.dto.Tbteacher;
import com.softeem.utils.DBUtils;
import java.sql.SQLException;
import java.util.List;

/**
 * 老师信息的sql处理
 */
public class TbteacherDaoImpl implements TbteacherDao {
    @Override
    public Tbteacher login(String tname) {
        String sql = "select * from tbteacher where tname = ?";
        return DBUtils.queryOne(Tbteacher.class,sql,tname);
    }

    @Override
    public boolean addTeacher(Tbteacher tbteacher) throws SQLException {
        String sql = "insert into tbteacher(tid,password,tname,tdepart,major,rank,state) value(?,?,?,?,?,?)";
        return DBUtils.exeUpdate( sql,
                                  tbteacher.getTid(),
                                  tbteacher.getPassword(),
                                  tbteacher.getTname(),
                                  tbteacher.getTdepart(),
                                  tbteacher.getMajor(),
                                  tbteacher.getRank(),
                                  tbteacher.getState());
    }

    @Override
    public boolean updatePwd(int tid, String pwd){
        String sql = "update tbteacher set password = ? where tid = ?";
        return DBUtils.exeUpdate(sql,pwd,tid);
    }

    @Override
    public boolean updateTeacher(Tbteacher tbteacher,int tid){
        String sql = "update tbteacher set tname=?,tdepart=?,major=?,rank=?,state=? where tid = ?";
        return DBUtils.exeUpdate(sql,tbteacher.getTname(),
                tbteacher.getTdepart(),
                tbteacher.getMajor(),
                tbteacher.getRank(),
                tbteacher.getState(),
                tid);
    }

    @Override
    public boolean deletcTeacher(int tid) {
        String sql = "delete from tbteacher where tid = ?";
        return DBUtils.exeUpdate(sql,tid);
    }

    @Override
    public Tbteacher findByTid(int tid) {
        String sql = "select tname,tdepart,major,rank,state from tbteacher where tid = ?";
        return DBUtils.queryOne(Tbteacher.class,sql,tid);
    }

    @Override
    public Tbteacher findByTname(String tname) {
        String sql = "select tid,tdepart,major,rank,state from tbteacher where tname = ?";
        return DBUtils.queryOne(Tbteacher.class,sql,tname);
    }

    @Override
    public List<Tbteacher> findByTdepart(String tdepart) {
        return null;
    }

    @Override
    public List<Tbteacher> findByMajor(String major) {
        return null;
    }

    @Override
    public List<Tbteacher> findByRank(String rank) {
        return null;
    }
}

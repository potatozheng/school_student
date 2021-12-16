package com.softeem.dao.impl;

import com.softeem.dao.TbclassDao;
import com.softeem.dto.Tbclass;
import com.softeem.utils.DBUtils;

import java.util.List;

/**
 * 班级信息的sql处理
 */
public class TbclassDaoImpl implements TbclassDao {
    @Override
    public boolean addTbclass(Tbclass tbclass) {
        String sql = "insert into tbclass(cid,cdepart,cnum,cyear,instructor) value(?,?,?,?,?)";
        return DBUtils.exeUpdate( sql,
                tbclass.getCid(),
                tbclass.getCdepart(),
                tbclass.getCnum(),
                tbclass.getCyear(),
                tbclass.getInstructor()
                );
    }

    @Override
    public boolean deleteByCid(int cid) {
        String sql = "delete from tbclass where cid = ?";
        return DBUtils.exeUpdate(sql,cid);
    }

    @Override
    public boolean updateByClass(Tbclass tbclass,int cid) {
        String sql = "update tbclass set cdepart,cnum,cyear,instructor where cid = ?";
        return DBUtils.exeUpdate(sql,
                tbclass.getCdepart(),
                tbclass.getCnum(),
                tbclass.getCyear(),
                tbclass.getInstructor(),
                cid);
    }

    @Override
    public Tbclass findByCid(int cid) {
        String sql = "select cdepart,cnum,cyear,instructor from tbclass where cid = ?";
        return DBUtils.queryOne(Tbclass.class,sql,cid);
    }

    @Override
    public List<Tbclass> findByCdepart(String cdepart) {
        String sql = "select cid,cdepart,cnum,cyear,instructor from tbclass where cdepart = ?";
        return DBUtils.queryList(Tbclass.class,sql,cdepart);
    }

    @Override
    public List<Tbclass> findByInstructor(String instructor) {
        String sql = "select cid,cdepart,cnum,cyear from tbclass where instructor = ?";
        return DBUtils.queryList(Tbclass.class,sql,instructor);
    }
}

package com.softeem.dao.impl;

import com.softeem.dao.TbstudentDao;
import com.softeem.dto.Tbstudent;
import com.softeem.utils.DBUtils;

import java.util.List;
import java.util.Objects;

/**
 * 学生信息的sql处理
 */
public class TbstudentDaoImpl implements TbstudentDao {

    @Override
    public Tbstudent login(String sname) {
        String sql = "select * from tbstudent where sname = ?";
        return DBUtils.queryOne(Tbstudent.class,sql,sname);
    }

    @Override
    public boolean addStudent(Tbstudent tbstudent) {
        String sql = "insert into tbstudent(sid,password,sname,ssex,birthday,sdepart,clbum,address,phone,remark,state) value(?,?,?,?,?,?,?,?,?,?,?)";
        return DBUtils.exeUpdate( sql,
                tbstudent.getSid(),
                tbstudent.getPassword(),
                tbstudent.getSname(),
                tbstudent.getSsex(),
                tbstudent.getBirthday(),
                tbstudent.getSdepart(),
                tbstudent.getClbum(),
                tbstudent.getAddress(),
                tbstudent.getPhone(),
                tbstudent.getRemark(),
                tbstudent.getState());
    }

    @Override
    public boolean updatePwd(int sid, String pwd) {
        String sql = "update tbstudent set password = ? where sid = ?";
        return DBUtils.exeUpdate(sql,pwd,sid);
    }

    @Override
    public boolean updateStudent(Tbstudent tbstudent,int sid) {
        String sql = "update tbstudent set sname=?,ssex=?,birthday=?,sdepart=?,clbum=?,address=?,phone=?,remark=?,state=? where sid = ?";
        return DBUtils.exeUpdate(sql,
                tbstudent.getSname(),
                tbstudent.getSsex(),
                tbstudent.getBirthday(),
                tbstudent.getSdepart(),
                tbstudent.getClbum(),
                tbstudent.getAddress(),
                tbstudent.getPhone(),
                tbstudent.getRemark(),
                tbstudent.getState(),
                sid
                );
    }

    @Override
    public boolean deletcStudent(int sid) {
        String sql = "delete from tbstudent where sid = ?";
        return DBUtils.exeUpdate(sql,sid);
    }

    @Override
    public Tbstudent findBySid(int sid) {
        String sql = "select sname,ssex,birthday,sdepart,clbum,address,phone,remark,state from tbstudent where sid = ?";
        return DBUtils.queryOne(Tbstudent.class,sql,sid);
    }

    @Override
    public Tbstudent findBySname(String sname) {
        String sql = "select sid,ssex,birthday,sdepart,clbum,address,phone,remark,state from tbstudent where sname = ?";
        return DBUtils.queryOne(Tbstudent.class,sql,sname);
    }

    @Override
    public List<Tbstudent> findByTdepart(String tdepart) {
        return null;
    }

    @Override
    public List<Tbstudent> findByClbum(String clbum) {
        return null;
    }
}

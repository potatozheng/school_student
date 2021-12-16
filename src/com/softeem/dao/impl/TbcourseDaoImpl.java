package com.softeem.dao.impl;

import com.softeem.dao.TbcourseDao;
import com.softeem.dto.Tbcourse;
import com.softeem.utils.DBUtils;

import java.util.List;

/**
 * 课程信息的sql处理
 */
public class TbcourseDaoImpl implements TbcourseDao {
    @Override
    public boolean addTbcourse(Tbcourse tbcourse) {
        String sql = "insert into tbcourse(cno,course,semester,period,score) value(?,?,?,?,?)";
        return DBUtils.exeUpdate( sql,
                tbcourse.getCno(),
                tbcourse.getCourse(),
                tbcourse.getSemester(),
                tbcourse.getPeriod(),
                tbcourse.getScore());
    }

    @Override
    public boolean deleteByCno(int cno) {
        String sql = "delete from tbcourse where cno = ?";
        return DBUtils.exeUpdate(sql,cno);
    }

    @Override
    public boolean updateByClass(Tbcourse tbcourse,int cno) {
        String sql = "update tbcourse set course=?, semester=?, period=?, score=? where cno=?";
        return DBUtils.exeUpdate(sql,tbcourse.getCourse(),
                tbcourse.getSemester(),
                tbcourse.getPeriod(),
                tbcourse.getScore(),
                cno);
    }

    @Override
    public Tbcourse findByCno(int cno) {
        String sql = "select course, semester, period, score from tbcourse where cno = ?";
        return DBUtils.queryOne(Tbcourse.class,sql,cno);
    }

    @Override
    public List<Tbcourse> findByCourse(String course) {
        return null;
    }
}

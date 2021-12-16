package com.softeem.dao.impl;

import com.softeem.dao.TbuserDao;
import com.softeem.dto.Tbstudent;
import com.softeem.dto.Tbteacher;
import com.softeem.dto.Tbuser;
import com.softeem.utils.DBUtils;

/**
 * 用户的实现
 */
public class TbuserDaoImpl implements TbuserDao {
    /**
     * 用户的登录实现,进行了角色处理
     * @param
     * @return
     */
    @Override
    public Tbuser login(int uid) {
           String sql = "select * from tbuser where uid = ?";
           Tbuser tbuser = DBUtils.queryOne(Tbuser.class,sql,uid);
        return tbuser;
    }
}

package com.softeem.dao;

import com.softeem.dto.Tbuser;

/**
 * 用户登录的接口
 */
public interface TbuserDao {
    //用户登录
    public Tbuser login(int uid);
}

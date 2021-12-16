package com.softeem.service;

import com.softeem.dao.impl.TbstudentDaoImpl;
import com.softeem.dao.impl.TbteacherDaoImpl;
import com.softeem.dao.impl.TbuserDaoImpl;
import com.softeem.dto.ServiceModel;
import com.softeem.dto.Tbuser;

/**
 * 管理员的逻辑处理
 */
public class TbuserService {
    TbuserDaoImpl tud = new TbuserDaoImpl();
    TbstudentDaoImpl tsd = new TbstudentDaoImpl();
    TbteacherDaoImpl ttd = new TbteacherDaoImpl();
    //处理管理员登录
    //1、先根据传入的对象获取到对象的id
    //2、根据id来确认数据库中是否有这个对象
    //3、有对象再比对数据库中的对象的密码和前端传入的对象的密码是否相同
    public ServiceModel login(Tbuser user) {
        int sta = user.getType();
        if (sta == 0){
            Tbuser tbuser = tud.login(user.getUid());

        }else if(sta == 1){

        }else if(sta == 2){

        }
        return null;
    }
}

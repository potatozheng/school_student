package com.softeem.dao;

import java.util.List;

/**
 * 通用的数据访问对象的CRUD接口
 * @param <T>
 */
public interface BaseDAO<T> {
    //新增对象
    boolean insert(T t);
    //删除信息
    boolean delete(T t);
    //更新信息
    boolean update(T t);
    //找到一个对象
    T findOne(T t);
    //找到所有对象并进行分页操作
    List<T> findAll(int pageSize, int currentPage);
}

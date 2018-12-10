package com.tpp.demo.service;

import com.tpp.demo.bean.RoncooUserLog;

import java.util.Optional;

public interface RoncooUserLogCache {
    /**
     * 查询
     *
     * @param id
     * @return
     */
    Optional<RoncooUserLog> selectById(Integer id);
    /**
     * 更新
     *
     * @param roncooUserLog
     * @return
     */
    RoncooUserLog updateById(RoncooUserLog roncooUserLog);
    /**
     * 删除
     *
     * @param id
     * @return
     */
    String deleteById(Integer id);
}

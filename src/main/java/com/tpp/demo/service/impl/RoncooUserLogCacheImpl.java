package com.tpp.demo.service.impl;

import com.tpp.demo.bean.RoncooUserLog;
import com.tpp.demo.dao.RoncooUserLogDao;
import com.tpp.demo.service.RoncooUserLogCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * @author 童平平
 * @Title: springboot_1
 * @Package com.tpp.demo.service.impl
 * @Description:
 *
 * 注解说明：
 @CacheConfig：缓存配置
 @Cacheable：应用到读取数据的方法上，即可缓存的方法，如查找方法：先从缓存中读取，如果没有再调
 用方法获取数据，然后把数据添加到缓存中。适用于查找
 @CachePut：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的
 是，它每次都会触发真实方法的调用。适用于更新和插入
 @CacheEvict：主要针对方法配置，能够根据一定的条件对缓存进行清空。适用于删除

  * @date 2018-12-05 23:35
 */
@CacheConfig(cacheNames = "roncooCache")
@Repository
public class RoncooUserLogCacheImpl implements RoncooUserLogCache {

    @Autowired
    private
    RoncooUserLogDao roncooUserLogDao;

    @Cacheable(key = "#p0")
    @Override
    public Optional<RoncooUserLog> selectById(Integer id) {
        System.out.println("查询功能，缓存找不到，直接读库, id=" + id);
        Optional<RoncooUserLog> dao = roncooUserLogDao.findById(id);
        return dao;
    }

    @CachePut(key = "#p0")
    @Override
    public RoncooUserLog updateById(RoncooUserLog roncooUserLog) {
        System.out.println("更新功能，更新缓存，直接写库, id=" +
                roncooUserLog);
        return roncooUserLogDao.save(roncooUserLog);
    }

    @CacheEvict(key = "#p0")
    @Override
    public String deleteById(Integer id) {
        System.out.println("删除功能，删除缓存，直接写库, id=" + id);
        return "清空缓存成功";
    }
}

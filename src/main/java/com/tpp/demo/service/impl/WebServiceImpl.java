package com.tpp.demo.service.impl;

import com.tpp.demo.service.WebService;
import org.springframework.stereotype.Service;

/**
 * @author 童平平
 * @Title: springboot_1
 * @Package com.tpp.demo.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2018-12-04 22:26
 */
@Service
public class WebServiceImpl implements WebService {
    @Override
    public String test() {
throw new RuntimeException("测试数据局");
    }
}

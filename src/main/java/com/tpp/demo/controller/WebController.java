/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.tpp.demo.controller;

import com.tpp.demo.service.WebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * spring-boot-demo-9-3
 *
 * @author wujing
 */
@Controller
@RequestMapping(value = "/web")
public class WebController {
    @Resource
    WebService webService;
    @RequestMapping(value = "/error")
    public String error() {
       return webService.test();
    }

}

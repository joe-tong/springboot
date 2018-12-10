/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.tpp.demo.controller;


import com.tpp.demo.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

/**
 * spring-boot-demo-2-1
 * 
 * @author wujing
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {
	@Value(value = "${roncoo.secret}")
	private String secret;

	@Value(value = "${roncoo.number}")
	private int id;

	@Value(value = "${roncoo.desc}")
	private String desc;

	@RequestMapping
	public String index() {
		return "hello world";
	}

	@RequestMapping(value = "/get")
	public HashMap<String, Object> get(@RequestParam String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		map.put("age", name);
		return map;
	}

	/** @PathVariable 获得请求url中的动态参数
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/get/{id}/{name}")
	public User getUser(@PathVariable int id, @PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
	@RequestMapping(value = "/getValue")
	public HashMap<String, Object> getValue() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("secret",secret );
		map.put("id;", id);
		map.put("desc", desc);
		return map;
	}
}

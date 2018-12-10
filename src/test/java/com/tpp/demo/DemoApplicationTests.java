package com.tpp.demo;

import com.tpp.demo.bean.RoncooUserLog;
import com.tpp.demo.dao.RoncooUserLogDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Resource
	RoncooUserLogDao roncooUserLogDao;

	@Test
	public void insert() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setUserName("t");
		entity.setUserIp("192.168.1.19");
//		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

//	@Test
//	public void delete() {
//		roncooUserLogDao.delete(1);
//	}

	@Test
	public void update() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

//	@Test
//	public void select() {
//		RoncooUserLog result = roncooUserLogDao.findOne(1);
//		System.out.println(result);
//	}

	@Test
	public void select2() {
		List<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境");
		System.out.println(result);
	}

	@Test
	public void select3() {
		List<RoncooUserLog> result = roncooUserLogDao.findByUserNameAndUserIp("无境", "192.168.0.1");
		System.out.println(result);
	}

	// 分页
	@Test
	public void queryForPage() {
		Pageable pageable = new PageRequest(0, 20, new Sort(new Sort.Order(Sort.Direction.DESC, "id")));
		Page<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境", pageable);
		System.out.println(result.getContent());
	}
	@Test
	public void contextLoads() {
	}

}

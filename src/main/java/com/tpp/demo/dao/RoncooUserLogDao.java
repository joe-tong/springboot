/**
 * 2015-2016 龙果学院 (www.roncoo.com)
 */
package com.tpp.demo.dao;


import com.tpp.demo.bean.RoncooUserLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author wujing
 */
public interface RoncooUserLogDao extends JpaRepository<RoncooUserLog, Integer> {

	/**
	 * @param
	 * @return
	 */
	@Query(value = "select u from RoncooUserLog u where u.userName=?1")
	List<RoncooUserLog> findByUserName(String userName);

	/**
	 * @param string
	 * @param string2
	 * @return
	 */
	List<RoncooUserLog> findByUserNameAndUserIp(String string, String string2);

	/**
	 * @param
	 * @param pageable
	 * @return
	 */
	Page<RoncooUserLog> findByUserName(String userName, Pageable pageable);

}

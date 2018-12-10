package com.tpp.demo.util.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author wujing
 */
@WebServlet(urlPatterns = { "/druid/*" }, initParams = { @WebInitParam(name = "loginUsername", value = "roncoo"), @WebInitParam(name = "loginPassword", value = "roncoo") })
public class DruidStatViewServlet extends StatViewServlet {

	private static final long serialVersionUID = 1L;

}


package com.tpp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Administrator
 * @ServletComponentScan filter, listener, servlet注册的时候使用
 */
@SpringBootApplication
@ServletComponentScan
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

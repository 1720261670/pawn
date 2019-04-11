package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//读取配置文件
@Configuration
@ImportResource(locations = "classpath:applicationContext-monitor.xml")
public class DruidStatInterceptor {
}

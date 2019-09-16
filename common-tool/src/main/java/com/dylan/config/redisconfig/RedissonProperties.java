package com.dylan.config.redisconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:26
 */
@Data
@ConfigurationProperties(prefix = "spring.redission",ignoreInvalidFields = false)
public class RedissonProperties {

	private String address; //连接地址

	private int database;

	private int timeout;

	private String password;

	private RedissonPoolProperties pool;


}

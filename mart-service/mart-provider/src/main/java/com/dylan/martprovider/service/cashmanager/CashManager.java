package com.dylan.martprovider.service.cashmanager;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/18 16:23
 */
@Service
public class CashManager {

	@Autowired
	private RedissonClient redissonClient;

	/**
	 * 检查缓存
	 */
	public String checkCash(String key ){
		RBucket bucket = redissonClient.getBucket(key);
		Object o = bucket.get();

		return o == null? "":o.toString();
	}

	/**
	 * 添加进缓存
	 */
	public void setCash(String key,String val,int expire){
		RBucket bucket = redissonClient.getBucket(key);
		bucket.set(val);
		setExpire(key,expire);
	}

	/**
	 * 设置过期时间
	 */
	public void setExpire(String key ,int expire){
		RBucket bucket = redissonClient.getBucket(key);
		bucket.expire(expire, TimeUnit.DAYS);
	}
}

package com.dylan.config.redisconfig;

import lombok.Data;

/**
 * code is far away from bug with the animal protecting
 *
 * @Author : dylan
 * @Date :create in 2019/9/10 17:26
 */

@Data
public class RedissonPoolProperties {

    private int maxIdle; /**连接池中的最大空闲连接**/

    private int minIdle;  /**最小连接数**/

    private int maxActive;/**连接池最大连接数**/

    private int maxWait;/**连接池最大阻塞等待时间**/

}

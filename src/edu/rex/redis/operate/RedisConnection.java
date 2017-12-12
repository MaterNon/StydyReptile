/**    
* @Title: RedisConnection.java  
* @Package edu.rex.redis  
* @Description:
* @author 蔡海峰
* @date 2017年12月12日 上午10:24:24  
* @version V1.0    
*/
package edu.rex.redis.operate;

import redis.clients.jedis.Jedis;

/**
 * 
 * @ClassName:     RedisConnection   
 * @Description:    
 * @author:        caihaifeng
 * @date:          2017年12月12日 上午10:24:24 
 *
 * 
 */
public class RedisConnection {
	public static void main(String[] args) {
		 Jedis jedis;
	        // 连接redis服务器
	        jedis = new Jedis("192.168.222.128", 6379);
	        System.out.println("Connection to server sucessfully");
	        jedis.select(1);
	        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-"
	                + jedis.get("qq"));
	}
}

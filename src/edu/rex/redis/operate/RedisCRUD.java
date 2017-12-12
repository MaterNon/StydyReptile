/**    
* @Title: RedisCRUD.java  
* @Package edu.rex.redis.operate  
* @Description:
* @author 蔡海峰
* @date 2017年12月12日 上午11:34:45  
* @version V1.0    
*/
package edu.rex.redis.operate;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import edu.rex.SerializableObject;
import edu.rex.common.util.MD5;
import edu.rex.jobo.CrawlUrl;
import redis.clients.jedis.Jedis;

/**
 * 
 * @ClassName:     RedisCRUD   
 * @Description:    
 * @author:        caihaifeng
 * @date:          2017年12月12日 上午11:34:45 
 *
 * 
 */
public class RedisCRUD {
	@SuppressWarnings("rawtypes")
	private static SortedMap pendingUrisDB = null;
	static MD5 md5 = new MD5();
	public RedisCRUD(){
		//对SortedMap重新封装
		Map<Object,Object> map  = new HashMap<>();
		pendingUrisDB = new TreeMap<Object,Object>(map); 
	}
	
	
	
	public static Jedis getRedis(){
		Jedis jedis;
        // 连接redis服务器
        jedis = new Jedis("192.168.222.128", 6379);
        return jedis; 
	}
	
	public void delDb(int db , String key){
		Jedis jedis = getRedis();
		jedis.select(db);
		jedis.del(key);
	}
	
	public   void saveDb( Object key,Object value){
		int db   = 5;
		Jedis jedis = getRedis();
		jedis.select(db);
		jedis.set(((String)key).getBytes(), SerializableObject.serialize(value));
	}
	public void updateDb(int db , String key, String value){
		
	}
	//获得下一条记录
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CrawlUrl getNext() throws Exception {
		
		CrawlUrl result = null;
		if(!pendingUrisDB.isEmpty()){
		Set entrys = pendingUrisDB.entrySet();
		System.out.println(entrys);
		Entry<String,CrawlUrl> entry=(Entry<String,CrawlUrl>)pendingUrisDB.entrySet().iterator().next();
		result = entry.getValue();
		delete(entry.getKey());
		}
		return result;
		}
	//存入 URL
	public boolean putUrl(CrawlUrl url){
		put(url.getOriUrl(),url);
		return true;
	}
	// 存入数据库的方法
	@SuppressWarnings("unchecked")
	protected void put(Object key,Object value) {
		saveDb(key, value);
		pendingUrisDB.put(key, value);
	}
	//取出
	protected Object get(Object key){
		return pendingUrisDB.get(key);
	}
	//删除
	protected Object delete(Object key){
		return pendingUrisDB.remove(key);
	}
	
	// 根据 URL 计算键值，可以使用各种压缩算法，包括 MD5 等压缩算法
	@SuppressWarnings("unused")
	private String caculateUrl(String url) {
		return md5.getMD5(url);
	}
	
	
}

/**    
* @Title: TestMd5.java  
* @Package edu.rex.test.util  
* @Description:
* @author 蔡海峰
* @date 2017年12月12日 上午9:55:19  
* @version V1.0    
*/
package edu.rex.test.util;

import edu.rex.jobo.CrawlUrl;
import edu.rex.redis.operate.RedisCRUD;

/**
 * 
 * @ClassName:     TestMd5   
 * @Description:    
 * @author:        caihaifeng
 * @date:          2017年12月12日 上午9:55:19 
 *
 * 
 */
public class TestMd5 {

	/**
	  @Title:         main   
	 * @Description:      
	 * @param:         @param args      
	 * @return:        void   
	 * @author:        caihaifeng
	 * @date:          2017年12月12日 上午9:55:19   
	 * @throws   
	 */
	public static void main(String[] args) {
		RedisCRUD rc = new RedisCRUD();
		CrawlUrl url = new CrawlUrl();
		url.setOriUrl("http://www.163.com");
		rc.putUrl(url);
		try { 
			System.out.println(((CrawlUrl)rc.getNext()).getUrl());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

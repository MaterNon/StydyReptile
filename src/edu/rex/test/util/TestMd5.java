/**    
* @Title: TestMd5.java  
* @Package edu.rex.test.util  
* @Description:
* @author 蔡海峰
* @date 2017年12月12日 上午9:55:19  
* @version V1.0    
*/
package edu.rex.test.util;

import edu.rex.common.util.MD5;

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
		MD5 m5  = new MD5("https://www.baidu.com");
		System.out.println(m5.getMD5());

	}

}

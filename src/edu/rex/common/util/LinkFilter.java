/**    
* @Title: LinkFilter.java  
* @Package edu.rex.common.util  
* @Description:
* @author 蔡海峰
* @date 2017年12月6日 下午3:53:56  
* @version V1.0    
*/
package edu.rex.common.util;

/**
 * 
 * @ClassName:     LinkFilter   
 * @Description:    
 * @author:        caihaifeng
 * @date:          2017年12月6日 下午3:53:56 
 *
 * 
 */


public interface LinkFilter {
	public boolean accept(String url);
}


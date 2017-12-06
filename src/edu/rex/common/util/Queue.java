/**    
* @Title: Queue.java  
* @Package edu.rex.common.util  
* @Description:
* @author 蔡海峰
* @date 2017年12月6日 下午3:54:53  
* @version V1.0    
*/
package edu.rex.common.util;

/**
 * 
 * @ClassName:     Queue   
 * @Description:    
 * @author:        caihaifeng
 * @date:          2017年12月6日 下午3:54:53 
 *
 * 
 */


import java.util.LinkedList;
/**
 * 队列，保存将要访问的URL
 */
public class Queue {
	//使用链表实现队列
	private LinkedList queue = new LinkedList();
    //入队列
	public void enQueue(Object t) {
		queue.addLast(t);
	}
    //出队列
	public Object deQueue() {
		return queue.removeFirst();
	}
    //判断队列是否为空
	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}
    //判断队列是否包含t
	public boolean contians(Object t) {
		return queue.contains(t);
	}

	public boolean empty() {
		return queue.isEmpty();
	}

}


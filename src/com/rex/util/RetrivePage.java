/**    
* @Title: RetrivePage.java  
* @Package com.rex.util  
* @Description:
* @author 蔡海峰
* @date 2017年12月5日 上午11:28:46  
* @version V1.0    
*/
package com.rex.util;

/**
 * 
 * @ClassName:     RetrivePage   
 * @Description:    
 * @author:        caihaifeng
 * @date:          2017年12月5日 上午11:28:46 
 *
 * 
 */


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class RetrivePage {
	private static HttpClient httpClient = new HttpClient();
	// 设置代理服务器
	static {
		// 设置代理服务器的IP地址和端口
		httpClient.getHostConfiguration().setProxy("192.168.222.132",10086);
		
	}

	public static boolean downloadPage(String path) throws HttpException,
			IOException {
		InputStream input = null;
		OutputStream output = null;
		// 得到post方法
	//	PostMethod postMethod = new PostMethod(path);
		// 设置post方法的参数
		/*
		 * NameValuePair[] postData = new NameValuePair[2]; postData[0] = new
		 * NameValuePair("name","lietu"); postData[1] = new
		 * NameValuePair("password","*****");
		 * postMethod.addParameters(postData);
		 */
		// 执行，返回状态码
		GetMethod postMethod = new GetMethod(path);
		int statusCode = httpClient.executeMethod(postMethod);
		System.out.println(statusCode);
		// 针对状态码进行处理 (简单起见，只处理返回值为200的状态码)
		if (statusCode == HttpStatus.SC_OK) {
			input = postMethod.getResponseBodyAsStream();
			//得到文件名
			String filename = path.substring(path.lastIndexOf('/')+1);
			//获得文件输出流
			output = new FileOutputStream(filename);
			System.out.println(filename);
			//输出到文件
			int tempByte = -1;
			while((tempByte=input.read())>0){
				output.write(tempByte);
			}
			//关闭输入输出流
			if(input!=null){
				input.close();
			}
			if(output!=null){
				output.close();
			}
			return true;
		}
		//若需要转向，则进行转向操作
		if ((statusCode == HttpStatus.SC_MOVED_TEMPORARILY) || (statusCode == HttpStatus.SC_MOVED_PERMANENTLY) || (statusCode == HttpStatus.SC_SEE_OTHER) || (statusCode == HttpStatus.SC_TEMPORARY_REDIRECT)) {
		    //读取新的URL地址
			Header header = postMethod.getResponseHeader("location");
			if(header!=null){
				String newUrl = header.getValue();
				if(newUrl==null||newUrl.equals("")){
					newUrl="/";
					//使用post转向
					PostMethod redirect = new PostMethod(newUrl);
					//发送请求，做进一步处理。。。。。
					NameValuePair[] names = redirect.getParameters();
					for(NameValuePair nv : names){
						System.out.println(nv.getName());
					}
				}
			}
		}
		return false;
	}

	/**
	 * 测试代码
	 */
	public static void main(String[] args) {
		// 抓取lietu首页,输出
		try {
			System.out.println(RetrivePage.downloadPage("https://www.aliyun.com"));
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


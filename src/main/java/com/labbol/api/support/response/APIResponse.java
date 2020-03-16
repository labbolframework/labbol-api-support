/**
 * 
 */
package com.labbol.api.support.response;

import org.yelong.http.response.HttpResponse;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2020年3月3日上午10:13:03
 * @version 
 */
public interface APIResponse{

	String getErrorCode();
	
	String getErrorMsg();
	
	boolean isSuccess();
	
	/**
	 * 获取 http 响应
	 * @return
	 */
	HttpResponse getHttpResponse();
	
}

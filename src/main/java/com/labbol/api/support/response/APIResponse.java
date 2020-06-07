/**
 * 
 */
package com.labbol.api.support.response;

import org.yelong.http.response.HttpResponse;

/**
 * @author PengFei
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

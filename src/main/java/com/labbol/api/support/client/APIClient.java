/**
 * 
 */
package com.labbol.api.support.client;

import java.io.IOException;
import java.util.List;

import org.yelong.http.client.HttpClient;

import com.labbol.api.support.exception.APIException;
import com.labbol.api.support.request.APIRequest;
import com.labbol.api.support.request.APIRequestInterceptor;
import com.labbol.api.support.response.APIResponse;
import com.labbol.api.support.response.APIResponseInterceptor;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2020年3月3日上午9:03:37
 * @version 
 */
public interface APIClient {
	
	<T extends APIResponse> T execute(APIRequest<T> request) throws APIException , IOException;

	/**
	 * 添加请求拦截器
	 * @param APIRequestInterceptor
	 */
	void addAPIRequestInterceptor(APIRequestInterceptor APIRequestInterceptor);
	
	/**
	 * 移除请求拦截器
	 * @param APIRequestInterceptor
	 */
	void removeAPIRequestInterceptor(APIRequestInterceptor APIRequestInterceptor);
	
	/**
	 * 获取所有请求拦截器
	 * @return
	 */
	List<APIRequestInterceptor> getAPIRequestInterceptors();
	
	/**
	 * 添加响应拦截器
	 * @param APIResponseInterceptor
	 */
	void addAPIResponseInterceptor(APIResponseInterceptor APIResponseInterceptor);
	
	/**
	 * 移除响应拦截器
	 * @param APIResponseInterceptor
	 */
	void removeAPIResponseInterceptor(APIResponseInterceptor APIResponseInterceptor);
	
	/**
	 * 获取所有响应拦截器
	 * @return
	 */
	List<APIResponseInterceptor> getAPIResponseInterceptors();
	
	/**
	 * @return http 客户端
	 */
	HttpClient getHttpClient();
	
	/**
	 * @param httpClient http 客户端
	 */
	void setHttpClient(HttpClient httpClient);
	
}

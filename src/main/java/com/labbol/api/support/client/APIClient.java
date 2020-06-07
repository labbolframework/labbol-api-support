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
 * @author PengFei
 */
public interface APIClient {
	
	<T extends APIResponse> T execute(APIRequest<T> request) throws APIException , IOException;

	/**
	 * 添加请求拦截器
	 * 
	 * @param APIRequestInterceptor 请求拦截器
	 */
	void addAPIRequestInterceptor(APIRequestInterceptor APIRequestInterceptor);
	
	/**
	 * 移除请求拦截器
	 * 
	 * @param APIRequestInterceptor 请求拦截器
	 */
	void removeAPIRequestInterceptor(APIRequestInterceptor APIRequestInterceptor);
	
	/**
	 * @return 所有的请求拦截器
	 */
	List<APIRequestInterceptor> getAPIRequestInterceptors();
	
	/**
	 * 添加响应拦截器
	 * 
	 * @param APIResponseInterceptor 响应拦截器
	 */
	void addAPIResponseInterceptor(APIResponseInterceptor APIResponseInterceptor);
	
	/**
	 * 移除响应拦截器
	 * 
	 * @param APIResponseInterceptor 响应拦截器
	 */
	void removeAPIResponseInterceptor(APIResponseInterceptor APIResponseInterceptor);
	
	/**
	 * @return 所有的响应拦截器
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

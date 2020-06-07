/**
 * 
 */
package com.labbol.api.support.request;

import java.io.IOException;

import org.yelong.http.exception.HttpException;
import org.yelong.http.request.HttpRequest;

import com.labbol.api.support.exception.APIException;
import com.labbol.api.support.exception.APIRuleException;
import com.labbol.api.support.response.APIResponse;

/**
 * @author PengFei
 */
public interface APIRequest <T extends APIResponse>{

	/**
	 * 公共的 header 参数 name
	 */
	String [] COMMON_HEADER_PARAM_NAMES = {"appKey","schemaTag","timestamp"};
	
	/**
	 * api 方法名称
	 * @return
	 */
	String getApiMethodName();

	/**
	 * 设置服务的根url
	 * @param serverUrl
	 */
	void setServerUrl(String serverUrl);
	
	/**
	 * 获取服务的根url
	 * @return
	 */
	String getServerUrl();
	
	/**
	 * 获取响应的类型
	 * @return
	 */
	Class<T> getResponseClass();

	/**
	 * 验证请求
	 * @throws APIRuleException
	 */
	void check() throws APIRuleException;
	
	/**
	 * 设置令牌
	 * @param authToken
	 * @deprecated 已去除token
	 */
	@Deprecated
	void setAuthToken(String authToken);
	
	/**
	 * 获取令牌
	 * @return
	 * @deprecated 已去除token
	 */
	@Deprecated
	String getAuthToken();
	
	/**
	 * 设置 schema 
	 * @param schemaKey
	 */
	void setSchemaTag(String schemaKey);
	
	/**
	 * 获取 scheam
	 * @return
	 */
	String getSchemaTag();
	
	/**
	 * 获取时间戳
	 * @return
	 */
	Long getTimestamp();
	
	/**
	 * 设置时间戳
	 * @param timestamp
	 */
	void setTimestamp(long timestamp);
	
	/**
	 * 获取 http 请求
	 * @return
	 */
	HttpRequest getHttpRequest() throws HttpException,APIException,IOException;
	
}

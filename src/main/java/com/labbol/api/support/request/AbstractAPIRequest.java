/**
 * 
 */
package com.labbol.api.support.request;

import java.io.IOException;

import org.yelong.http.exception.HttpException;
import org.yelong.http.request.HttpRequest;
import org.yelong.http.request.HttpRequestFactory;

import com.google.gson.Gson;
import com.labbol.api.support.exception.APIException;
import com.labbol.api.support.exception.APIRuleException;
import com.labbol.api.support.response.APIResponse;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2020年3月3日下午3:51:03
 * @version 
 */
public abstract class AbstractAPIRequest<T extends APIResponse> implements APIRequest<T>{

	@Deprecated
	public static final String X_AUTH_TOKEN = "X-Auth-Token";
	
	public static final String SCHEMA_KEY = "";
	
	protected static final Gson gson = new Gson();
	
	private String apiMethodName;
	
	private String serverUrl;
	
	@Deprecated
	private String authToken;
	
	protected HttpRequest httpRequest;
	
	private Long timestamp;
	
	private String schemaTag;
	
	public AbstractAPIRequest(String apiMethodName, String method) {
		this.apiMethodName = apiMethodName;
		this.httpRequest = HttpRequestFactory.create(apiMethodName, method);
	}
	
	@Override
	public String getApiMethodName() {
		return this.apiMethodName;
	}

	@Override
	public String getServerUrl() {
		return this.serverUrl;
	}
	
	@Override
	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
		if( serverUrl.endsWith("/") ) {
			httpRequest.setUrl(serverUrl + apiMethodName);
		} else {
			httpRequest.setUrl(serverUrl + "/" + apiMethodName);
		}
	}
	
	@Override
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
		httpRequest.addHeader(X_AUTH_TOKEN, authToken);
	}
	
	@Override
	public String getAuthToken() {
		return this.authToken;
	}
	
	@Override
	public void check() throws APIRuleException {

	}
	
	@Override
	public HttpRequest getHttpRequest() throws HttpException,APIException,IOException{
		return this.httpRequest;
	}
	
	@Override
	public void setSchemaTag(String schemaTag) {
		//this.httpRequest.addHeader(SCHEMA_KEY, schemaKey);
		this.schemaTag = schemaTag;
	}
	
	@Override
	public String getSchemaTag() {
		//return this.httpRequest.getHeader(SCHEMA_KEY);
		return this.schemaTag;
	}
	
	@Override
	public Long getTimestamp() {
		return this.timestamp;
	}
	
	@Override
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}

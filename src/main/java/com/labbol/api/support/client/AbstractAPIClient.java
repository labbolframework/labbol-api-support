/**
 * 
 */
package com.labbol.api.support.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.yelong.http.client.DefaultHttpClient;
import org.yelong.http.client.HttpClient;

import com.labbol.api.support.request.APIRequestInterceptor;
import com.labbol.api.support.response.APIResponseInterceptor;

/**
 * @author PengFei
 * @date 2020年3月5日上午10:53:46
 * @since 1.0
 */
public abstract class AbstractAPIClient implements APIClient{

	private final List<APIRequestInterceptor> apiRequestInterceptors = new ArrayList<>();
	
	private final List<APIResponseInterceptor> apiResponseInterceptors = new ArrayList<>();
	
	protected HttpClient httpClient;
	
	public AbstractAPIClient() {
		this(new DefaultHttpClient());
	}
	
	public AbstractAPIClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}
	
	@Override
	public void addAPIRequestInterceptor(APIRequestInterceptor apiRequestInterceptor) {
		this.apiRequestInterceptors.add(apiRequestInterceptor);
	}

	@Override
	public void removeAPIRequestInterceptor(APIRequestInterceptor apiRequestInterceptor) {
		this.apiRequestInterceptors.remove(apiRequestInterceptor);
	}

	@Override
	public List<APIRequestInterceptor> getAPIRequestInterceptors() {
		return this.apiRequestInterceptors;
	}

	@Override
	public void addAPIResponseInterceptor(APIResponseInterceptor apiResponseInterceptor) {
		this.apiResponseInterceptors.add(apiResponseInterceptor);
	}

	@Override
	public void removeAPIResponseInterceptor(APIResponseInterceptor apiResponseInterceptor) {
		this.apiResponseInterceptors.remove(apiResponseInterceptor);
	}

	@Override
	public List<APIResponseInterceptor> getAPIResponseInterceptors() {
		return this.apiResponseInterceptors;
	}
	
	public HttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(HttpClient httpClient) {
		Objects.requireNonNull(httpClient);
		this.httpClient = httpClient;
	}

}

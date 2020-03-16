/**
 * 
 */
package com.labbol.api.support.client;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.yelong.http.exception.HttpException;
import org.yelong.http.request.HttpRequest;
import org.yelong.http.response.HttpResponse;

import com.labbol.api.support.exception.APIException;
import com.labbol.api.support.request.APIRequest;
import com.labbol.api.support.request.APIRequestInterceptor;
import com.labbol.api.support.response.APIResponse;
import com.labbol.api.support.response.APIResponseInterceptor;
import com.labbol.api.support.sign.SignSupportUtils;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2020年3月3日下午4:11:35
 * @version 
 */
public class DefaultAPIClient extends AbstractAPIClient{

	private final String serverUrl;

	private String appKey;
	
	private String appSecret;
	
	public DefaultAPIClient(String serverUrl, String appKey, String appSecret) {
		this.serverUrl = serverUrl;
		this.appKey = appKey;
		this.appSecret = appSecret;
	}
	
	@Override
	public <T extends APIResponse> T execute(APIRequest<T> request) throws APIException, IOException {
		request.setServerUrl(serverUrl);//设置服务路径
		T apiResponse = null;
		try {
			request.check();
			for (APIRequestInterceptor apiIRequestInterceptor : getAPIRequestInterceptors()) {
				apiIRequestInterceptor.process(request);
			}
			
			HttpRequest httpRequest = request.getHttpRequest();
			Map<String,String> headers = new HashMap<>(3);
			
			//生成签名
			Long timestamp = request.getTimestamp();
			if ( null == timestamp ) {
				timestamp = Long.valueOf(System.currentTimeMillis());
			}
			headers.put("appKey", appKey);
			//headers.put("timestamp", DateFormatUtils.format(new Date(timestamp.longValue()), "yyyy-MM-dd hh:mm:ss"));
			headers.put("timestamp", timestamp.toString());
			headers.put("schemaTag",request.getSchemaTag());
			
			String contentStr = httpRequest.getFileItems().isEmpty() ? httpRequest.getContentStr() : null;
			String sign = SignSupportUtils.generateSign(httpRequest.getParams(), headers,contentStr, appSecret);
			
			httpRequest.addHeader("sign",sign);
			httpRequest.addHeaders(headers);
			
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			Constructor<T> constructor = request.getResponseClass().getConstructor(HttpResponse.class);
			apiResponse = constructor.newInstance(httpResponse);
			
			for (APIResponseInterceptor apiResponseInterceptor : getAPIResponseInterceptors()) {
				apiResponseInterceptor.process(apiResponse);
			}
		} catch (APIException e) {
			throw e;
		} catch (HttpException e) {
			throw new APIException(e);
		} catch (Exception e) {
			throw new APIException(e);
		}
		return apiResponse;
	}

	public String getAppKey() {
		return appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}
	
}

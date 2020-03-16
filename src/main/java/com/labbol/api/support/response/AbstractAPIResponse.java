/**
 * 
 */
package com.labbol.api.support.response;

import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.yelong.http.response.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2020年3月3日下午3:58:39
 * @version 
 */
public class AbstractAPIResponse implements APIResponse{

	protected static final Gson gson = new Gson();
	
	private static final String ERROR_RESPONSE_ROOT_NODE = "error_response";
	
	private String errorCode;
	
	private String errorMsg;
	
	protected HttpResponse httpResponse;
	
	@SuppressWarnings("unchecked")
	public AbstractAPIResponse(HttpResponse httpResponse) {
		//super(httpResponse.getRequest(), httpResponse.getHeaders(), httpResponse.getContent(), httpResponse.getCharset(), httpResponse.getResponseCode());
		this.httpResponse = httpResponse;
		String contentStr = httpResponse.getContentStr();
		try {
			Map<String,Object> map = gson.fromJson(contentStr, new TypeToken<Map<String,Object>>(){}.getType());
			if(MapUtils.isNotEmpty(map)) {
				Map<String,Object> errorResponse = (Map<String, Object>) map.get(ERROR_RESPONSE_ROOT_NODE);
				if(MapUtils.isNotEmpty(errorResponse)) {
					errorCode = (String)errorResponse.get("code");
					errorMsg = (String)errorResponse.get("msg");
				}
			}
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public String getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getErrorMsg() {
		return this.errorMsg;
	}

	@Override
	public boolean isSuccess() {
		return getErrorCode() == null && httpResponse.getResponseCode() == 200;
	}

	@Override
	public HttpResponse getHttpResponse() {
		return this.httpResponse;
	}

}
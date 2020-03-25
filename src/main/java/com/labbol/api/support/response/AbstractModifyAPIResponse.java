/**
 * 
 */
package com.labbol.api.support.response;

import java.util.Map;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MapUtils;
import org.yelong.http.response.HttpResponse;

import com.google.gson.reflect.TypeToken;

/**
 * 修改api响应默认实现
 * @author 14308
 */
public abstract class AbstractModifyAPIResponse extends AbstractAPIResponse {

	private Map<String,Object> responseResult;

	private String id;

	private String updateTime;
	
	@SuppressWarnings("rawtypes")
	public AbstractModifyAPIResponse(HttpResponse httpResponse) {
		super(httpResponse);
		if(isSuccess()) {
			responseResult = gson.fromJson(httpResponse.getContentStr(),new TypeToken<Map<String,Object>>(){}.getType());
			if(MapUtils.isNotEmpty(responseResult)){
				Object model = IteratorUtils.get(responseResult.values().iterator(), 0);
				if( null != model) {
					id = (String) ((Map)model).get("id");
					updateTime = (String) ((Map)model).get("updateTime");
				}
			}
		}
	}
	
	public String getId() {
		return id;
	}
	
	public String getUpdateTime() {
		return updateTime;
	}
	
	public Map<String, Object> getResponseResult() {
		return responseResult;
	}
}

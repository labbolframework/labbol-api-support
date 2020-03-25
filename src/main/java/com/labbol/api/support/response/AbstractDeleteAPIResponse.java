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
 * 删除api响应默认实现
 * @author 14308
 */
public abstract class AbstractDeleteAPIResponse extends AbstractAPIResponse{

	private Map<String,Object> responseResult;

	private String id;

	private String deleteTime;

	@SuppressWarnings("rawtypes")
	public AbstractDeleteAPIResponse(HttpResponse httpResponse) {
		super(httpResponse);
		if(isSuccess()) {
			responseResult = gson.fromJson(httpResponse.getContentStr(),new TypeToken<Map<String,Object>>(){}.getType());
			if(MapUtils.isNotEmpty(responseResult)){
				Object model = IteratorUtils.get(responseResult.values().iterator(), 0);
				if( null != model) {
					id = (String) ((Map)model).get("id");
					deleteTime = (String) ((Map)model).get("deleteTime");
				}
			}
		}
	}

	public Map<String, Object> getResponseResult() {
		return responseResult;
	}

	public String getId() {
		return id;
	}

	public String getDeleteTime() {
		return deleteTime;
	}


}

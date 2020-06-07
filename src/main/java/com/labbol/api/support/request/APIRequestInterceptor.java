/**
 * 
 */
package com.labbol.api.support.request;

import java.io.IOException;

import com.labbol.api.support.exception.APIException;
import com.labbol.api.support.response.APIResponse;

/**
 * @author PengFei
 */
public interface APIRequestInterceptor {

	/**
	 * 在请求之前执行
	 * 此方法将在APIRequest未初始化时进行调用。
	 * 
	 * @param request request
	 * @throws APIException API异常
	 * @throws IOException 流异常
	 */
	void process(APIRequest<? extends APIResponse> request) throws APIException, IOException;

}

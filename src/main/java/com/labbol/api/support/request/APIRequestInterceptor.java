/**
 * 
 */
package com.labbol.api.support.request;

import java.io.IOException;

import com.labbol.api.support.exception.APIException;
import com.labbol.api.support.response.APIResponse;

/**
 * @author PengFei
 * @date 2020年3月5日上午10:50:41
 * @since 1.0
 */
public interface APIRequestInterceptor {

	/**
	 * 在请求之前执行
	 * 此方法将在APIRequest未初始化时进行调用。
	 * @param request
	 * @throws APIException
	 * @throws IOException
	 */
	void process(APIRequest<? extends APIResponse> request) throws APIException, IOException;

}

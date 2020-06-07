/**
 * 
 */
package com.labbol.api.support.response;

import java.io.IOException;

import com.labbol.api.support.exception.APIException;

/**
 * @author PengFei
 */
public interface APIResponseInterceptor {

	/**
	 * 在请求执行后执行
	 * 
	 * @param response response
	 * @throws APIException api异常
	 * @throws IOException 流异常
	 */
	void process(APIResponse response) throws APIException, IOException;

}

/**
 * 
 */
package com.labbol.api.support.response;

import java.io.IOException;

import com.labbol.api.support.exception.APIException;

/**
 * @author PengFei
 * @date 2020年3月5日上午10:51:31
 * @since 1.0
 */
public interface APIResponseInterceptor {

	/**
	 * 在请求执行后执行
	 * @param response
	 * @throws APIException
	 * @throws IOException
	 */
	void process(APIResponse response) throws APIException, IOException;

}

/**
 * 
 */
package com.labbol.api.support.sign;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.yelong.http.exception.HttpException;
import org.yelong.http.request.HttpRequest;

import com.labbol.api.support.exception.APIException;
import com.labbol.api.support.request.APIRequest;
import com.labbol.api.support.response.APIResponse;

/**
 * @author PengFei
 * @date 2020年3月10日上午10:22:53
 * @since 1.0
 */
@Deprecated
public interface APIRequestSign {

	/**
	 * 生成签名
	 * 签名参数包含：公共的header、params、消息体
	 * @param apiRequest
	 * @return
	 */
	default String generateSign(APIRequest<? extends APIResponse> apiRequest) throws APIException, HttpException, IOException,NoSuchAlgorithmException {
		return generateSign(apiRequest.getHttpRequest());
	}
	
	String generateSign(HttpRequest httpRequest) throws APIException, HttpException, IOException,NoSuchAlgorithmException;
	
}

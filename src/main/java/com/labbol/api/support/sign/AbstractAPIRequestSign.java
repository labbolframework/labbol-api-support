/**
 * 
 */
package com.labbol.api.support.sign;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.yelong.http.request.HttpRequest;

import com.labbol.api.support.request.APIRequest;

/**
 * @author PengFei
 * @date 2020年3月10日上午10:32:23
 * @since 1.0
 */
@Deprecated
public abstract class AbstractAPIRequestSign implements APIRequestSign{

	protected static final String SIGN_REQUEST_BODY_NAME = "requestBody";
	
	/**
	 * 获取进行签名的请求参数
	 * @param httpRequest
	 * @return
	 * @throws IOException 
	 */
	protected Map<String,String> getSignRequestParams(HttpRequest httpRequest) throws IOException{
		// 组装生成签名需要的参数
		TreeMap<String, String> signRequestParamMap = new TreeMap<String, String>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return ((String) o2).compareTo(o1);
			}
		});
		//添加请求头
		for (String header : APIRequest.COMMON_HEADER_PARAM_NAMES) {
			String value = httpRequest.getHeader(header);
			if( null != value ) {
				signRequestParamMap.put(header, value);
			}
		}
		//添加参数
		for (Entry<String, String> entry : httpRequest.getParams().entrySet()) {
			if( null != entry.getValue()) {
				signRequestParamMap.put(entry.getKey(), entry.getValue());
			}
		}
		String contentStr = httpRequest.getContentStr();
		if( null != contentStr ) {
			signRequestParamMap.put(SIGN_REQUEST_BODY_NAME,contentStr);
		}
		return signRequestParamMap;
	}


}

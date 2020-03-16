/**
 * 
 */
package com.labbol.api.support.client;

import java.io.IOException;
import java.util.function.Supplier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.labbol.api.support.Constants;
import com.labbol.api.support.exception.APIException;
import com.labbol.api.support.request.APIRequest;
import com.labbol.api.support.request.APIRequestInterceptor;
import com.labbol.api.support.response.APIResponse;

/**
 * @author PengFei
 * @date 2020年3月9日下午6:24:56
 * @since 1.0
 */
public class APIClientFactory {
	
	
	public static final APIClient createSpringMvcDefaultAPIClient(String serverUrl, String appKey, String appSecret) {
		try {
			return createDefaultAPIClient(serverUrl, appKey, appSecret, ()->{
				return ((org.springframework.web.context.request.ServletRequestAttributes)org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).getRequest();
			});
		} catch (Exception e) {
			throw new RuntimeException("当前未使用SpringMvc框架！",e);
		}
	}
	
	
	
	
	public static final APIClient createDefaultAPIClient(String serverUrl, String appKey, String appSecret,Supplier<HttpServletRequest> requestHolder) {
		APIClient apiClient = new DefaultAPIClient(serverUrl, appKey, appSecret);
		//添加schema
		apiClient.addAPIRequestInterceptor(new APIRequestInterceptor() {
			@Override
			public void process(APIRequest<? extends APIResponse> request) throws APIException, IOException {
				if(StringUtils.isNotBlank(request.getSchemaTag())) {
					return;
				}
				HttpServletRequest httpServletRequest = requestHolder.get();
				HttpSession session = httpServletRequest.getSession();
				request.setSchemaTag((String)session.getAttribute(Constants.SESSION_SCHEMA_TAG_NAME));
				//request.setSchemaTag("sgcm");
			}
		});
		return apiClient;
	}
	
	
}

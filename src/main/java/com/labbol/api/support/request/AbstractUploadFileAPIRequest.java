/**
 * 
 */
package com.labbol.api.support.request;

import com.labbol.api.support.response.APIResponse;

/**
 * @author PengFei
 */
public abstract class AbstractUploadFileAPIRequest<T extends APIResponse> extends AbstractAPIRequest<T>{

	public AbstractUploadFileAPIRequest(String apiMethodName, String method) {
		super(apiMethodName, method);
		httpRequest.setContentType(null);
	}

}

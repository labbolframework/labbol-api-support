/**
 * 
 */
package com.labbol.api.support.exception;

import org.yelong.http.exception.HttpException;

/**
 * @author PengFei
 */
public class APIException extends HttpException{

	private static final long serialVersionUID = 6550085631649061120L;

	public APIException() {

	}

	public APIException(String message) {
		super(message);
	}

	public APIException(Throwable t) {
		super(t);
	}

}

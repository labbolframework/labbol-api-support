/**
 * 
 */
package com.labbol.api.support.exception;

import org.yelong.http.exception.HttpException;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2020年3月3日下午4:24:57
 * @version 
 */
public class APIException extends HttpException{

	/**
	 * 
	 */
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

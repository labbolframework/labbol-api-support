/**
 * 
 */
package com.labbol.api.support.exception;

/**
 * @author pengfei<yl1430834495@163.com>
 * @date 2020年3月3日下午3:37:33
 * @version 
 */
public class APIRuleException extends APIException{

	private static final long serialVersionUID = 6227870255814060221L;

	private String code;
	
	private String message;
	
	public APIRuleException(String code,String message) {
		super(code+":"+message);
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}

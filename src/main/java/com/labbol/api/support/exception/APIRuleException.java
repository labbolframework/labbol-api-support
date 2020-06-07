/**
 * 
 */
package com.labbol.api.support.exception;

/**
 * @author PengFei
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

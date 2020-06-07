/**
 * 
 */
package com.labbol.api.support.utils;

import org.yelong.commons.beans.BeanUtilsE;

import com.labbol.api.support.exception.APIRuleException;

/**
 * @author PengFei
 */
public class RequestCheckUtils {

	/**
	 * 检查值不能为空
	 * 
	 * @param value 值
	 * @param fieldName 该值对应的字段
	 * @throws APIRuleException
	 */
	public static void checkNotEmpty(Object value, String fieldName)throws APIRuleException {
		if (value == null) {
			throw new APIRuleException("40", "client-error:Missing required arguments:" + fieldName + "");
		}
		if (((value instanceof String)) && 
				(((String)value).trim().length() == 0)) {
			throw new APIRuleException("40", "client-error:Missing required arguments:" + fieldName + "");
		}
	}

	/**
	 * 检测对象中的字段是否为非空白
	 * 
	 * @param bean bean 
	 * @param fieldName 字段名称
	 * @throws APIRuleException 参数验证失败
	 */
	public static void checkBeanFieldNotEmpty(Object bean, String fieldName)throws APIRuleException {
		Object value = getProperty(bean, fieldName);
		if (value == null) {
			throw new APIRuleException("40", "client-error:Missing required arguments:" + bean.getClass().getSimpleName() + "."+fieldName + "");
		}
		if (((value instanceof String)) && 
				(((String)value).trim().length() == 0)) {
			throw new APIRuleException("40", "client-error:Missing required arguments:" + bean.getClass().getSimpleName() + "."+fieldName + "");
		}
	}
	
	/**
	 * 检测对象中的所有字段是否为非空白
	 * 
	 * @param bean bean 
	 * @param fieldName 字段名称
	 * @throws APIRuleException 参数验证失败
	 */
	public static void checkBeanFieldNotEmpty(Object bean, String [] fieldNames)throws APIRuleException {
		for (String fieldName : fieldNames) {
			checkBeanFieldNotEmpty(bean, fieldName);
		}
	}
	
	/**
	 * @see BeanUtilsE#getProperty(Object, String)
	 */
	private static Object getProperty(Object bean , String propertyName) {
		try {
			return BeanUtilsE.getProperty(bean, propertyName);
		} catch (NoSuchMethodException e) {
			return null;
		}
	}
	

}

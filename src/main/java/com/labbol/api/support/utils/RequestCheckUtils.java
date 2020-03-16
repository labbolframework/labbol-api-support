/**
 * 
 */
package com.labbol.api.support.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import com.labbol.api.support.exception.APIRuleException;

/**
 * @author PengFei
 * @date 2020年3月6日上午10:22:00
 * @since 1.0
 */
public class RequestCheckUtils {

	/**
	 * 检查值不能为空
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
	 * @param bean
	 * @param fieldName
	 * @throws APIRuleException
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
	 * @param bean
	 * @param fieldNames
	 * @throws APIRuleException
	 */
	public static void checkBeanFieldNotEmpty(Object bean, String [] fieldNames)throws APIRuleException {
		for (String fieldName : fieldNames) {
			checkBeanFieldNotEmpty(bean, fieldName);
		}
	}
	
	/**
	 * 获取对象属性值
	 * @param bean
	 * @param propertyName
	 * @return
	 */
	private static Object getProperty(Object bean , String propertyName) {
		try {
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, bean.getClass());
			Method readMethod = propertyDescriptor.getReadMethod();
			return readMethod.invoke(bean);
		} catch (Exception e) {
			return null;
		}
	}
	

}

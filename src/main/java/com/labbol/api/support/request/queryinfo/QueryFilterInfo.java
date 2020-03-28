/**
 * 
 */
package com.labbol.api.support.request.queryinfo;

import java.util.Arrays;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 彭飞
 * @date 2019年10月22日下午2:39:11
 * @version 1.2
 */
public class QueryFilterInfo {
	
	private String fieldName;
	
	private String operator;
	
	private Object fieldValue;
	
	private String groupName;
	
	private transient Class<?> fieldType;

	private String fieldTypeStr;
	
	private String connectOperator;
	
	public QueryFilterInfo() {
		
	}
	
	public QueryFilterInfo(String fieldName, String operator) {
		this.fieldName = fieldName;
		this.operator = operator;
	}
	
	public QueryFilterInfo(String fieldName, String operator, Object value) {
		this.fieldName = fieldName;
		this.operator = operator;
		this.fieldValue = value;
	}

	public QueryFilterInfo(String fieldName, String operator, Object value , Object secondValue) {
		this.fieldName = fieldName;
		this.operator = operator;
		this.fieldValue = Arrays.asList(value,secondValue);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getGroupName() {
		return groupName;
	}

	public QueryFilterInfo setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}

	public Class<?> getFieldType() {
		if(fieldType != null) {
			return fieldType;
		}
		if(StringUtils.isNotBlank(fieldTypeStr)) {
			try {
				return ClassUtils.getClass(fieldTypeStr);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return null;
			}
		}
		return fieldType;
	}

	public void setFieldType(Class<?> fieldType) {
		this.fieldType = fieldType;
	}

	public String getConnectOperator() {
		return connectOperator;
	}

	public QueryFilterInfo setConnectOperator(String connectOperator) {
		this.connectOperator = connectOperator;
		return this;
	}

	public String getFieldTypeStr() {
		return fieldTypeStr;
	}

	public void setFieldTypeStr(String fieldTypeStr) {
		this.fieldTypeStr = fieldTypeStr;
	}
	
}

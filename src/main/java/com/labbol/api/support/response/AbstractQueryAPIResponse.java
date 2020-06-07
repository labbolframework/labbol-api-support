/**
 * 
 */
package com.labbol.api.support.response;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.yelong.commons.util.Dates;
import org.yelong.http.response.HttpResponse;

import com.labbol.api.support.response.support.QueryResult;

/**
 * @author PengFei
 */
public class AbstractQueryAPIResponse<T> extends AbstractAPIResponse implements QueryAPIResponse<T>{

	private final QueryResult<T> queryResult;

	private boolean isConvert = false;

	static {
		//注册Date转换器
		ConvertUtils.register(new Converter() {
			@SuppressWarnings("unchecked")
			@Override
			public <T> T convert(Class<T> type, Object value) {
				if( null == value ) {
					return null;
				}
				if( !(value instanceof CharSequence)) {//只能转换字符串类型
					throw new RuntimeException("只能将字符串类型转换为java.util.Date类型");
				}
				try {
					return (T)DateUtils.parseDate((String)value, Dates.YYYY_MM_DD_HH_MM_SS,Dates.YYYY_MM_DD_BAR,Dates.YYYY_MM_DD_SLASH);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
	}

	@SuppressWarnings("unchecked")
	public AbstractQueryAPIResponse(HttpResponse httpResponse) {
		super(httpResponse);
		if(isSuccess()) {
			queryResult = gson.fromJson(httpResponse.getContentStr(),QueryResult.class);
		} else {
			queryResult = null;
		}
	}

	public QueryResult<T> getQueryResult() {
		return queryResult;
	}

	@Override
	public QueryResult<T> getQueryResultToBean() {
		if(!isConvert) {
			convertMapToBean();
		}
		return queryResult;
	}
	
	public Long getTotal() {
		return queryResult.getTotal();
	}

	public List<T> getRoot() {
		return getQueryResult().getRoot();
	}
	
	@Override
	public List<T> getRootToBean() {
		return getQueryResultToBean().getRoot();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void convertMapToBean(){
		if(!isConvert) {
			try {
				Class<?> beanType = getBeanType();
				//gson无法转换运行时的泛型。这里的List里面为Map类型 咱转换为pojo
				List<?> sourceRoot = queryResult.getRoot();
				List<T> root = new ArrayList<T>(sourceRoot.size());
				for (Object map : sourceRoot) {
					T bean = (T) beanType.newInstance();
					BeanUtils.populate(bean, (Map)map);
					root.add(bean);
				}
				queryResult.setRoot(root);
				isConvert = true;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getBeanType(){
		Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(getClass(), AbstractQueryAPIResponse.class);
		if(MapUtils.isNotEmpty(typeArguments)) {
			for (Entry<TypeVariable<?>, Type> entry : typeArguments.entrySet()) {
				if(entry.getKey().getName().contentEquals("T")) {
					return (Class<T>) entry.getValue();
				}
			}
		}
		throw new RuntimeException("未发现泛型model");
	}

}

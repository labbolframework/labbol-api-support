/**
 * 
 */
package com.labbol.api.support.request;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.yelong.http.request.HttpRequest;

import com.labbol.api.support.exception.APIRuleException;
import com.labbol.api.support.request.queryinfo.QueryFilterInfo;
import com.labbol.api.support.request.queryinfo.QueryInfo;
import com.labbol.api.support.request.queryinfo.QuerySortInfo;
import com.labbol.api.support.response.QueryAPIResponse;

/**
 * @author PengFei
 * @date 2020年3月5日上午8:49:03
 * @since 1.0
 */
public abstract class AbstractQueryAPIRequest <T extends QueryAPIResponse<?>> extends AbstractAPIRequest<T> implements QueryAPIRequest<T>{

	private QueryInfo queryInfo;
	
	public AbstractQueryAPIRequest(String apiMethodName, String method) {
		super(apiMethodName, method);
		queryInfo = new QueryInfo();
		httpRequest.setContentType("application/json");//默认为json请求
	}

	@Override
	public QueryAPIRequest<T> setQueryInfo(QueryInfo queryInfo) {
		Objects.requireNonNull(queryInfo);
		this.queryInfo = queryInfo;
		return this;
	}

	@Override
	public QueryInfo getQueryInfo() {
		return this.queryInfo;
	}

	@Override
	public QueryAPIRequest<T> startPage(int pageNum, int pageSize) {
		queryInfo.setPageNum(pageNum);
		queryInfo.setPageSize(pageSize);
		return null;
	}

	@Override
	public QueryAPIRequest<T> addQueryFilterInfo(QueryFilterInfo queryFilterInfo) {
		queryInfo.addFilter(queryFilterInfo);
		return this;
	}

	@Override
	public QueryAPIRequest<T> addQueryFilterInfos(List<QueryFilterInfo> queryFilterInfos) {
		for (QueryFilterInfo queryFilterInfo : queryFilterInfos) {
			addQueryFilterInfo(queryFilterInfo);
		}
		return this;
	}
	
	@Override
	public QueryAPIRequest<T> addQueryFilterInfo(String fieldName, String operator) {
		return addQueryFilterInfo(new QueryFilterInfo(fieldName, operator));
	}

	@Override
	public QueryAPIRequest<T> addQueryFilterInfo(String fieldName, String operator, Object value) {
		if( null == value || (value instanceof String && StringUtils.isEmpty((String)value))) {
			return this;
		}
		return addQueryFilterInfo(new QueryFilterInfo(fieldName, operator,value));
	}

	@Override
	public QueryAPIRequest<T> addQueryFilterInfo(String fieldName, String operator, Object value, Object secondValue) {
		if( null == value || null == secondValue) {
			return this;
		}
		return addQueryFilterInfo(new QueryFilterInfo(fieldName, operator,value,secondValue));
	}

	@Override
	public QueryAPIRequest<T> addQuerySortInfo(QuerySortInfo querySortInfo) {
		this.queryInfo.addSort(querySortInfo);
		return this;
	}

	@Override
	public QueryAPIRequest<T> addQuerySortInfos(List<QuerySortInfo> querySortInfos) {
		for (QuerySortInfo querySortInfo : querySortInfos) {
			addQuerySortInfo(querySortInfo);
		}
		return this;
	}
	
	@Override
	public QueryAPIRequest<T> addQuerySortInfo(String sortField, String direction) {
		this.queryInfo.addSort(sortField,direction);
		return this;
	}
	
	@Override
	public void check() throws APIRuleException {
		Integer pageNum = this.queryInfo.getPageNum();
		Integer pageSize = this.queryInfo.getPageSize();
		if( pageNum == null || pageSize == null ) {
			throw new APIRuleException("40","分页属性不能为空!请调用startPage方法!");
		}
	}
	
	@Override
	public HttpRequest getHttpRequest() throws IOException{
		Map<String,Object> map = new HashMap<>(1);
		map.put("queryInfo", queryInfo);
		gson.toJson(map);
		httpRequest.setContent(gson.toJson(map).getBytes(httpRequest.getCharset()));
		return httpRequest;
	}
	
}

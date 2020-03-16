/**
 * 
 */
package com.labbol.api.support.request;

import java.util.List;

import com.labbol.api.support.request.queryinfo.QueryFilterInfo;
import com.labbol.api.support.request.queryinfo.QueryInfo;
import com.labbol.api.support.request.queryinfo.QuerySortInfo;
import com.labbol.api.support.response.QueryAPIResponse;

/**
 * 查询的api 请求
 * 
 * 实现此接口的请求将不允许设置消息体。
 * 
 * 消息体由固定格式的json组成:
 * 
 * {
 * 	"queryInfo" : {
 * 		"filters":[],
 * 		"sorters" : [],
 * 		"pageNum" : 1,
 * 		"pageSize" : 20
 * }
 * }
 * 
 * @author PengFei
 * @date 2020年3月5日上午8:35:02
 * @since 1.0
 */
public interface QueryAPIRequest <T extends QueryAPIResponse<?>> extends APIRequest<T>{

	QueryAPIRequest<T> setQueryInfo(QueryInfo queryInfo);
	
	QueryInfo getQueryInfo();
	
	QueryAPIRequest<T> startPage(int pageNum , int pageSize);
	
	QueryAPIRequest<T> addQueryFilterInfo(QueryFilterInfo queryFilterInfo);
	
	QueryAPIRequest<T> addQueryFilterInfos(List<QueryFilterInfo> queryFilterInfos);
	
	/**
	 * 
	 * @param fieldName 字段
	 * @param operator
	 * @return
	 */
	QueryAPIRequest<T> addQueryFilterInfo(String fieldName , String operator);
	
	QueryAPIRequest<T> addQueryFilterInfo(String fieldName , String operator , Object value);
	
	QueryAPIRequest<T> addQueryFilterInfo(String fieldName , String operator , Object value , Object secondValue);
	
	QueryAPIRequest<T> addQuerySortInfo(QuerySortInfo querySortInfo);
	
	QueryAPIRequest<T> addQuerySortInfos(List<QuerySortInfo> querySortInfos);
	
	QueryAPIRequest<T> addQuerySortInfo(String sortField, String direction);
	
}

/**
 * 
 */
package com.labbol.api.support.response;

import java.util.List;

import com.labbol.api.support.response.support.QueryResult;

/**
 * 查询响应结果
 * 
 * @author PengFei
 * @param <T> result type
 */
public interface QueryAPIResponse<T> extends APIResponse{
	
	/**
	 * 获取查询的记录
	 * 
	 * @see #getRoot()
	 * @return 查询结果
	 */
	QueryResult<T> getQueryResult();

	/**
	 * 对于直接将数据返回给前台的操作请不要调用此方法。map转换为bean时间挺长的
	 * 
	 * @see #getRootToBean()
	 * @since 1.0.5
	 * @return 查询结果
	 */
	QueryResult<T> getQueryResultToBean();
	
	/**
	 * @return 记录数
	 */
	Long getTotal();

	/**
	 * 获取查询的记录信息。由于gson无法获取运行时泛型所以这个集合中存储的均为Map
	 * 如果要获取转换为泛型类型的集合请调用 {@link #getRootToBean()}
	 * 在首次调用 getRootToBean()后该方法将不会返回Map
	 * 
	 * @see #getRootToBean
	 * @return 记录信息
	 */
	List<T> getRoot();

	/**
	 * 获取记录且将map转换为指定的bean对象
	 * 
	 * @since 1.0.5
	 * @return bean集合
	 */
	List<T> getRootToBean();
	
}

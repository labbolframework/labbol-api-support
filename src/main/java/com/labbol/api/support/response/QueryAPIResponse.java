/**
 * 
 */
package com.labbol.api.support.response;

import java.util.List;

import com.labbol.api.support.response.support.QueryResult;

/**
 * @author PengFei
 * @date 2020年3月11日上午9:14:04
 * @since 1.0
 */
public interface QueryAPIResponse<T> extends APIResponse{

	QueryResult<T> getQueryResult();

	Long getTotal();

	List<T> getRoot();

}

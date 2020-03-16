/**
 * 
 */
package com.labbol.api.support.response;

import java.util.List;

import org.yelong.http.response.HttpResponse;

import com.labbol.api.support.response.support.QueryResult;

/**
 * @author PengFei
 * @date 2020年3月11日上午9:15:39
 * @since 1.0
 */
public class AbstractQueryAPIResponse<T> extends AbstractAPIResponse implements QueryAPIResponse<T>{

	private QueryResult<T> queryResult;

	@SuppressWarnings("unchecked")
	public AbstractQueryAPIResponse(HttpResponse httpResponse) {
		super(httpResponse);
		if(isSuccess()) {
			queryResult = gson.fromJson(httpResponse.getContentStr(),QueryResult.class);
		}
	}

	public QueryResult<T> getQueryResult() {
		return queryResult;
	}

	public Long getTotal() {
		return queryResult.getTotal();
	}

	public List<T> getRoot() {
		return queryResult.getRoot();
	}

}

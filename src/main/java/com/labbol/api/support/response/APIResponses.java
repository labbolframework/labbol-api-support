/**
 * 
 */
package com.labbol.api.support.response;

import java.util.List;

import org.yelong.http.response.HttpResponse;

import com.labbol.api.support.response.support.QueryResult;
import com.labbol.api.support.response.support.QueryResults;

/**
 * @author PengFei
 */
public final class APIResponses {
	
	private APIResponses() {}
	
	public static final QueryAPIResponse<?> EMPTY_QUERY_API_RESPONSE = new EmptyQueryAPIResponse<>();
	
	@SuppressWarnings("unchecked")
	public static <T> QueryAPIResponse<T> emptyQueryAPIResponse(){
		return (QueryAPIResponse<T>) EMPTY_QUERY_API_RESPONSE;
	}
	
	private static class EmptyQueryAPIResponse<T> implements QueryAPIResponse<T>{

		private final QueryResult<T> queryResult = QueryResults.emptyQueryResult();
		
		@Override
		public String getErrorCode() {
			return "200";
		}

		@Override
		public String getErrorMsg() {
			return null;
		}

		@Override
		public boolean isSuccess() {
			return true;
		}

		@Override
		public HttpResponse getHttpResponse() {
			return null;
		}

		@Override
		public QueryResult<T> getQueryResult() {
			return queryResult;
		}

		@Override
		public QueryResult<T> getQueryResultToBean() {
			return queryResult;
		}

		@Override
		public Long getTotal() {
			return queryResult.getTotal();
		}

		@Override
		public List<T> getRoot() {
			return queryResult.getRoot();
		}

		@Override
		public List<T> getRootToBean() {
			return queryResult.getRoot();
		}
		
	}
	
}

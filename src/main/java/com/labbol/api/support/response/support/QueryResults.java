/**
 * 
 */
package com.labbol.api.support.response.support;

import java.util.Collections;
import java.util.List;

/**
 * @author PengFei
 */
public final class QueryResults {
	
	private QueryResults() {}
	
	public static final QueryResult<?> EMPTY_QUERY_RESULT = new EmptyQueryResult<>();
	
	@SuppressWarnings("unchecked")
	public static <T> QueryResult<T> emptyQueryResult(){
		return (QueryResult<T>) EMPTY_QUERY_RESULT;
	}
	
	private static final class EmptyQueryResult<T> extends QueryResult<T> {
		
		private EmptyQueryResult() {
			super.setRoot(Collections.emptyList());
			super.setTotal(0L);
		}
		
		@Override
		public void setRoot(List<T> root) {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void setTotal(Long total) {
			throw new UnsupportedOperationException();
		}
		
	}
	
}

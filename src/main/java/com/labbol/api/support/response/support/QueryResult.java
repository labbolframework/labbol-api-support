/**
 * 
 */
package com.labbol.api.support.response.support;

import java.util.List;

/**
 * @author PengFei
 */
public class QueryResult <T>{
	
	private Long total;
	
	private List<T> root;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRoot() {
		return root;
	}

	public void setRoot(List<T> root) {
		this.root = root;
	}

}

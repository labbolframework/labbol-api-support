/**
 * 
 */
package com.labbol.api.support.response.support;

import java.util.List;

/**
 * @author PengFei
 * @date 2020年3月6日下午12:19:40
 * @since 1.0
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

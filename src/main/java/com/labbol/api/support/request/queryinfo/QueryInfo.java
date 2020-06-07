	/**
 * 
 */
package com.labbol.api.support.request.queryinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PengFei
 */
public class QueryInfo {

	private Integer pageNum;
	
	private Integer pageSize;
	
	private List<QueryFilterInfo> filters = new ArrayList<QueryFilterInfo>();

	private List<QuerySortInfo> sorters = new ArrayList<QuerySortInfo>();
	
	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<QueryFilterInfo> getFilters() {
		return filters;
	}

	public void setFilters(List<QueryFilterInfo> filters) {
		this.filters = filters;
	}

	public List<QuerySortInfo> getSorters() {
		return sorters;
	}
	
	/**
	 * 是否存在条件
	 * 
	 * @return <tt>true</tt> 存在条件
	 */
	public boolean isFilter() {
		return null != filters && !filters.isEmpty();
	}
	

	/**
	 * 设置排序信息。这会覆盖原有的排序信息
	 * 
	 * @param sorters 排序集合
	 */
	public void setSorters(List<QuerySortInfo> sorters) {
		this.sorters = sorters;
	}
	
	/**
	 * 是否存在排序
	 * 
	 * @return <tt>true</tt>存在排序
	 */
	public boolean isSort() {
		return null != sorters && !sorters.isEmpty();
	}
	
	/**
	 * 添加一个排序
	 * 
	 * @param querySortInfo 排序信息
	 */
	public void addSort(QuerySortInfo querySortInfo) {
		this.sorters.add(querySortInfo);
	}
	
	/**
	 * 添加一个排序
	 * 
	 * @param sortField 排序的列
	 * @param direction 方向（DESC、ASC）
	 */
	public void addSort(String sortField,String direction) {
		this.sorters.add(new QuerySortInfo(sortField,direction));
	}
	
	/**
	 * 添加一个排序条件
	 * 
	 * @param queryFilterInfo 过滤信息
	 */
	public void addFilter(QueryFilterInfo queryFilterInfo) {
		this.filters.add(queryFilterInfo);
	}
	
}

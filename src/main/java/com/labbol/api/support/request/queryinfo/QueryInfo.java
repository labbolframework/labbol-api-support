	/**
 * 
 */
package com.labbol.api.support.request.queryinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 彭飞
 * @date 2019年10月22日下午2:40:18
 * @version 1.2
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
	 * @date 2019年11月12日下午6:09:05
	 * @version 1.2
	 * @return <tt>true</tt> 存在条件
	 */
	public boolean isFilter() {
		return null != filters && !filters.isEmpty();
	}
	

	/**
	 * 设置排序信息。这会覆盖原有的排序信息
	 * @date 2019年11月12日下午5:32:38
	 * @version 1.2
	 * @param sorters
	 */
	public void setSorters(List<QuerySortInfo> sorters) {
		this.sorters = sorters;
	}
	
	/**
	 * 是否存在排序
	 * @author 彭飞
	 * @date 2019年10月23日下午12:02:52
	 * @version 1.0
	 * @return <tt>true</tt>存在排序
	 */
	public boolean isSort() {
		return null != sorters && !sorters.isEmpty();
	}
	
	/**
	 * 添加一个排序
	 * @author 彭飞
	 * @date 2019年10月23日下午12:04:20
	 * @version 1.0
	 * @param sortField
	 * @param direction
	 */
	public void addSort(QuerySortInfo querySortInfo) {
		this.sorters.add(querySortInfo);
	}
	
	/**
	 * 添加一个排序
	 * @author 彭飞
	 * @date 2019年10月23日下午12:04:20
	 * @version 1.0
	 * @param sortField
	 * @param direction
	 */
	public void addSort(String sortField,String direction) {
		this.sorters.add(new QuerySortInfo(sortField,direction));
	}
	
	/**
	 * 添加一个排序条件
	 * @param queryFilterInfo
	 */
	public void addFilter(QueryFilterInfo queryFilterInfo) {
		this.filters.add(queryFilterInfo);
	}
}

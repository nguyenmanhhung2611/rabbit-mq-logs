package vn.easycredit.domain;

import java.io.Serializable;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.domain.Sort.Direction;

import io.swagger.annotations.ApiModelProperty;

/**
 * SearchCondition
 * 
 * @author HienNT
 *
 */
public class SearchCondition implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "query string")
	@Valid
	@NotEmpty
	private String query;
	private int currentPage;
	private int pageSize;
	private String searchBy;
	private String sortBy;
	private Direction sort;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Direction getSort() {
		return sort;
	}

	public void setSort(Direction sort) {
		this.sort = sort;
	}

	public SearchCondition(String query, int currentPage, int pageSize, String searchBy, String sortBy,
			Direction sort) {
		super();
		this.query = query;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.searchBy = searchBy;
		this.sortBy = sortBy;
		this.sort = sort;
	}

	public SearchCondition() {
		super();
	}

}

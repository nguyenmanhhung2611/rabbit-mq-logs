package vn.easycredit.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author HienNT
 *
 */
public class HistoryCallListResponseBody implements Serializable{
	
	private static final long serialVersionUID = 1L;

	List<HistoryCallInfo> historyCallInfos;
	Pagination pagination;

	public List<HistoryCallInfo> getHistoryCallInfos() {
		return historyCallInfos;
	}

	public void setHistoryCallInfos(List<HistoryCallInfo> historyCallInfos) {
		this.historyCallInfos = historyCallInfos;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public HistoryCallListResponseBody(List<HistoryCallInfo> historyCallInfos, Pagination pagination) {
		super();
		this.historyCallInfos = historyCallInfos;
		this.pagination = pagination;
	}
}
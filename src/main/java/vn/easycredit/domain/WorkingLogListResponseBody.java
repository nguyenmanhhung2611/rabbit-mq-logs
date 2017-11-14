package vn.easycredit.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author HienNT
 *
 */
public class WorkingLogListResponseBody implements Serializable{
	
	private static final long serialVersionUID = 1L;

	List<WorkingLogInfo> workingLogInfos;
	Pagination pagination;

	public List<WorkingLogInfo> getWorkingLogInfos() {
		return workingLogInfos;
	}

	public void setWorkingLogInfos(List<WorkingLogInfo> workingLogInfos) {
		this.workingLogInfos = workingLogInfos;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public WorkingLogListResponseBody(List<WorkingLogInfo> workingLogInfos, Pagination pagination) {
		super();
		this.workingLogInfos = workingLogInfos;
		this.pagination = pagination;
	}
}
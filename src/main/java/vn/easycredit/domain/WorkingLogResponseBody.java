package vn.easycredit.domain;

import java.io.Serializable;

/**
 * 
 * @author HienNT
 *
 */
public class WorkingLogResponseBody implements Serializable{
	
	private static final long serialVersionUID = 1L;

	WorkingLogInfo workingLogInfo;

	public WorkingLogInfo getWorkingLogInfo() {
		return workingLogInfo;
	}

	public void setWorkingLogInfo(WorkingLogInfo workingLogInfo) {
		this.workingLogInfo = workingLogInfo;
	}

	public WorkingLogResponseBody(WorkingLogInfo workingLogInfo) {
		super();
		this.workingLogInfo = workingLogInfo;
	}

	public WorkingLogResponseBody() {
		super();
	}
}
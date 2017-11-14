package vn.easycredit.domain;

import java.io.Serializable;

/**
 * 
 * @author HienNT
 *
 */
public class HistoryCallResponseBody implements Serializable{
	
	private static final long serialVersionUID = 1L;

	HistoryCallInfo historyCallInfo;

	public HistoryCallInfo getHistoryCallInfo() {
		return historyCallInfo;
	}

	public void setHistoryCallInfo(HistoryCallInfo historyCallInfo) {
		this.historyCallInfo = historyCallInfo;
	}

	public HistoryCallResponseBody(HistoryCallInfo historyCallInfo) {
		super();
		this.historyCallInfo = historyCallInfo;
	}

	public HistoryCallResponseBody() {
		super();
	}
}
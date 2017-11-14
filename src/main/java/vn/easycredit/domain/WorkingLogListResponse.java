package vn.easycredit.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author HienNT
 *
 */
public class WorkingLogListResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "HTTP Status")
	private Integer status;
	private WorkingLogListResponseBody body;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public WorkingLogListResponseBody getBody() {
		return body;
	}

	public void setBody(WorkingLogListResponseBody body) {
		this.body = body;
	}

	public WorkingLogListResponse(Integer status, WorkingLogListResponseBody body) {
		super();
		this.status = status;
		this.body = body;
	}
}

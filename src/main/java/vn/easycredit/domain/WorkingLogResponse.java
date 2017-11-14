package vn.easycredit.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author HienNT
 *
 */
public class WorkingLogResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "HTTP Status")
	private Integer status;

	private WorkingLogResponseBody body;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public WorkingLogResponseBody getBody() {
		return body;
	}

	public void setBody(WorkingLogResponseBody body) {
		this.body = body;
	}

	public WorkingLogResponse(Integer status, WorkingLogResponseBody body) {
		super();
		this.status = status;
		this.body = body;
	}
}

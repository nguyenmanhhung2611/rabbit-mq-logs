package vn.easycredit.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author HienNT
 *
 */
public class HistoryCallListResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "HTTP Status")
	private Integer status;
	private HistoryCallListResponseBody body;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public HistoryCallListResponseBody getBody() {
		return body;
	}

	public void setBody(HistoryCallListResponseBody body) {
		this.body = body;
	}

	public HistoryCallListResponse(Integer status, HistoryCallListResponseBody body) {
		super();
		this.status = status;
		this.body = body;
	}

	public HistoryCallListResponse() {
		super();
	}
}

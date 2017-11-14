package vn.easycredit.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author HienNT
 *
 */
public class HistoryCallResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "HTTP Status")
	private Integer status;

	private HistoryCallResponseBody body;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public HistoryCallResponseBody getBody() {
		return body;
	}

	public void setBody(HistoryCallResponseBody body) {
		this.body = body;
	}

	public HistoryCallResponse(Integer status, HistoryCallResponseBody body) {
		super();
		this.status = status;
		this.body = body;
	}
}

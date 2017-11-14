package vn.easycredit.domain;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author HienNT
 *
 */
public class HistoryCallListRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull
	private SearchCondition body;

	public SearchCondition getBody() {
		return body;
	}

	public void setBody(SearchCondition body) {
		this.body = body;
	}

	public HistoryCallListRequest(SearchCondition body) {
		super();
		this.body = body;
	}

	public HistoryCallListRequest() {
		super();
	}
}

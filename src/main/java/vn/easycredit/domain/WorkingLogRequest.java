package vn.easycredit.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author HienNT
 *
 */
public class WorkingLogRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String inflowApi;
	private String requestHeader;
	private String requestBody;
	private String fromIp;
	private String toIp;
	private String status;
	private Integer numberOfRetry;
	private Date createdOn;
	private Date lastModifiedOn;
	private String logError;

	public String getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(String requestHeader) {
		this.requestHeader = requestHeader;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getInflowApi() {
		return inflowApi;
	}

	public void setInflowApi(String inflowApi) {
		this.inflowApi = inflowApi;
	}

	public String getFromIp() {
		return fromIp;
	}

	public void setFromIp(String fromIp) {
		this.fromIp = fromIp;
	}

	public String getToIp() {
		return toIp;
	}

	public void setToIp(String toIp) {
		this.toIp = toIp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNumberOfRetry() {
		return numberOfRetry;
	}

	public void setNumberOfRetry(Integer numberOfRetry) {
		this.numberOfRetry = numberOfRetry;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public String getLogError() {
		return logError;
	}

	public void setLogError(String logError) {
		this.logError = logError;
	}

	public WorkingLogRequest(String inflowApi, String requestHeader, String requestBody, String fromIp, String toIp,
			String status, Integer numberOfRetry, Date createdOn, Date lastModifiedOn, String logError) {
		super();
		this.inflowApi = inflowApi;
		this.requestHeader = requestHeader;
		this.requestBody = requestBody;
		this.fromIp = fromIp;
		this.toIp = toIp;
		this.status = status;
		this.numberOfRetry = numberOfRetry;
		this.createdOn = createdOn;
		this.lastModifiedOn = lastModifiedOn;
		this.logError = logError;
	}

	public WorkingLogRequest() {
		super();
	}

}

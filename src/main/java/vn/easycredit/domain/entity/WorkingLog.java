package vn.easycredit.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * 
 * @author HienNT
 *
 */
@Entity
@Table(name = "working_log")
public class WorkingLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	private String id;

	@Column(name = "inflow_api")
	private String inflowApi;

	@Column(name = "request_header")
	@Type(type = "text")
	private String requestHeader;

	@Column(name = "request_body")
	@Type(type = "text")
	private String requestBody;

	@Column(name = "from_ip")
	private String fromIp;

	@Column(name = "to_ip")
	private String toIp;

	@Column(name = "status")
	private String status;

	@Column(name = "number_of_retry")
	private Integer numberOfRetry;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "last_modified_on")
	private Date lastModifiedOn;

	@Column(name = "log_error")
	@Type(type = "text")
	private String logError;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public WorkingLog(String id, String inflowApi, String requestHeader, String requestBody, String fromIp, String toIp,
			String status, Integer numberOfRetry, Date createdOn, Date lastModifiedOn, String logError) {
		super();
		this.id = id;
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

	public WorkingLog() {
		super();
	}

}

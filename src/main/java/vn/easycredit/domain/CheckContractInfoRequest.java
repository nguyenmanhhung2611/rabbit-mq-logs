package vn.easycredit.domain;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CheckContractInfoRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotNull
	private String authenKey;

	@Valid
	@NotNull
	private String partnerCode;

	@Valid
	@NotNull
	private String keyCode;

	@Valid
	@NotNull
	private String clientId;

	@Valid
	@NotNull
	private String contractNumber;

	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getAuthenKey() {
		return authenKey;
	}

	public void setAuthenKey(String authenKey) {
		this.authenKey = authenKey;
	}

	public CheckContractInfoRequest(String authenKey, String partnerCode, String keyCode, String clientId,
			String contractNumber) {
		super();
		this.authenKey = authenKey;
		this.partnerCode = partnerCode;
		this.keyCode = keyCode;
		this.clientId = clientId;
		this.contractNumber = contractNumber;
	}

	public CheckContractInfoRequest() {
		super();
	}
}

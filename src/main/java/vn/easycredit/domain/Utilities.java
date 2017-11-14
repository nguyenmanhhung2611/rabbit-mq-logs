package vn.easycredit.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Value;

/**
 * 
 * @author HienNT
 *
 */
@Value
public class Utilities implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static Date getTime(){
		Date now = new Date();
		return now;
	}
	
    public enum DataStatus {
    	PENDING("pending", "pending"),
        SUCCESS("success", "succes"),
        FAIL("fail", "fail");
    	
    	private String statusCode;
		private String statusType;
		
		private DataStatus(String statusCode, String statusType) {
			this.statusCode = statusCode;
			this.statusType = statusType;
		}
		public String getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}
		public String getStatusType() {
			return statusType;
		}
		public void setStatusType(String statusType) {
			this.statusType = statusType;
		}
    }
}

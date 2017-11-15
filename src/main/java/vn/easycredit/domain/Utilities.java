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
}

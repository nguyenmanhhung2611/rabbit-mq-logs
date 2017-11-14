package vn.easycredit.common.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HienNT
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class BaseResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final Integer SUCCESS = 1;
    public static final Integer FAILURE = 0;
    private InfoGroup infoGroup;
}

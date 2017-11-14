package vn.easycredit.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

/**
 * 
 * @author HienNT
 */

@Value
public class ErrorResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "HTTP Status")
    private Integer status;

    private ErrorInfo error;
}

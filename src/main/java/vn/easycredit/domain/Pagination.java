package vn.easycredit.domain;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

/**
 * Pagination object useful for long list, multiple pages response
 * 
 * @author HienNT
 *
 */
@Value
public class Pagination implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "current page number, index from 1 to totalPageCount value")
    int pageNum;

    @ApiModelProperty(value = "the constant means number of items per page")
    int pageSize;

    @ApiModelProperty(value = "Total item count of current page")
    int totalPageCount;

    @ApiModelProperty(value = "number of items from all pages")
    long totalItemCount;
}

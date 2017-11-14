package vn.easycredit.constant;

import java.io.Serializable;

/**
 * @author HienNT
 *
 */

public final class SwaggerConstant implements Serializable{
	
	private static final long serialVersionUID = 1L;

    public static final String SWAGGER_SUCCESS_MESSAGE = "Success";
    public static final String SWAGGER_INTERNALERROR_MESSAGE = "Internal Server Error";
    public static final String SWAGGER_BADREQUEST_MESSAGE = "Bad Request";
    
    public static final int PAGE_SIZE = 3;
    public static final int RESPONSE_SUCCESS = 200;

    private SwaggerConstant() {
    }
}

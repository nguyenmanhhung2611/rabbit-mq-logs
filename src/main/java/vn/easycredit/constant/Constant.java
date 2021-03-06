package vn.easycredit.constant;

import java.io.Serializable;

/**
 * @author HienNT
 *
 */

public final class Constant implements Serializable{
	
	private static final long serialVersionUID = 1L;

    public static final String SWAGGER_SUCCESS_MESSAGE = "Success";
    public static final String SWAGGER_INTERNALERROR_MESSAGE = "Internal Server Error";
    public static final String SWAGGER_BADREQUEST_MESSAGE = "Bad Request";
    
    public static final int PAGE_SIZE = 3;
    public static final int RESPONSE_SUCCESS = 200;
    
	public static final String LOGS_STATUS_INSERT_WORKING_LOG = "insert_working_log";
	public static final String LOGS_STATUS_UPDATE_WORKING_LOG = "update_working_log";
	public static final String LOGS_STATUS_INSERT_HISTORY = "insert_history";

    private Constant() {
    }
}

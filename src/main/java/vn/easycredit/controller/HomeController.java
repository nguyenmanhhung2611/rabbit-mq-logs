package vn.easycredit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import vn.easycredit.constant.Constant;
import vn.easycredit.domain.CheckContractInfoRequest;
import vn.easycredit.domain.DisbursementInfoResponse;
import vn.easycredit.domain.ErrorResponse;
import vn.easycredit.domain.HistoryCallListRequest;
import vn.easycredit.domain.HistoryCallListResponse;
import vn.easycredit.domain.HistoryCallRequest;
import vn.easycredit.domain.HistoryCallResponse;
import vn.easycredit.domain.WorkingLogListRequest;
import vn.easycredit.domain.WorkingLogListResponse;
import vn.easycredit.domain.WorkingLogRequest;
import vn.easycredit.domain.WorkingLogResponse;
import vn.easycredit.service.CheckContractInfoService;
import vn.easycredit.service.HistoryCallService;
import vn.easycredit.service.WorkingLogService;

/**
 * Controller
 * 
 * @author HienNT
 */

@RestController
public class HomeController {

	@Autowired
	private WorkingLogService workingLogService;

	@Autowired
	private HistoryCallService historyCallService;
	
	@Autowired
	private CheckContractInfoService contractInfoService;

	@ApiOperation(value = "Listing up working_log", notes = "Listing up working_log best matched with search conditions.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SWAGGER_SUCCESS_MESSAGE, response = WorkingLogListResponse.class),
			@ApiResponse(code = 400, message = Constant.SWAGGER_BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.SWAGGER_INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/list-log", method = RequestMethod.POST)
	public WorkingLogListResponse hotelList(@Valid @RequestBody WorkingLogListRequest request) {
		return new WorkingLogListResponse(Constant.RESPONSE_SUCCESS,
				workingLogService.getWorkingLog(request.getBody()));
	}

	@ApiOperation(value = "Add working_log", notes = "Add working_log.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SWAGGER_SUCCESS_MESSAGE, response = WorkingLogListResponse.class),
			@ApiResponse(code = 400, message = Constant.SWAGGER_BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.SWAGGER_INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/add-log", method = RequestMethod.POST)
	public WorkingLogResponse addWorkingLog(@Valid @RequestBody WorkingLogRequest request) throws Throwable {
		return new WorkingLogResponse(Constant.RESPONSE_SUCCESS, workingLogService.addWorkingLog(request));
	}
	
	@ApiOperation(value = "delete working_log", notes = "delete working_log.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SWAGGER_SUCCESS_MESSAGE, response = WorkingLogListResponse.class),
			@ApiResponse(code = 400, message = Constant.SWAGGER_BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.SWAGGER_INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/delete-log", method = RequestMethod.POST)
	public void deleteWorkingLog(@Valid String logId) throws Throwable {
		workingLogService.deleteWorkingLog(logId);
	}
	
	
	@ApiOperation(value = "update working_log", notes = "update working_log.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SWAGGER_SUCCESS_MESSAGE, response = WorkingLogListResponse.class),
			@ApiResponse(code = 400, message = Constant.SWAGGER_BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.SWAGGER_INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/update-log", method = RequestMethod.POST)
	public WorkingLogResponse updateWorkingLog(@Valid @RequestBody WorkingLogRequest request) throws Throwable {
		return new WorkingLogResponse(Constant.RESPONSE_SUCCESS, workingLogService.updateWorkingLog(request));
	}

	@ApiOperation(value = "Listing up history_call", notes = "Listing up history_call best matched with search conditions.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SWAGGER_SUCCESS_MESSAGE, response = WorkingLogListResponse.class),
			@ApiResponse(code = 400, message = Constant.SWAGGER_BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.SWAGGER_INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/list-history", method = RequestMethod.POST)
	public HistoryCallListResponse historyList(@Valid @RequestBody HistoryCallListRequest request) {
		return new HistoryCallListResponse(Constant.RESPONSE_SUCCESS, historyCallService.getListHistoryCall(request.getBody()));
	}

	@ApiOperation(value = "Add history_call", notes = "Add history_call.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SWAGGER_SUCCESS_MESSAGE, response = WorkingLogListResponse.class),
			@ApiResponse(code = 400, message = Constant.SWAGGER_BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.SWAGGER_INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/add-history-call", method = RequestMethod.POST)
	public HistoryCallResponse addHistoryCall(@Valid @RequestBody HistoryCallRequest request) throws Throwable {
		return new HistoryCallResponse(Constant.RESPONSE_SUCCESS,
				historyCallService.addHistoryCall(request));
	}
	
	
	
	//TODO test API IMX
	@ApiOperation(value = "Get Contract Info", notes = "Get Contract Info.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = Constant.SWAGGER_SUCCESS_MESSAGE, response = WorkingLogListResponse.class),
			@ApiResponse(code = 400, message = Constant.SWAGGER_BADREQUEST_MESSAGE, response = ErrorResponse.class),
			@ApiResponse(code = 500, message = Constant.SWAGGER_INTERNALERROR_MESSAGE, response = ErrorResponse.class) })
	@RequestMapping(value = "/contract-info", method = RequestMethod.POST)
	public DisbursementInfoResponse getContractInfo(@Valid @RequestBody CheckContractInfoRequest request) throws Throwable {
		return new DisbursementInfoResponse(Constant.RESPONSE_SUCCESS, contractInfoService.getContractInfo(request));
	}
}

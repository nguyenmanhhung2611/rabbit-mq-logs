package vn.easycredit.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.constant.NormalError;
import vn.easycredit.constant.Constant;
import vn.easycredit.controller.CustomException;
import vn.easycredit.domain.ErrorInfo.InvalidParameter;
import vn.easycredit.domain.ErrorInfo.Type;
import vn.easycredit.domain.Pagination;
import vn.easycredit.domain.SearchCondition;
import vn.easycredit.domain.Utilities;
import vn.easycredit.domain.WorkingLogInfo;
import vn.easycredit.domain.WorkingLogListResponseBody;
import vn.easycredit.domain.WorkingLogRequest;
import vn.easycredit.domain.WorkingLogResponseBody;
import vn.easycredit.domain.entity.WorkingLog;
import vn.easycredit.repository.WorkingLogRepository;

/**
 * 
 * @author HienNT
 *
 */
@Slf4j
@Service
@Transactional
public class WorkingLogService implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private WorkingLogRepository workingLogReposiroty;

	/**
	 * get list working log
	 * 
	 * @param searchCondition
	 * @return
	 */
	public WorkingLogListResponseBody getWorkingLog(SearchCondition searchCondition) {
		Page<WorkingLog> page = getListLogs(searchCondition);

		int totalPage = page.getTotalPages();
		long totalItem = page.getTotalElements();

		List<WorkingLogInfo> listWorkingLogInfo = new ArrayList<WorkingLogInfo>();
		for (WorkingLog workingLog : page.getContent()) {
			WorkingLogInfo info = objectMapper(workingLog);
			listWorkingLogInfo.add(info);
		}
		
		int pageSize = (searchCondition.getPageSize() != 0) ? searchCondition.getPageSize() : Constant.PAGE_SIZE;
		int currentPage = (searchCondition.getCurrentPage() == 0) ? searchCondition.getCurrentPage()+1 : searchCondition.getCurrentPage();
		return new WorkingLogListResponseBody(listWorkingLogInfo,
				new Pagination(currentPage, pageSize, totalPage, totalItem));
	}

	/**
	 * get list working log
	 * 
	 * @param searchCondition
	 * @return
	 */
	public Page<WorkingLog> getListLogs(SearchCondition searchCondition) {
		int currentPage = (searchCondition.getCurrentPage() != 0) ? searchCondition.getCurrentPage()-1 : searchCondition.getCurrentPage();
		int pageSize = (searchCondition.getPageSize() != 0) ? searchCondition.getPageSize() : Constant.PAGE_SIZE;
			
		PageRequest pageRequest = new PageRequest(currentPage, pageSize, searchCondition.getSort(), searchCondition.getSortBy());
		return workingLogReposiroty.findAll(pageRequest);
	}
	
	/**
     * add working_log
     * 
     * @param info
     * @return
     */
    public WorkingLogResponseBody addWorkingLog(WorkingLogRequest info) throws CustomException{
		WorkingLog workingLog = saveWorkingLogDB(info);
		if(workingLog != null){
			WorkingLogInfo workingLogInfo = objectMapper(workingLog);
			return new WorkingLogResponseBody(workingLogInfo);
    	}
		log.error("can't insert workingLog", info);
		throw new CustomException(NormalError.SYSTEM_FAIL, Type.TRANSACTION, new InvalidParameter("workingLogInfo", "insert fail"));
    }
    
    /**
     * update working_log
     * 
     * @param info
     * @return
     */
    public WorkingLogResponseBody updateWorkingLog(WorkingLogRequest info) throws CustomException{
		WorkingLog workingLog = updateWorkingLogDB(info);
		if(workingLog != null){
			WorkingLogInfo workingLogInfo = objectMapper(workingLog);
			return new WorkingLogResponseBody(workingLogInfo);
    	}
		log.error("can't insert workingLog", info);
		throw new CustomException(NormalError.SYSTEM_FAIL, Type.TRANSACTION, new InvalidParameter("workingLogInfo", "insert fail"));
    }
    
    /**
     * add working_log
     * 
     * @param info
     * @return
     */
    public void deleteWorkingLog(String logId) throws CustomException{
		WorkingLog workingLog = workingLogReposiroty.findById(logId);
		if(workingLog != null){
			workingLogReposiroty.delete(workingLog);
    	}
		log.error("can't delete workingLog", logId);
		throw new CustomException(NormalError.SYSTEM_FAIL, Type.TRANSACTION, new InvalidParameter("workingLogInfo", "delete fail"));
    }
    
    /**
     * save working_log into DB
     * @param info
     * @return
     */
    public WorkingLog saveWorkingLogDB(WorkingLogRequest info) throws CustomException{
    	WorkingLog workingLog = new WorkingLog();
    	workingLog.setId(info.getUuid());
    	workingLog.setInflowApi(info.getInflowApi());
    	workingLog.setRequestHeader(info.getRequestHeader());
    	workingLog.setRequestBody(info.getRequestBody());
    	workingLog.setFromIp(info.getFromIp());
    	workingLog.setToIp(info.getToIp());
    	workingLog.setStatus(info.getStatus());
    	workingLog.setNumberOfRetry(info.getNumberOfRetry());
    	workingLog.setCreatedOn(Utilities.getTime());
    	workingLog.setLastModifiedOn(null);  
    	workingLog.setLogError(info.getLogError());
    	
    	WorkingLog workingLogRepo = workingLogReposiroty.save(workingLog);
    	
    	if (workingLogRepo != null){
    		return workingLogRepo;
    	} else 
	    	log.error("can't insert", workingLogRepo);
			throw new CustomException(NormalError.SYSTEM_FAIL, Type.TRANSACTION, new InvalidParameter("hotelInfo", "Insert fail"));
    }
    
    
    /**
     * update working_log into DB
     * @param info
     * @return
     */
    public WorkingLog updateWorkingLogDB(WorkingLogRequest info) throws CustomException{
    	WorkingLog workingLog = new WorkingLog();
    	
    	workingLog.setStatus(info.getStatus());
    	workingLog.setNumberOfRetry(info.getNumberOfRetry());
    	workingLog.setLastModifiedOn(Utilities.getTime());  
    	workingLog.setLogError(info.getLogError());
    	
    	WorkingLog workingLogRepo = workingLogReposiroty.save(workingLog);
    	
    	if (workingLogRepo != null){
    		return workingLogRepo;
    	} else 
	    	log.error("can't insert", workingLogRepo);
			throw new CustomException(NormalError.SYSTEM_FAIL, Type.TRANSACTION, new InvalidParameter("hotelInfo", "Insert fail"));
    }
    
	/**
	 * mapper object workingLog=> workingLogInfo
	 * 
	 * @param workingLog
	 * @return
	 */
	public WorkingLogInfo objectMapper(WorkingLog workingLog) {
		WorkingLogInfo info = new WorkingLogInfo();
		info.setId(workingLog.getId());
		info.setInflowApi(workingLog.getInflowApi());
		info.setRequestHeader(workingLog.getRequestHeader());
		info.setRequestBody(workingLog.getRequestBody());
		info.setFromIp(workingLog.getFromIp());
		info.setToIp(workingLog.getToIp());
		info.setStatus(workingLog.getStatus());
		info.setNumberOfRetry(workingLog.getNumberOfRetry());
		info.setCreatedOn(workingLog.getCreatedOn());
		info.setLastModifiedOn(workingLog.getLastModifiedOn());
		info.setLogError(workingLog.getLogError());
		
		return info;
	}
}

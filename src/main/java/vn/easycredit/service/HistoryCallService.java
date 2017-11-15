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
import vn.easycredit.constant.Constant;
import vn.easycredit.constant.NormalError;
import vn.easycredit.controller.CustomException;
import vn.easycredit.domain.ErrorInfo.InvalidParameter;
import vn.easycredit.domain.ErrorInfo.Type;
import vn.easycredit.domain.HistoryCallInfo;
import vn.easycredit.domain.HistoryCallListResponseBody;
import vn.easycredit.domain.HistoryCallRequest;
import vn.easycredit.domain.HistoryCallResponseBody;
import vn.easycredit.domain.Pagination;
import vn.easycredit.domain.SearchCondition;
import vn.easycredit.domain.Utilities;
import vn.easycredit.domain.entity.HistoryCall;
import vn.easycredit.repository.HistoryCallRepository;

/**
 * 
 * @author HienNT
 *
 */
@Slf4j
@Service
@Transactional
public class HistoryCallService implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Autowired
	private HistoryCallRepository historyRepo;
    
    /**
     * get list history_call
     * @param searchCondition
     * @return
     */
    public HistoryCallListResponseBody getListHistoryCall(SearchCondition searchCondition) {
		Page<HistoryCall> page = getHistoryCall(searchCondition);    	
    	
    	int totalPage = page.getTotalPages(); 
    	long totalItem = page.getTotalElements();
    	
        List<HistoryCallInfo> listHistoryCallInfo = new ArrayList<HistoryCallInfo>();
        for(HistoryCall histotyCall : page.getContent()){
        	HistoryCallInfo info = objectHistoryCallMapper(histotyCall);
        	listHistoryCallInfo.add(info);
        }
        int pageSize = (searchCondition.getPageSize() != 0) ? searchCondition.getPageSize() : Constant.PAGE_SIZE;
        int currentPage = (searchCondition.getCurrentPage() == 0) ? searchCondition.getCurrentPage()+1 : searchCondition.getCurrentPage();
        return new HistoryCallListResponseBody(listHistoryCallInfo, new Pagination(currentPage, pageSize, totalPage, totalItem));
    }
    
    /**
     * get list history_call
     * @param searchCondition
     * @return
     */
    public Page<HistoryCall> getHistoryCall(SearchCondition searchCondition) {
    	int currentPage = (searchCondition.getCurrentPage() != 0) ? searchCondition.getCurrentPage()-1 : searchCondition.getCurrentPage();
		int pageSize = (searchCondition.getPageSize() != 0) ? searchCondition.getPageSize() : Constant.PAGE_SIZE;
			
		PageRequest pageRequest = new PageRequest(currentPage, pageSize, searchCondition.getSort(), searchCondition.getSortBy());
    	return historyRepo.findAll(pageRequest);
    }
    
    /**
     * add working_log
     * 
     * @param info
     * @return
     */
    public HistoryCallResponseBody addHistoryCall(HistoryCallRequest info) throws CustomException{
    	HistoryCall historyCall = saveHistoryCallDB(info);
		if(historyCall != null){
			HistoryCallInfo historyCallInfo = objectHistoryCallMapper(historyCall);
			return new HistoryCallResponseBody(historyCallInfo);
    	}
		log.error("can't insert workingLog", info);
		throw new CustomException(NormalError.SYSTEM_FAIL, Type.TRANSACTION, new InvalidParameter("workingLogInfo", "insert fail"));
    }
    
    /**
     * update save history_call DB
     * @param info
     * @return
     */
    public HistoryCall saveHistoryCallDB(HistoryCallRequest info) throws CustomException{
    	HistoryCall historyCall = new HistoryCall();
    	historyCall.setId(info.getUuid());
    	historyCall.setInflowApi(info.getInflowApi());
    	historyCall.setRequestHeader(info.getRequestHeader());
    	historyCall.setRequestBody(info.getRequestBody());
    	historyCall.setFromIp(info.getFromIp());
    	historyCall.setToIp(info.getToIp());
    	historyCall.setStatus(info.getStatus());
    	historyCall.setCreatedOn(Utilities.getTime());
    	historyCall.setLastModifiedOn(null);  
    	historyCall.setLogError(info.getLogError());
    	
    	HistoryCall historyCallRepo = historyRepo.save(historyCall);
    	
    	if (historyCallRepo != null){
    		return historyCallRepo;
    	} else 
	    	log.error("can't insert", historyCallRepo);
			throw new CustomException(NormalError.SYSTEM_FAIL, Type.TRANSACTION, new InvalidParameter("hotelInfo", "Insert fail"));
    }
    
    
    
    
    /**
     * mapper object history_call=> HitoryCallInfo
     * @param historyCall
     * @return
     */
    public HistoryCallInfo objectHistoryCallMapper(HistoryCall historyCall){
    	HistoryCallInfo info = new HistoryCallInfo();
    	info.setId(historyCall.getId());
    	info.setInflowApi(historyCall.getInflowApi());
		info.setRequestHeader(historyCall.getRequestHeader());
		info.setRequestBody(historyCall.getRequestBody());
		info.setFromIp(historyCall.getFromIp());
		info.setToIp(historyCall.getToIp());
		info.setStatus(historyCall.getStatus());
		info.setCreatedOn(historyCall.getCreatedOn());
		info.setLastModifiedOn(historyCall.getLastModifiedOn());
		info.setLogError(historyCall.getLogError());
    	
    	return info;
    }
}

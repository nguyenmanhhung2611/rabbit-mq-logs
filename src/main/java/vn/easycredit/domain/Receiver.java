package vn.easycredit.domain;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import vn.easycredit.constant.Constant;
import vn.easycredit.controller.HomeController;

@Component
public class Receiver implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	HomeController controller;

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String request) throws Throwable {
        
        @SuppressWarnings("rawtypes")
		LogsInfoRequest logRequest = convertJsontoObject(request);
        
        if (logRequest.getLogStatus().equals(Constant.LOGS_STATUS_INSERT_WORKING_LOG)){
        	WorkingLogRequest workingLogrequest = new WorkingLogRequest();
            workingLogrequest.setFromIp(logRequest.getIp());
            workingLogrequest.setUuid(logRequest.getUuid());
            workingLogrequest.setInflowApi(logRequest.getInflowApi());
            workingLogrequest.setRequestHeader(logRequest.getHeader().toString());
            workingLogrequest.setRequestBody(logRequest.getBody().toString());
            workingLogrequest.setStatus(logRequest.getStatus());
            
            controller.addWorkingLog(workingLogrequest);
        }else if (logRequest.getLogStatus().equals(Constant.LOGS_STATUS_INSERT_HISTORY)){
        	HistoryCallRequest historyCallRequest = new HistoryCallRequest();
        	historyCallRequest.setFromIp(logRequest.getIp());
        	historyCallRequest.setUuid(logRequest.getUuid());
        	historyCallRequest.setInflowApi(logRequest.getInflowApi());
        	historyCallRequest.setRequestHeader(logRequest.getHeader().toString());
        	historyCallRequest.setRequestBody(logRequest.getBody().toString());
        	historyCallRequest.setStatus(logRequest.getStatus());
        	
        	controller.addHistoryCall(historyCallRequest);
        	controller.deleteWorkingLog(logRequest.getUuid());
        }
        else if(logRequest.getLogStatus().equals(Constant.LOGS_STATUS_UPDATE_WORKING_LOG)) {
        	WorkingLogRequest workingLogrequest = new WorkingLogRequest();
            workingLogrequest.setFromIp(logRequest.getIp());
            workingLogrequest.setUuid(logRequest.getUuid());
            workingLogrequest.setInflowApi(logRequest.getInflowApi());
            workingLogrequest.setRequestHeader(logRequest.getHeader().toString());
            workingLogrequest.setRequestBody(logRequest.getBody().toString());
            workingLogrequest.setStatus(logRequest.getStatus());
            
            controller.updateWorkingLog(workingLogrequest);
        }
        
        
        
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

	private LogsInfoRequest<?> convertJsontoObject(String req){
    	Gson gson = new Gson();
		LogsInfoRequest<?> log = gson.fromJson(req, LogsInfoRequest.class);
    	return log;
    }
}

package vn.easycredit.domain;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

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
        
        WorkingLogRequest workingLogrequest = new WorkingLogRequest();
        workingLogrequest.setInflowApi(logRequest.getInflowApi());
        workingLogrequest.setRequestHeader(logRequest.getHeader().toString());
        workingLogrequest.setRequestBody(logRequest.getBody().toString());
        
        controller.addWorkingLog(workingLogrequest);
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

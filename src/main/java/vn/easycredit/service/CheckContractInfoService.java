package vn.easycredit.service;

import java.io.Serializable;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import vn.easycredit.domain.CheckContractInfoRequest;
import vn.easycredit.domain.DisbursementInfoResponse.DisbursementInfoResponseBody;
import vn.easycredit.domain.Utilities;

/**
 * 
 * @author HienNT
 *
 */
@Slf4j
@Service
public class CheckContractInfoService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
     * get contract info from IMX api.
     * 
     * @param request
     * @return
     * @throws ImxContractNotFoundException
     */
	public DisbursementInfoResponseBody getContractInfo(CheckContractInfoRequest request){
		
		DisbursementInfoResponseBody body = new DisbursementInfoResponseBody();
		body.setContractNumber("Contract Number");
		body.setClientFullName("full name");
		body.setClientIdNumber("ID1234");
		body.setIssuedDate(Utilities.getTime());
		body.setIssuedPlace("place");
		body.setMoneyAmount( new Double("25.34"));
		body.setResponseCode(200);
		body.setResponseMessage("OK. Generic successful execution.");
		
		return body;		
	}

}

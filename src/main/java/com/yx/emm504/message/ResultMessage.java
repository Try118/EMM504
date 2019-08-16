package com.yx.emm504.message;

import lombok.Data;

@Data
public class ResultMessage {
	
	public String message;
	public String status;
	
	public ResultMessage(String status,String message) {
		this.message = message;
		this.status = status;
	}
	
}

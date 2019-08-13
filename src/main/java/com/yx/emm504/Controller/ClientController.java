package com.yx.emm504.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.client.service.IClientService;

@RequestMapping("/client")
@RestController
public class ClientController {
	
	@Autowired
	private IClientService cs;
	
	@RequestMapping("/getListByAll")
	public List<ClientModel> getListByAll() throws Exception{
		List<ClientModel> list=cs.getListByAll();
		return list;
	}
	
}

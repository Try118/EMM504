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
	
	@RequestMapping("/create")
	public void create(ClientModel cm) throws Exception{
		/*
		ClientModel cm=new ClientModel();
		
		cm.setClient_id("2");
		cm.setIdentify_id("44054841648688");
		cm.setProduct_id("13");
		*/
		cs.create(cm);
	}
}

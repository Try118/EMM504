package com.yx.emm504.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.client.service.IClientService;
import com.yx.emm504.message.ResultMessage;

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
	
	@RequestMapping("/getListByAllWithPage")
	public ResultMessage<ClientModel> getListByAllWithPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page) throws Exception{
		ResultMessage<ClientModel> rm=new ResultMessage<ClientModel>("OK","取得客户列表成功");
		rm.setCount(cs.getCountByAll());
		rm.setPageCount(cs.getPageCountByAll(rows));
		rm.setList(cs.getListByAllWithPage(rows, page));
		rm.setRows(rows);
		rm.setPage(page);
		//System.out.println(cs.getPageCountByAll(rows));
		return rm;
	}
	
	@RequestMapping("/create")
	public ResultMessage create(ClientModel cm) throws Exception{		
		cs.create(cm);
		return new ResultMessage("OK","注册成功");
	}
}

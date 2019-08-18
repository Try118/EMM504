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
	public ResultMessage<ClientModel> getListByAllWithPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page,@RequestParam(required = false,defaultValue ="")String zip_code,@RequestParam(required = false,defaultValue ="")String client_property) throws Exception{
		ResultMessage<ClientModel> rm=new ResultMessage<ClientModel>("OK","取得客户列表成功");
		rm.setCount(cs.getCountByAll(zip_code,client_property));
		rm.setPageCount(cs.getPageCountByAll(rows,zip_code,client_property));
		rm.setList(cs.getListByAllWithPage(rows, page,zip_code,client_property));
		rm.setRows(rows);
		rm.setPage(page);
		return rm;
	}
	
	@RequestMapping("/create")
	public ResultMessage<ClientModel> create(ClientModel cm) throws Exception{	
		cs.create(cm);
		return new ResultMessage<ClientModel>("OK","注册成功");
	}
	
	@RequestMapping("/delete")
	public ResultMessage<ClientModel> delete(ClientModel cm) throws Exception{
		cs.delete(cm);
		return new ResultMessage<ClientModel>("OK","删除成功");
	}
	
	@RequestMapping("/getByClientId")
	public ResultMessage<ClientModel> getByClientId(String client_id) throws Exception{
		ResultMessage<ClientModel> rm=new ResultMessage<ClientModel>("OK","获取客户信息成功");
		rm.setModel(cs.getByClientId(client_id));
		return rm;
	}
	
	@RequestMapping("/update")
	public ResultMessage<ClientModel> update(ClientModel cm) throws Exception{
		cs.update(cm);
		return new ResultMessage<ClientModel>("OK","修改成功");
	}
	
	
	@RequestMapping("/getListByAddition")
	public ResultMessage<ClientModel> getListByAddition(ClientModel cm) throws Exception{
		ResultMessage<ClientModel> rm=new ResultMessage<ClientModel>("OK","修改成功");
		rm.setList(cs.getListByAddition(cm));
		return rm;
	}
	

}

package com.yx.emm504.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.Model.maintain.MaintainInfo;
import com.yx.emm504.Model.product.ProductInfo;
import com.yx.emm504.message.ResultMessage;
import com.yx.emm504.operate.service.IOperateService;

@RequestMapping("/operate")
@RestController
public class OperateController {

	@Autowired
	private IOperateService operateService;
	
	@RequestMapping("/clientlist")
	public ResultMessage<ClientModel> selectListWithClient() throws Exception{
		ResultMessage<ClientModel> resultMessage = new ResultMessage<ClientModel>("OK","获取客户信息成功");
		resultMessage.setList(operateService.selectListWithClient());
		return resultMessage;
	}
	
	@RequestMapping("/productlist")
	public ResultMessage<ProductInfo> selectListWithProduct() throws Exception{
		ResultMessage<ProductInfo> resultMessage = new ResultMessage<ProductInfo>("OK","获取库存信息成功");
		resultMessage.setList(operateService.selectListWithProduct());
		return resultMessage;
	}
	
	@RequestMapping("/maintainlist")
	public ResultMessage<MaintainInfo> selectListWithMaintain() throws Exception{
		ResultMessage<MaintainInfo> resultMessage = new ResultMessage<MaintainInfo>("OK","获取维护信息成功");
		resultMessage.setList(operateService.selectListWithMaintain());
		return resultMessage;
	}
}

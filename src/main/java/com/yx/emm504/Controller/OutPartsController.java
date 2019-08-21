package com.yx.emm504.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yx.emm504.Model.OutPartsModel;
import com.yx.emm504.message.ResultMessage;
import com.yx.emm504.outParts.service.IOutPartsService;

@RequestMapping(value = "/outparts")
@RestController
public class OutPartsController {
	
	@Autowired
	private IOutPartsService outPartsService;

	@RequestMapping("/getlist")
	public ResultMessage<OutPartsModel> getListByAll() throws Exception{
		ResultMessage<OutPartsModel> rm = new ResultMessage<OutPartsModel>("OK","获取出库部件信息成功");
		rm.setList(outPartsService.getListByAll());
		return rm;
	}
	
	@RequestMapping("/create")
	public ResultMessage<OutPartsModel> create(OutPartsModel outPartsModel) throws Exception{
		ResultMessage<OutPartsModel> rm = new ResultMessage<OutPartsModel>("OK","创建出库部件信息成功");
		outPartsService.create(outPartsModel);
		return rm;
	}

	@RequestMapping("/delete")
	public ResultMessage<OutPartsModel> delete(OutPartsModel outPartsModel) throws Exception{
		ResultMessage<OutPartsModel> rm = new ResultMessage<OutPartsModel>("OK","删除出库部件信息成功");
		outPartsService.delete(outPartsModel);
		return rm;
	}
	
	@RequestMapping("/update")
	public ResultMessage<OutPartsModel> update(OutPartsModel outPartsModel) throws Exception{
		ResultMessage<OutPartsModel> rm = new ResultMessage<OutPartsModel>("OK","更新出库部件信息成功");
		outPartsService.update(outPartsModel);
		return rm;
	}
	
	@RequestMapping("/getlistbyname")
	public ResultMessage<OutPartsModel> getOutPartsByName(String parts_name) throws Exception{
		ResultMessage<OutPartsModel> rm = new ResultMessage<OutPartsModel>("OK","查找出库部件信息成功");
		outPartsService.getOutPartsByName(parts_name);
		return rm;
	}
}

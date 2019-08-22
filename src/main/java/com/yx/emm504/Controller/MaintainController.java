package com.yx.emm504.Controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.yx.emm504.Model.maintain.MaintainInfo;
import com.yx.emm504.maintain.service.MaintainService;
import com.yx.emm504.message.ResultMessage;

@RequestMapping("/Maintain")
@RestController
public class MaintainController {
	
	@Autowired
	private MaintainService Mtain;
	
	@RequestMapping("/add")
	public ResultMessage<MaintainInfo> insertMaintainInfo(MaintainInfo record){
		Mtain.insert(record);
		return new ResultMessage<MaintainInfo>("OK","添加成功");
	}
	
	
	@RequestMapping("/select")
	public ResultMessage<MaintainInfo> selectMaintainInfo(String id){
		MaintainInfo mtain = Mtain.selectById(id);
		ResultMessage<MaintainInfo> resultMessage = new ResultMessage<MaintainInfo>("OK","查询成功");
		resultMessage.setModel(mtain);
		return resultMessage;
	}
	
	@RequestMapping("/selectByAll")
	public ResultMessage<MaintainInfo> selectByAllMaintainInfo(){
		List<MaintainInfo> list = Mtain.selectListByAll();
		ResultMessage<MaintainInfo> resultMessage = new ResultMessage<MaintainInfo>("OK","查询添加成功");
		resultMessage.setList(list);
		return resultMessage;
	}
	
	@RequestMapping("/delete")
	public ResultMessage<MaintainInfo> deleteMaintainInfo(String id){
		Mtain.delete(id);
		return new ResultMessage<MaintainInfo>("OK","删除成功");
	}
	
	@RequestMapping("/update")
	public ResultMessage<MaintainInfo> updateMaintainInfo(MaintainInfo record){
		Mtain.update(record);
		return new ResultMessage<MaintainInfo>("OK","更新成功");
	}
	
	@RequestMapping("/getListByAllWithPage")
	public ResultMessage<MaintainInfo> getListByAllWitPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page,
			@RequestParam(required = false) String maintainStatus,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date startDate,@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(required = false) Date endDate){
		
		ResultMessage<MaintainInfo> result=new ResultMessage<MaintainInfo>("OK","取得角色列表分页模式成功");
		result.setCount(Mtain.getCountByAll(maintainStatus, startDate, endDate));
		result.setPageCount(Mtain.getPageCountByAll(rows,maintainStatus,startDate,endDate));
		result.setList(Mtain.getListByAllWithPage(rows, page,maintainStatus,startDate,endDate));
		result.setPage(page);
		result.setRows(rows);
		
		return result;
	}
}

package com.yx.emm504.maintain.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yx.emm504.Model.maintain.MaintainInfo;
import com.yx.emm504.maintain.mapper.MaintainInfoMapper;
import com.yx.emm504.maintain.service.MaintainService;

@Service
public class MaintainServiceImpl implements MaintainService{

	@Autowired
	public MaintainInfoMapper Mtain=null;
	@Override
	public void delete(String productId) {
		Mtain.delete(productId);
	
	}

	@Override
	public void insert(MaintainInfo record) {
		Mtain.insert(record);
	
	}

	@Override
	public MaintainInfo selectById(String productId) {
	
		return Mtain.selectById(productId);
	}

	@Override
	public List<MaintainInfo> selectListByAll() {
		
		return Mtain.selectListByAll();
	}

	@Override
	public void update(MaintainInfo record) {
		Mtain.update(record);
	}

	@Override
	public int getCountByAll(String maintainStatus,Date startDate,Date endDate){
		return Mtain.selectCountByAll(maintainStatus,startDate,endDate);
	}

	@Override
	public int getPageCountByAll(int rows,String maintainStatus,Date startDate,Date endDate){
		int pageCount = 0;
		int count = this.getCountByAll(maintainStatus,startDate,endDate);
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = (count / rows) + 1;
		}
		return pageCount;
	}
	
	public List<MaintainInfo> getListByAllWithPage(int rows,int page,String productId, Date startDate, Date endDate){
		return Mtain.selectListByAllWithPage(rows*(page-1), rows,productId,startDate,endDate);
	}

	

}

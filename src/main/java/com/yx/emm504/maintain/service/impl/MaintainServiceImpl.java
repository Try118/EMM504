package com.yx.emm504.maintain.service.impl;


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
	public int getCountByAll(){
		return Mtain.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows){
		int pageCount = 0;
		int count = this.getCountByAll();
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = (count / rows) + 1;
		}
		return pageCount;
	}
	
	@Override
	public List<MaintainInfo> getListByAllWithPage(int rows, int page){
		return Mtain.selectListByAllWithPage(rows*(page-1), rows);
	}

}

package com.yx.emm504.maintain.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
	public ArrayList<MaintainInfo> selectListByAll() {
		
		return Mtain.selectListByAll();
	}

	@Override
	public void update(MaintainInfo record) {
		Mtain.update(record);
	}

}

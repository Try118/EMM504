package com.yx.emm504.operate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.Model.maintain.MaintainInfo;
import com.yx.emm504.Model.product.ProductInfo;
import com.yx.emm504.operate.mapper.IOperateMapper;
import com.yx.emm504.operate.service.IOperateService;

@Service
@Primary
public class OperateServiceImpl implements IOperateService {

	@Autowired
	private IOperateMapper operateMapper;
	
	@Override
	public List<ClientModel> selectListWithClient() throws Exception {
		List<ClientModel> list = operateMapper.selectListWithClient();
		return list;
	}

	@Override
	public List<ProductInfo> selectListWithProduct() throws Exception {
		List<ProductInfo> list = operateMapper.selectListWithProduct();
		return list;
	}

	@Override
	public List<MaintainInfo> selectListWithMaintain() throws Exception {
		List<MaintainInfo> list = operateMapper.selectListWithMaintain();
		return list;
	}

}

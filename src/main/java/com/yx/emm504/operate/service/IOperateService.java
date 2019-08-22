package com.yx.emm504.operate.service;

import java.util.List;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.Model.maintain.MaintainInfo;
import com.yx.emm504.Model.product.ProductInfo;

public interface IOperateService {

	public List<ClientModel> selectListWithClient() throws Exception;
	
	public List<ProductInfo> selectListWithProduct() throws Exception;
	
	public List<MaintainInfo> selectListWithMaintain() throws Exception;
}

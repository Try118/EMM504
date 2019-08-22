package com.yx.emm504.operate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.Model.maintain.MaintainInfo;
import com.yx.emm504.Model.product.ProductInfo;

@Mapper
public interface IOperateMapper {

	//查询客户信息
	public List<ClientModel> selectListWithClient() throws Exception;
	//查询库存
	public List<ProductInfo> selectListWithProduct() throws Exception;
	//查询维护信息
	public List<MaintainInfo> selectListWithMaintain() throws Exception;
	//查询结算信息
	
}

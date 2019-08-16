package com.yx.emm504.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yx.emm504.Model.ClientModel;

@Mapper
public interface IClientMapper {
	
	public List<ClientModel> selectListByAll() throws Exception;
	
	public void add(ClientModel cm) throws Exception;
	
}

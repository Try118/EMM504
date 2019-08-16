package com.yx.emm504.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yx.emm504.Model.ClientModel;

@Mapper
public interface IClientMapper {
	
	public List<ClientModel> selectListByAll() throws Exception;
	
	public void create(ClientModel cm) throws Exception;
	
	public int selectCountByAll() throws Exception;
	
	public List<ClientModel> selectListByAllWithPage(@Param("start")int start,@Param("rows")int rows) throws Exception;
	
	public void delete(ClientModel cm) throws Exception;
}

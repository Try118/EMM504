package com.yx.emm504.client.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yx.emm504.Model.ClientModel;

@Mapper
public interface IClientMapper {
	
	public List<ClientModel> selectListByAll() throws Exception;
	
	public void create(ClientModel cm) throws Exception;
	
	public int selectCountByAll(String zip_code,String client_property) throws Exception;
	
	public List<ClientModel> selectListByAllWithPage(@Param("start")int start,@Param("rows")int rows,@Param("zip_code")String zip_code,@Param("client_property")String client_property) throws Exception;
	
	public void delete(ClientModel cm) throws Exception;
	
	public ClientModel getByClientId(String client_id) throws Exception;
	
	public void modify(ClientModel cm) throws Exception;
	
	public List<ClientModel> selectListByAddition(@Param("client_property")String client_property,@Param("zip_code")String zip_code) throws Exception;

	public List<ClientModel> selectZipCode() throws Exception;
}	

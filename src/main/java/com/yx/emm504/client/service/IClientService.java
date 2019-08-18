package com.yx.emm504.client.service;

import java.util.List;

import com.yx.emm504.Model.ClientModel;


public interface IClientService {

	public List<ClientModel> getListByAll() throws Exception;
	
	public void create(ClientModel cm) throws Exception;
	
	public int getCountByAll(String zip_code,String client_property) throws Exception;
	
	public int getPageCountByAll(int rows,String zip_code,String client_property) throws Exception;
	
	public List<ClientModel> getListByAllWithPage(int rows,int page,String zip_code,String client_property) throws Exception;
	
	public void delete(ClientModel cm) throws Exception;
	
	public ClientModel getByClientId(String client_id) throws Exception;
	
	public void update(ClientModel cm) throws Exception;
	
	public List<ClientModel> getListByAddition(ClientModel cm) throws Exception;
	
	public List<ClientModel> getZipCode() throws Exception;
}

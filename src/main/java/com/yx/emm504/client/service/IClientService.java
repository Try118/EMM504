package com.yx.emm504.client.service;

import java.util.List;

import com.yx.emm504.Model.ClientModel;


public interface IClientService {

	public List<ClientModel> getListByAll() throws Exception;
	
	public void create(ClientModel cm) throws Exception;
	
	public int getCountByAll() throws Exception;
	
	public int getPageCountByAll(int rows) throws Exception;
	
	public List<ClientModel> getListByAllWithPage(int rows,int page) throws Exception;
}

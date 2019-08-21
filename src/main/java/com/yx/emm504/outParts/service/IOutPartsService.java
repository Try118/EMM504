package com.yx.emm504.outParts.service;

import java.util.List;

import com.yx.emm504.Model.OutPartsModel;

public interface IOutPartsService {

	public List<OutPartsModel> getListByAll() throws Exception;
	
	public void create(OutPartsModel outPartsModel) throws Exception;
	
	public void delete(OutPartsModel outPartsModel) throws Exception;
	
	public void update(OutPartsModel outPartsModel) throws Exception;
	
	public OutPartsModel getOutPartsByName(String parts_name) throws Exception;
}

package com.yx.emm504.outParts.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yx.emm504.Model.OutPartsModel;

@Mapper
public interface IOutPartsMapper {

	public List<OutPartsModel> selectListByAll() throws Exception;
	
	public void create(OutPartsModel outPartsModel) throws Exception;
	
	public void delete(OutPartsModel outPartsModel) throws Exception;
	
	public void modify(OutPartsModel outPartsModel) throws Exception;
	
	public OutPartsModel getOutPartsByName(String parts_name) throws Exception;
}

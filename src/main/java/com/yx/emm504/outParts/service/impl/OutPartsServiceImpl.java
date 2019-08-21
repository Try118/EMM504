package com.yx.emm504.outParts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yx.emm504.Model.OutPartsModel;
import com.yx.emm504.outParts.mapper.IOutPartsMapper;
import com.yx.emm504.outParts.service.IOutPartsService;

@Service
@Primary
public class OutPartsServiceImpl implements IOutPartsService {

	@Autowired
	private IOutPartsMapper outPartsMapper;
	
	@Override
	public List<OutPartsModel> getListByAll() throws Exception {
		List<OutPartsModel> list = outPartsMapper.selectListByAll();
		return list;
	}

	@Override
	public void create(OutPartsModel outPartsModel) throws Exception {
		outPartsMapper.create(outPartsModel);
	}

	@Override
	public void delete(OutPartsModel outPartsModel) throws Exception {
		outPartsMapper.delete(outPartsModel);
	}

	@Override
	public void update(OutPartsModel outPartsModel) throws Exception {
		outPartsMapper.modify(outPartsModel);
	}

	@Override
	public OutPartsModel getOutPartsByName(String parts_name) throws Exception {
		OutPartsModel outPartsModel = outPartsMapper.getOutPartsByName(parts_name);
		return outPartsModel;
	}

}

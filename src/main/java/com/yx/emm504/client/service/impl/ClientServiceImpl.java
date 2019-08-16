package com.yx.emm504.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.client.mapper.IClientMapper;
//import com.yx.emm504.client.service.IClientService2;
import com.yx.emm504.client.service.IClientService;

@Service
@Primary
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientMapper cd;

	@Override
	public List<ClientModel> getListByAll() throws Exception {
		List<ClientModel> list = cd.selectListByAll();
		return list;
	}

	@Override
	public void create(ClientModel cm) throws Exception {
		cd.create(cm);
	}

	@Override
	public int getCountByAll() throws Exception {
		return cd.selectCountByAll();
	}

	@Override
	public int getPageCountByAll(int rows) throws Exception {
		int pageCount = 0;
		int count = this.getCountByAll();
		if (count % rows == 0) {
			pageCount = count / rows;
		} else {
			pageCount = (count / rows) + 1;
		}
		return pageCount;
	}

	@Override
	public List<ClientModel> getListByAllWithPage(int rows, int page) throws Exception {
		return cd.selectListByAllWithPage(rows*(page-1), rows);
	}

	@Override
	public void delete(ClientModel cm) throws Exception {
		cd.delete(cm);
	}
	
}

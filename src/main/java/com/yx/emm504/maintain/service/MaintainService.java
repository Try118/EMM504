package com.yx.emm504.maintain.service;

import java.util.ArrayList;
import java.util.List;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.Model.maintain.MaintainInfo;

public interface MaintainService {
	public void delete(String productId);

    public void insert(MaintainInfo record);

    public MaintainInfo selectById(String productId);

    public List<MaintainInfo> selectListByAll();
    
    public void update(MaintainInfo record);
	
	public int getCountByAll();
	
	public int getPageCountByAll(int rows);
	
	public List<MaintainInfo> getListByAllWithPage(int rows,int page);
}

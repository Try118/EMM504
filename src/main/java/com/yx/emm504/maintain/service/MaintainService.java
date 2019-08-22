package com.yx.emm504.maintain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.yx.emm504.Model.ClientModel;
import com.yx.emm504.Model.maintain.MaintainInfo;

public interface MaintainService {
	public void delete(String productId);

    public void insert(MaintainInfo record);

    public MaintainInfo selectById(String productId);

    public List<MaintainInfo> selectListByAll();
    
    public void update(MaintainInfo record);
	
	public int getCountByAll(String maintainStatus, Date startDate, Date endDate);
	
	public int getPageCountByAll(int rows, String maintainStatus, Date startDate, Date endDate);
	
	public List<MaintainInfo> getListByAllWithPage(int rows,int page,String productId, Date startDate, Date endDate);
	

}

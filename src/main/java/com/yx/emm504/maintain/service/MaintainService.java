package com.yx.emm504.maintain.service;

import java.util.ArrayList;

import com.yx.emm504.Model.maintain.MaintainInfo;

public interface MaintainService {
	void delete(String productId);

    void insert(MaintainInfo record);

    MaintainInfo selectById(String productId);

    ArrayList<MaintainInfo> selectListByAll();
    
    void update(MaintainInfo record);
}

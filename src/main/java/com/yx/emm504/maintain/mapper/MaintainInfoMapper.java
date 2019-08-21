package com.yx.emm504.maintain.mapper;

import com.yx.emm504.Model.maintain.MaintainInfo;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaintainInfoMapper {
    int delete(String productId) throws Exception;;

    int insert(MaintainInfo record) throws Exception;

    MaintainInfo selectById(String productId);

    ArrayList<MaintainInfo> selectListByAll();
    
    int update(MaintainInfo record);
}
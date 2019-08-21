package com.yx.emm504.maintain.mapper;

import com.yx.emm504.Model.maintain.MaintainInfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MaintainInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(MaintainInfo record);

    int insertSelective(MaintainInfo record);

    MaintainInfo selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(MaintainInfo record);

    int updateByPrimaryKey(MaintainInfo record);
}
package com.yx.emm504.maintain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yx.emm504.Model.maintain.MaintainInfo;

@Mapper
public interface MaintainInfoMapper {
    public int delete(String productId) ;

    public int insert(MaintainInfo record) ;

    public MaintainInfo selectById(String productId);
    
    public int update(MaintainInfo record);
    
    public int selectCountByAll();
    
    public List<MaintainInfo> selectListByAll();
    
    public List<MaintainInfo> selectListByAllWithPage(@Param("start")int start,@Param("rows")int rows);
}
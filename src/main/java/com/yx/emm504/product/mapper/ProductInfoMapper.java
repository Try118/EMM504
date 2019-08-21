package com.yx.emm504.product.mapper;

import com.yx.emm504.Model.product.ProductInfo;
import com.yx.emm504.Model.product.ProductToClient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    ProductInfo selectByPrimaryKey(String productId);

    ProductToClient selectProductToClient(String clientId);

    List<ProductInfo> selectListByAll();

    List<ProductInfo> selectListByAddition(String loginStatus);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);
}
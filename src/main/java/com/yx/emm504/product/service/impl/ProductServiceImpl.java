package com.yx.emm504.product.service.impl;

import com.yx.emm504.Model.product.ProductInfo;
import com.yx.emm504.message.ResultMessage;
import com.yx.emm504.product.mapper.ProductInfoMapper;
import com.yx.emm504.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoMapper productInfoMapper = null;

    @Override
    public Boolean AddProductNew(ProductInfo productInfo) {
        int i = productInfoMapper.insertSelective(productInfo);
        return i > 0 ? true : false;
    }

    @Override
    public List<ProductInfo> getListByAll() {
        List<ProductInfo> productInfos = productInfoMapper.selectListByAll();
        return productInfos;
    }

    @Override
    public List<ProductInfo> GetProductNew(String productId) {
        ProductInfo productInfo = productInfoMapper.selectByPrimaryKey(productId);
        return null;
    }

    @Override
    public Boolean DeleteProductNew(ProductInfo productInfo) {
        int i = productInfoMapper.deleteByPrimaryKey(productInfo.getProductId());
        return i > 0 ? true : false;
    }

    @Override
    public Boolean UpdateProductNew(ProductInfo productInfo) {
        int i = productInfoMapper.updateByPrimaryKeySelective(productInfo);
        return i > 0 ? true : false;
    }

    @Override
    public List<ProductInfo> getListByAllWithPage(int rows, int page, String zip_code, String Product_property) {
        return null;
    }

    @Override
    public int getCountByAll(String zip_code, String Product_property) {
        return 0;
    }

    @Override
    public int getPageCountByAll(int rows, String zip_code, String Product_property) {
        return 0;
    }
}

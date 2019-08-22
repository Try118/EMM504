package com.yx.emm504.product.service.impl;

import com.yx.emm504.Model.product.ProductInfo;
import com.yx.emm504.message.ResultMessage;
import com.yx.emm504.product.mapper.ProductInfoMapper;
import com.yx.emm504.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<ProductInfo> productInfos = new ArrayList<>();
        productInfos.add(productInfo);
        return productInfos;
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
    public List<ProductInfo> getListByAllWithPage(int rows, int page, String loginStatus) {
        return productInfoMapper.selectListByAllWithPage(rows*(page-1), rows,loginStatus);
    }

    @Override
    public int getCountByAll(String loginStatus) {
        return productInfoMapper.selectCountByAll(loginStatus);
    }

    @Override
    public int getPageCountByAll(int rows, String loginStatus) {
        int pageCount = 0;
        int count = this.getCountByAll(loginStatus);
        if (count % rows == 0) {
            pageCount = count / rows;
        } else {
            pageCount = (count / rows) + 1;
        }
        return pageCount;
    }

}

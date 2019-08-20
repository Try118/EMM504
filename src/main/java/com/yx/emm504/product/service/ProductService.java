package com.yx.emm504.product.service;

import com.yx.emm504.Model.product.ProductInfo;
import com.yx.emm504.message.ResultMessage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService{
    Boolean AddProductNew(ProductInfo productInfo);

    List<ProductInfo> getListByAll();

    List<ProductInfo> GetProductNew(String productId);

    Boolean DeleteProductNew(ProductInfo productInfo);

    Boolean UpdateProductNew(ProductInfo productInfo);

    List<ProductInfo> getListByAllWithPage(int rows, int page, String zip_code, String Product_property);

    int getCountByAll(String zip_code,String Product_property);

    int getPageCountByAll(int rows,String zip_code,String Product_property);
}

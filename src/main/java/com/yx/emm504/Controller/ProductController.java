package com.yx.emm504.Controller;

import com.yx.emm504.Model.product.ProductInfo;
import com.yx.emm504.Model.product.ProductToClient;
import com.yx.emm504.message.ResultMessage;
import com.yx.emm504.product.mapper.ProductInfoMapper;
import com.yx.emm504.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("设备保修模块")
@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    ProductService productService = null;

    @Autowired
    ProductInfoMapper productInfoMapper = null;

    @GetMapping("/test")
    public ProductToClient test(String clientId){
        ProductToClient productToClient = productInfoMapper.selectProductToClient(clientId);
        return productToClient;
    }

    @ApiOperation("添加保修信息")
    @PostMapping("/news")
    public ResultMessage<ProductInfo> AddProductNew(ProductInfo productInfo){
        productService.AddProductNew(productInfo);
        return new ResultMessage<ProductInfo>("OK","添加成功");
    }

    @ApiOperation("获取用户报修信息")
    @GetMapping("/news")
    public ResultMessage<ProductInfo> GetProductNew(String productId){
        List<ProductInfo> productInfos = null;
        if (productId==null){
            productInfos = productService.getListByAll();
        }else{
            productInfos = productService.GetProductNew(productId);
        }
        ResultMessage<ProductInfo> productInfoResultMessage = new ResultMessage<>("OK", "获取成功");
        productInfoResultMessage.setList(productInfos);
        return productInfoResultMessage;
    }

    @ApiOperation("删除用户报修信息")
    @DeleteMapping("/news")
    public ResultMessage<ProductInfo> DeleteProductNew(ProductInfo productInfo){
        Boolean aBoolean = productService.DeleteProductNew(productInfo);
        if (aBoolean) return new ResultMessage<ProductInfo>("OK","删除成功");
        return new ResultMessage<ProductInfo>("Error","删除失败");
    }

    @ApiOperation("更改用户报修信息")
    @PutMapping("/news")
    public ResultMessage<ProductInfo> UpdateProductNew(ProductInfo productInfo){
        Boolean aBoolean = productService.UpdateProductNew(productInfo);
        if (aBoolean) return new ResultMessage<ProductInfo>("OK","修改成功");
        return new ResultMessage<ProductInfo>("Error","修改失败");
    }
}

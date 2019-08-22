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

//    @Autowired
//    ProductInfoMapper productInfoMapper = null;
//
//    @GetMapping("/test")
//    public List<ProductInfo> test(int start,int rows,String loginStatus){
//        List<ProductInfo> productInfos = productInfoMapper.selectListByAllWithPage(start, rows, loginStatus);
//        return productInfos;
//    }

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

    @ApiOperation("获取翻页中同一页的数据")
    @GetMapping("/news/condition")
    public ResultMessage<ProductInfo> getListByAllWithPage(@RequestParam(required = false,defaultValue ="10") int rows,@RequestParam(required = false,defaultValue = "1") int page,@RequestParam(required = false,defaultValue ="")String loginStatus){
        ResultMessage<ProductInfo> rm=new ResultMessage<ProductInfo>("OK","取得用户保修列表成功");
        rm.setCount(productService.getCountByAll(loginStatus));
        rm.setPageCount(productService.getPageCountByAll(rows,loginStatus));
        rm.setList(productService.getListByAllWithPage(rows, page,loginStatus));
        rm.setRows(rows);
        rm.setPage(page);
        return rm;
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

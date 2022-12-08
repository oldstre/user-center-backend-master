package com.wry.usercenter.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wry.usercenter.common.BaseResponse;
import com.wry.usercenter.common.ErrorCode;
import com.wry.usercenter.common.ResultUtils;
import com.wry.usercenter.exception.BusinessException;
import com.wry.usercenter.model.domain.Product;
import com.wry.usercenter.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;


    @GetMapping("/search")
    public BaseResponse<List<Product>> searchProducts(String productName, HttpServletRequest request) {

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(productName)) {
            queryWrapper.like("productName", productName);
        }
        List<Product> productList = productService.list(queryWrapper);
        //System.out.println(productList);
//        List<Product> list = productList.stream().map(user -> productLis).collect(Collectors.toList());
        return ResultUtils.success(productList);
    }

    /**
     * 条件查询，按商品名
     * @param productName
     * @return
     */
    @GetMapping("/one")
    public BaseResponse<Product> searchProductByName(@RequestParam("productName") String productName){
//        LambdaQueryWrapper<Product> lambdaQueryWrapper= new LambdaQueryWrapper<>();
//        if(StringUtils.isNotBlank(productName)){
//            lambdaQueryWrapper.eq(Product::getProductName,productName);
//        }
//        Product product = productService.getOne(lambdaQueryWrapper);
        Product product = productService.searchByName(productName);
        return ResultUtils.success(product);

    }

    /**
     * 条件查询，按商品类型--多值
     * @param productType
     * @return
     */
    @GetMapping("/batch")
    public BaseResponse<List<Product>> searchProductsByType(@RequestParam("productType") String productType){
        LambdaQueryWrapper<Product> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(productType)){
            lambdaQueryWrapper.eq(Product::getProductType,productType);
        }
        List<Product> productList = productService.list(lambdaQueryWrapper);
        return ResultUtils.success(productList);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteProduct(@RequestParam("id") int id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        System.out.println(id);
        boolean b = productService.removeById(id);
        return ResultUtils.success(b);
    }

    @PostMapping("/add")
    public BaseResponse<Boolean> createProduct(@RequestBody Product product){
        if(product==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = productService.save(product);
        return ResultUtils.success(b);

    }

    @PutMapping("update")
    public BaseResponse<Boolean> updateProduct(@RequestBody Product product){
        if(product==null){
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        boolean b = productService.updateById(product);
        return ResultUtils.success(b);
    }

}

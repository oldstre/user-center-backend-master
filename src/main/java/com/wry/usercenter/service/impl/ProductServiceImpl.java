package com.wry.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wry.usercenter.mapper.ProductMapper;
import com.wry.usercenter.model.domain.Product;
import com.wry.usercenter.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author HUAWEI
* @description 针对表【product】的数据库操作Service实现
* @createDate 2022-12-05 15:02:41
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService {

    @Resource
    private ProductMapper productMapper;


    public Product searchByName(String productName){
        QueryWrapper<Product> queryWrapper =new QueryWrapper<>();
        if(StringUtils.isNotBlank(productName)){
            queryWrapper.eq("productName",productName);
        }
        Product product = productMapper.selectOne(queryWrapper);
        return product;

    }
}





package com.wry.usercenter.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.usercenter.model.domain.Product;
import com.wry.usercenter.model.domain.User;


import java.util.List;

/**
* @author HUAWEI
* @description 针对表【product】的数据库操作Service
* @createDate 2022-12-05 15:02:41
*/
public interface ProductService extends IService<Product> {

     Product searchByName(String productName);
}

package com.wry.usercenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wry.usercenter.model.domain.Component;
import com.wry.usercenter.model.domain.Product;


/**
* @author HUAWEI
* @description 针对表【component】的数据库操作Service
* @createDate 2022-12-08 13:19:13
*/
public interface ComponentService extends IService<Component> {


    Component searchByName(String componentName);

}

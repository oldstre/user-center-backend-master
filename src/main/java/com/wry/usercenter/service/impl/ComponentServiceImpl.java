package com.wry.usercenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wry.usercenter.mapper.ComponentMapper;
import com.wry.usercenter.model.domain.Component;
import com.wry.usercenter.model.domain.Product;
import com.wry.usercenter.service.ComponentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author HUAWEI
* @description 针对表【component】的数据库操作Service实现
* @createDate 2022-12-08 13:19:13
*/
@Service
public class ComponentServiceImpl extends ServiceImpl<ComponentMapper, Component>
    implements ComponentService {

    @Resource
    private ComponentMapper componentMapper;

    @Override
    public Component searchByName(String componentName) {
        QueryWrapper<Component> queryWrapper =new QueryWrapper<>();
        if(StringUtils.isNotBlank(componentName)){
            queryWrapper.eq("componentName",componentName);
        }
        Component component = componentMapper.selectOne(queryWrapper);
        return component;
    }
}





package com.wry.usercenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wry.usercenter.common.BaseResponse;
import com.wry.usercenter.common.ResultUtils;
import com.wry.usercenter.model.domain.Composition;
import com.wry.usercenter.model.domain.Manufacture;
import com.wry.usercenter.service.CompositionService;
import com.wry.usercenter.service.ManufactureService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/manufacture")
public class ManufactureController {


    @Resource
    private ManufactureService manufactureService;

    @GetMapping("/search")
    public BaseResponse<List<Manufacture>> searchMaterials(String objectName){
        LambdaQueryWrapper<Manufacture> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(objectName)){
            lambdaQueryWrapper.like(Manufacture::getObjectName,objectName);
        }
        List<Manufacture> manufactureList = manufactureService.list(lambdaQueryWrapper);
        return ResultUtils.success(manufactureList);
    }

    @GetMapping("/one")
    public BaseResponse<Manufacture> searchByName(@RequestParam("objectName") String objectName){
        LambdaQueryWrapper<Manufacture> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(objectName)){
            lambdaQueryWrapper.eq(Manufacture::getObjectName,objectName);
        }
        Manufacture manufacture = manufactureService.getOne(lambdaQueryWrapper);
        return ResultUtils.success(manufacture);
    }
}

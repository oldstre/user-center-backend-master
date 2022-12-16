package com.wry.usercenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wry.usercenter.common.BaseResponse;
import com.wry.usercenter.common.ResultUtils;
import com.wry.usercenter.model.domain.Manufacture;
import com.wry.usercenter.model.domain.Transportation;
import com.wry.usercenter.service.ManufactureService;
import com.wry.usercenter.service.TransportationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {


    @Resource
    private TransportationService transportationService;

    @GetMapping("/search")
    public BaseResponse<List<Transportation>> searchMaterials(String goodsName){
        LambdaQueryWrapper<Transportation> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(goodsName)){
            lambdaQueryWrapper.like(Transportation::getGoodsName,goodsName);
        }
        List<Transportation> transportationList = transportationService.list(lambdaQueryWrapper);
        return ResultUtils.success(transportationList);
    }

//    @GetMapping("/one")
//    public BaseResponse<Manufacture> searchByName(@RequestParam("objectName") String objectName){
//        LambdaQueryWrapper<Manufacture> lambdaQueryWrapper =new LambdaQueryWrapper<>();
//        if(StringUtils.isNotBlank(objectName)){
//            lambdaQueryWrapper.eq(Manufacture::getObjectName,objectName);
//        }
//        Manufacture manufacture = manufactureService.getOne(lambdaQueryWrapper);
//        return ResultUtils.success(manufacture);
//    }
}

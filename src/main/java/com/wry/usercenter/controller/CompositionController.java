package com.wry.usercenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wry.usercenter.common.BaseResponse;
import com.wry.usercenter.common.ResultUtils;
import com.wry.usercenter.model.domain.Composition;
import com.wry.usercenter.model.domain.Material;
import com.wry.usercenter.service.CompositionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/composition")
public class CompositionController {


    @Resource
    private CompositionService compositionService;

    @GetMapping("/search")
    public BaseResponse<List<Composition>> searchMaterials(String objectName){
        LambdaQueryWrapper<Composition> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(objectName)){
            lambdaQueryWrapper.like(Composition::getObjectName,objectName);
        }
        List<Composition> compositionList = compositionService.list(lambdaQueryWrapper);
        return ResultUtils.success(compositionList);
    }

    @GetMapping("/one")
    public BaseResponse<Composition> searchByName(@RequestParam("objectName") String objectName){
        LambdaQueryWrapper<Composition> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(objectName)){
            lambdaQueryWrapper.eq(Composition::getObjectName,objectName);
        }
        Composition composition = compositionService.getOne(lambdaQueryWrapper);
        return ResultUtils.success(composition);
    }
}

package com.wry.usercenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wry.usercenter.common.BaseResponse;
import com.wry.usercenter.common.ErrorCode;
import com.wry.usercenter.common.ResultUtils;
import com.wry.usercenter.exception.BusinessException;
import com.wry.usercenter.model.domain.Material;
import com.wry.usercenter.service.MaterialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {



    @Resource
    private MaterialService materialService;

    /**
     * 查询全部
     * @param materialName
     * @return
     */
    @GetMapping("/search")
    public BaseResponse<List<Material>> searchMaterials(String materialName){
        LambdaQueryWrapper<Material> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(materialName)){
            lambdaQueryWrapper.like(Material::getMaterialName,materialName);
        }
        List<Material> materialList = materialService.list(lambdaQueryWrapper);
        return ResultUtils.success(materialList);

    }

    /**
     * 条件查询，按原材料类型--多值
     * @param materialType
     * @return
     */
    @GetMapping("/batch")
    public BaseResponse<List<Material>> searchByType(@RequestParam("aterialType") String materialType){
        LambdaQueryWrapper<Material> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(materialType)){
            lambdaQueryWrapper.eq(Material::getMaterialType,materialType);

        }
        List<Material> materialList = materialService.list(lambdaQueryWrapper);
        return ResultUtils.success(materialList);
    }

    /**
     * 条件查询--按原材料名
     * @param materialName
     * @return
     */
    @GetMapping("/one")
    public BaseResponse<Material> searchByName(@RequestParam("materialName") String materialName){
        LambdaQueryWrapper<Material> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(materialName)){
            lambdaQueryWrapper.eq(Material::getMaterialName,materialName);
        }
        Material material = materialService.getOne(lambdaQueryWrapper);
        return ResultUtils.success(material);
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteMaterial(@RequestParam("id") long id){
        if(id<=0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = materialService.removeById(id);
        return ResultUtils.success(b);
    }

    @PostMapping("/add")
    public BaseResponse<Boolean> createMaterial(@RequestBody Material material){
        if(material==null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        boolean b = materialService.save(material);
        return ResultUtils.success(b);
    }

    @PutMapping("update")
    public BaseResponse<Boolean> updateMaterial(@RequestBody Material material){
        if(material==null){
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }

        boolean b = materialService.updateById(material);
        return ResultUtils.success(b);
    }



}

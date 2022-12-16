package com.wry.usercenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wry.usercenter.common.BaseResponse;
import com.wry.usercenter.common.ErrorCode;
import com.wry.usercenter.common.ResultUtils;
import com.wry.usercenter.exception.BusinessException;
import com.wry.usercenter.model.domain.Component;
import com.wry.usercenter.model.domain.Product;
import com.wry.usercenter.service.ComponentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/component")
public class ComponentController {

    @Resource
    private ComponentService componentService;



    @GetMapping("/search")
    public BaseResponse<List<Component>> searchComponents(String componentName, HttpServletRequest request) {

        QueryWrapper<Component> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(componentName)) {
            queryWrapper.like("componentName", componentName);
        }
        List<Component> componentList = componentService.list(queryWrapper);
        //System.out.println(productList);
//        List<Product> list = productList.stream().map(user -> productLis).collect(Collectors.toList());
        return ResultUtils.success(componentList);
    }

    /**
     * 条件查询，按零件名
     * @param componentName
     * @return
     */
    @GetMapping("/one")
    public BaseResponse<Component> searchByName(@RequestParam("componentName") String componentName){
//        LambdaQueryWrapper<Product> lambdaQueryWrapper= new LambdaQueryWrapper<>();
//        if(StringUtils.isNotBlank(productName)){
//            lambdaQueryWrapper.eq(Product::getProductName,productName);
//        }
//        Product product = productService.getOne(lambdaQueryWrapper);
        Component component = componentService.searchByName(componentName);
        return ResultUtils.success(component);

    }

//    /**
//     * 条件查询，按零件类型--多值
//     * @param componentType
//     * @return
//     */
//    @GetMapping("/batch")
//    public BaseResponse<List<Component>> searchByType(@RequestParam("componentType") String componentType){
//        LambdaQueryWrapper<Product> lambdaQueryWrapper =new LambdaQueryWrapper<>();
//        if(StringUtils.isNotBlank(componentType)){
//            lambdaQueryWrapper.eq(Component::g,componentType);
//        }
//        List<Component> componentList = componentService.list(lambdaQueryWrapper);
//        return ResultUtils.success(componentList);
//    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteComponent(@RequestParam("id") int id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        System.out.println(id);
        boolean b = componentService.removeById(id);
        return ResultUtils.success(b);
    }

    @PostMapping("/add")
    public BaseResponse<Boolean> createComponent(@RequestBody Component component){
        if(component==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = componentService.save(component);
        return ResultUtils.success(b);

    }

    @PutMapping("update")
    public BaseResponse<Boolean> updateProduct(@RequestBody Component component){
        if(component==null){
            return ResultUtils.error(ErrorCode.PARAMS_ERROR);
        }
        boolean b = componentService.updateById(component);
        return ResultUtils.success(b);
    }

}


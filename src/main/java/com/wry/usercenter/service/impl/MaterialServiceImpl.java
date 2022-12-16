package com.wry.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wry.usercenter.mapper.MaterialMapper;
import com.wry.usercenter.model.domain.Material;
import com.wry.usercenter.service.MaterialService;
import org.springframework.stereotype.Service;

/**
* @author HUAWEI
* @description 针对表【material】的数据库操作Service实现
* @createDate 2022-12-09 14:35:49
*/
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material>
    implements MaterialService {

}





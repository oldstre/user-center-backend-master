package com.wry.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @TableName product
 */
@TableName(value ="product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    /**
     * 产品号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 产品名
     */
    private String productName;



    /**
     * 产品数量
     */
    private Integer productQuantity;

    /**
     * 产品类别
     */
    private String productType;

    /**
     * 是否删除 
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productName, product.productName)  && Objects.equals(productQuantity, product.productQuantity) && Objects.equals(productType, product.productType) && Objects.equals(isDelete, product.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productQuantity, productType, isDelete);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productType='" + productType + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
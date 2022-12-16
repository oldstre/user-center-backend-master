package com.wry.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName manufacture
 */
@TableName(value ="manufacture")
@Data
public class Manufacture implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 物品名
     */
    private String objectName;

    /**
     * 原材料1
     */
    private String mar1;

    /**
     * 原材料数量
     */
    private Integer mar1Q;

    /**
     * 原材料2
     */
    private String mar2;

    /**
     * 原材料2数量
     */
    private Integer mar2Q;

    /**
     * 原材料3
     */
    private String mar3;

    /**
     * 原材料3数量
     */
    private Integer mar3Q;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Manufacture other = (Manufacture) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectName() == null ? other.getObjectName() == null : this.getObjectName().equals(other.getObjectName()))
            && (this.getMar1() == null ? other.getMar1() == null : this.getMar1().equals(other.getMar1()))
            && (this.getMar1Q() == null ? other.getMar1Q() == null : this.getMar1Q().equals(other.getMar1Q()))
            && (this.getMar2() == null ? other.getMar2() == null : this.getMar2().equals(other.getMar2()))
            && (this.getMar2Q() == null ? other.getMar2Q() == null : this.getMar2Q().equals(other.getMar2Q()))
            && (this.getMar3() == null ? other.getMar3() == null : this.getMar3().equals(other.getMar3()))
            && (this.getMar3Q() == null ? other.getMar3Q() == null : this.getMar3Q().equals(other.getMar3Q()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectName() == null) ? 0 : getObjectName().hashCode());
        result = prime * result + ((getMar1() == null) ? 0 : getMar1().hashCode());
        result = prime * result + ((getMar1Q() == null) ? 0 : getMar1Q().hashCode());
        result = prime * result + ((getMar2() == null) ? 0 : getMar2().hashCode());
        result = prime * result + ((getMar2Q() == null) ? 0 : getMar2Q().hashCode());
        result = prime * result + ((getMar3() == null) ? 0 : getMar3().hashCode());
        result = prime * result + ((getMar3Q() == null) ? 0 : getMar3Q().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", objectName=").append(objectName);
        sb.append(", mar1=").append(mar1);
        sb.append(", mar1Q=").append(mar1Q);
        sb.append(", mar2=").append(mar2);
        sb.append(", mar2Q=").append(mar2Q);
        sb.append(", mar3=").append(mar3);
        sb.append(", mar3Q=").append(mar3Q);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
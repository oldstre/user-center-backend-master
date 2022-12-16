package com.wry.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName component
 */
@TableName(value ="component")
@Data
public class Component implements Serializable {
    /**
     * 
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 零件名
     */
    private String componentName;

    /**
     * 零件图片
     */
    private String componentImg;

    /**
     * 零件数量
     */
    private Integer componentQuantity;

    /**
     * 是否被删除
     */
    @TableLogic
    private Integer isDelete;

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
        Component other = (Component) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getComponentName() == null ? other.getComponentName() == null : this.getComponentName().equals(other.getComponentName()))
            && (this.getComponentImg() == null ? other.getComponentImg() == null : this.getComponentImg().equals(other.getComponentImg()))
            && (this.getComponentQuantity() == null ? other.getComponentQuantity() == null : this.getComponentQuantity().equals(other.getComponentQuantity()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getComponentName() == null) ? 0 : getComponentName().hashCode());
        result = prime * result + ((getComponentImg() == null) ? 0 : getComponentImg().hashCode());
        result = prime * result + ((getComponentQuantity() == null) ? 0 : getComponentQuantity().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", componentName=").append(componentName);
        sb.append(", componentImg=").append(componentImg);
        sb.append(", componentQuantity=").append(componentQuantity);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
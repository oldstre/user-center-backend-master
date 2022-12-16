package com.wry.usercenter.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName composition
 */
@TableName(value ="composition")
@Data
public class Composition implements Serializable {
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
     * 零件1
     */
    private String component1;

    private Integer com1Quantity;
    /**
     * 零件2
     */
    private String component2;

    private Integer com2Quantity;

    /**
     * 零件3
     */
    private String component3;

    private Integer com3Quantity;

    /**
     * 零件4
     */
    private String component4;

    private Integer com4Quantity;

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
        Composition other = (Composition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getObjectName() == null ? other.getObjectName() == null : this.getObjectName().equals(other.getObjectName()))
            && (this.getComponent1() == null ? other.getComponent1() == null : this.getComponent1().equals(other.getComponent1()))
            && (this.getComponent2() == null ? other.getComponent2() == null : this.getComponent2().equals(other.getComponent2()))
            && (this.getComponent3() == null ? other.getComponent3() == null : this.getComponent3().equals(other.getComponent3()))
            && (this.getComponent4() == null ? other.getComponent4() == null : this.getComponent4().equals(other.getComponent4()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getObjectName() == null) ? 0 : getObjectName().hashCode());
        result = prime * result + ((getComponent1() == null) ? 0 : getComponent1().hashCode());
        result = prime * result + ((getComponent2() == null) ? 0 : getComponent2().hashCode());
        result = prime * result + ((getComponent3() == null) ? 0 : getComponent3().hashCode());
        result = prime * result + ((getComponent4() == null) ? 0 : getComponent4().hashCode());
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
        sb.append(", component1=").append(component1);
        sb.append(", component2=").append(component2);
        sb.append(", component3=").append(component3);
        sb.append(", component4=").append(component4);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
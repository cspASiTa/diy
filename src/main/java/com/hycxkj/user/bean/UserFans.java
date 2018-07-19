package com.hycxkj.user.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hycxkj.common.annotation.PrimaryKey;
/**
 * 实体类对应的数据表为：  user_fans
 * @author 陈少平
 * @date 2018-03-29 16:51:12
 */
@ApiModel(value ="UserFans")
public class UserFans implements Serializable {
    @PrimaryKey
    @ApiModelProperty(value = "")
    private Long fansId;

    @ApiModelProperty(value = "粉丝ID")
    private Long focusId;

    @ApiModelProperty(value = "被关注人的ID")
    private Long beFocusId;

    @ApiModelProperty(value = "")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_fans
     */
    private static final long serialVersionUID = 1L;

    public Long getFansId() {
        return fansId;
    }

    public void setFansId(Long fansId) {
        this.fansId = fansId;
    }

    public Long getFocusId() {
        return focusId;
    }

    public void setFocusId(Long focusId) {
        this.focusId = focusId;
    }

    public Long getBeFocusId() {
        return beFocusId;
    }

    public void setBeFocusId(Long beFocusId) {
        this.beFocusId = beFocusId;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fansId=").append(fansId);
        sb.append(", focusId=").append(focusId);
        sb.append(", beFocusId=").append(beFocusId);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

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
        UserFans other = (UserFans) that;
        return (this.getFansId() == null ? other.getFansId() == null : this.getFansId().equals(other.getFansId()))
            && (this.getFocusId() == null ? other.getFocusId() == null : this.getFocusId().equals(other.getFocusId()))
            && (this.getBeFocusId() == null ? other.getBeFocusId() == null : this.getBeFocusId().equals(other.getBeFocusId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFansId() == null) ? 0 : getFansId().hashCode());
        result = prime * result + ((getFocusId() == null) ? 0 : getFocusId().hashCode());
        result = prime * result + ((getBeFocusId() == null) ? 0 : getBeFocusId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}
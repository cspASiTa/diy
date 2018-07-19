package com.hycxkj.postage.bean;

import com.hycxkj.common.annotation.PrimaryKey;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 * 实体类对应的数据表为：  postage_package_condition
 * @author 陈少平
 * @date 2018-05-12 14:50:22
 */
@ApiModel(value ="PostagePackageCondition")
public class PostagePackageCondition implements Serializable {
    @PrimaryKey
    @ApiModelProperty(value = "")
    private Long id;

    @ApiModelProperty(value = "")
    private Long postageTemplateId;

    @ApiModelProperty(value = "数量到达多少才包邮")
    private Long amount;

    @ApiModelProperty(value = "包邮体积")
    private Long bulkNo;

    @ApiModelProperty(value = "包邮的重量")
    private Long weightNo;

    @ApiModelProperty(value = "包邮地区(null为全国。直接存储地方，以|分割)")
    private String region;

    @ApiModelProperty(value = "运送方式(0:快递, 1:EMS, 2:顺丰)")
    private Byte carrayAway;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table postage_package_condition
     */
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostageTemplateId() {
        return postageTemplateId;
    }

    public void setPostageTemplateId(Long postageTemplateId) {
        this.postageTemplateId = postageTemplateId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBulkNo() {
        return bulkNo;
    }

    public void setBulkNo(Long bulkNo) {
        this.bulkNo = bulkNo;
    }

    public Long getWeightNo() {
        return weightNo;
    }

    public void setWeightNo(Long weightNo) {
        this.weightNo = weightNo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Byte getCarrayAway() {
        return carrayAway;
    }

    public void setCarrayAway(Byte carrayAway) {
        this.carrayAway = carrayAway;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", postageTemplateId=").append(postageTemplateId);
        sb.append(", amount=").append(amount);
        sb.append(", bulkNo=").append(bulkNo);
        sb.append(", weightNo=").append(weightNo);
        sb.append(", region=").append(region);
        sb.append(", carrayAway=").append(carrayAway);
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
        PostagePackageCondition other = (PostagePackageCondition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPostageTemplateId() == null ? other.getPostageTemplateId() == null : this.getPostageTemplateId().equals(other.getPostageTemplateId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getBulkNo() == null ? other.getBulkNo() == null : this.getBulkNo().equals(other.getBulkNo()))
            && (this.getWeightNo() == null ? other.getWeightNo() == null : this.getWeightNo().equals(other.getWeightNo()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getCarrayAway() == null ? other.getCarrayAway() == null : this.getCarrayAway().equals(other.getCarrayAway()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPostageTemplateId() == null) ? 0 : getPostageTemplateId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getBulkNo() == null) ? 0 : getBulkNo().hashCode());
        result = prime * result + ((getWeightNo() == null) ? 0 : getWeightNo().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getCarrayAway() == null) ? 0 : getCarrayAway().hashCode());
        return result;
    }
}
package com.hycxkj.shop.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hycxkj.common.annotation.PrimaryKey;
/**
 * 实体类对应的数据表为：  shop_item
 * @author 陈少平
 * @date 2018-04-02 17:42:11
 */
@ApiModel(value ="ShopItem")
public class ShopItem implements Serializable {
    @PrimaryKey
    @ApiModelProperty(value = "")
    private Long itemId;

    @ApiModelProperty(value = "商品类目ID")
    private Integer categoryId;

    @ApiModelProperty(value = "商品数量")
    private Integer num;

    @ApiModelProperty(value = "商品价格。以分为单位")
    private Long price;

    @ApiModelProperty(value = "商品标题")
    private String title;

    @ApiModelProperty(value = "商品状态，1：正常；2：下架；3：删除")
    private Byte status;

    @ApiModelProperty(value = "商品重量，以克为单位")
    private Long weight;

    @ApiModelProperty(value = "商品卖点(商品描述)")
    private String sallPoint;

    @ApiModelProperty(value = "商品封面图（小，一张）")
    private String image;

    @ApiModelProperty(value = "商品描述")
    private String shopDesc;

    @ApiModelProperty(value = "")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "")
    private Long sortOrder;

    @ApiModelProperty(value = "折扣价")
    private Long discountPrice;

    @ApiModelProperty(value = "商家的ID")
    private Long shopBusiId;

    @ApiModelProperty(value = "0：成品 ；1：自制（默认0）")
    private Byte type;

    @ApiModelProperty(value = "商品的评论值")
    private Byte ratingValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shop_item
     */
    private static final long serialVersionUID = 1L;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getSallPoint() {
        return sallPoint;
    }

    public void setSallPoint(String sallPoint) {
        this.sallPoint = sallPoint;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Long getShopBusiId() {
        return shopBusiId;
    }

    public void setShopBusiId(Long shopBusiId) {
        this.shopBusiId = shopBusiId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Byte ratingValue) {
        this.ratingValue = ratingValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", num=").append(num);
        sb.append(", price=").append(price);
        sb.append(", title=").append(title);
        sb.append(", status=").append(status);
        sb.append(", weight=").append(weight);
        sb.append(", sallPoint=").append(sallPoint);
        sb.append(", image=").append(image);
        sb.append(", shopDesc=").append(shopDesc);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", discountPrice=").append(discountPrice);
        sb.append(", shopBusiId=").append(shopBusiId);
        sb.append(", type=").append(type);
        sb.append(", ratingValue=").append(ratingValue);
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
        ShopItem other = (ShopItem) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getSallPoint() == null ? other.getSallPoint() == null : this.getSallPoint().equals(other.getSallPoint()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getShopDesc() == null ? other.getShopDesc() == null : this.getShopDesc().equals(other.getShopDesc()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSortOrder() == null ? other.getSortOrder() == null : this.getSortOrder().equals(other.getSortOrder()))
            && (this.getDiscountPrice() == null ? other.getDiscountPrice() == null : this.getDiscountPrice().equals(other.getDiscountPrice()))
            && (this.getShopBusiId() == null ? other.getShopBusiId() == null : this.getShopBusiId().equals(other.getShopBusiId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getRatingValue() == null ? other.getRatingValue() == null : this.getRatingValue().equals(other.getRatingValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getSallPoint() == null) ? 0 : getSallPoint().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getShopDesc() == null) ? 0 : getShopDesc().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSortOrder() == null) ? 0 : getSortOrder().hashCode());
        result = prime * result + ((getDiscountPrice() == null) ? 0 : getDiscountPrice().hashCode());
        result = prime * result + ((getShopBusiId() == null) ? 0 : getShopBusiId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getRatingValue() == null) ? 0 : getRatingValue().hashCode());
        return result;
    }
}
package com.hycxkj.order.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hycxkj.common.annotation.PrimaryKey;
/**
 * 实体类对应的数据表为：  order_detail
 * @author 陈少平
 * @date 2018-05-13 13:47:06
 */
@ApiModel(value ="OrderDetail")
public class OrderDetail implements Serializable {
    @ApiModelProperty(value = "")
    private String orderDetailId;

    @ApiModelProperty(value = "用户ID")
    private Long uId;

    @ApiModelProperty(value = "用户地址")
    private Long addrId;

    @ApiModelProperty(value = "支付金额。以分为单位")
    private Long payment;

    @ApiModelProperty(value = "支付状态。0：微信支付；1：支付宝支付。。。")
    private Byte payFee;

    @ApiModelProperty(value = "邮费")
    private Long postFee;

    @ApiModelProperty(value = "状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭")
    private Byte status;

    @ApiModelProperty(value = "总重量；以克为单位")
    private Long totalWeight;

    @ApiModelProperty(value = "返现；以分为单位")
    private Long returnPrice;

    @ApiModelProperty(value = "服务费。以分为单位")
    private Long servicePrice;

    @ApiModelProperty(value = "退换无忧  0：不支持； 1：支持")
    private Byte noAnnoyance;

    @ApiModelProperty(value = "物流单号")
    private String logisticsCode;

    @ApiModelProperty(value = "物流名称")
    private String logisticsName;

    @ApiModelProperty(value = "买家是否评价 0:无； 1:评价")
    private Byte buyerRate;

    @ApiModelProperty(value = "支付时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;

    @ApiModelProperty(value = "发货时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date consignTime;

    @ApiModelProperty(value = "交易完成时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty(value = "交易关闭时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date closeTime;

    @ApiModelProperty(value = "订单创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "订单修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table order_detail
     */
    private static final long serialVersionUID = 1L;

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getAddrId() {
        return addrId;
    }

    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public Byte getPayFee() {
        return payFee;
    }

    public void setPayFee(Byte payFee) {
        this.payFee = payFee;
    }

    public Long getPostFee() {
        return postFee;
    }

    public void setPostFee(Long postFee) {
        this.postFee = postFee;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Long getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(Long returnPrice) {
        this.returnPrice = returnPrice;
    }

    public Long getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Long servicePrice) {
        this.servicePrice = servicePrice;
    }

    public Byte getNoAnnoyance() {
        return noAnnoyance;
    }

    public void setNoAnnoyance(Byte noAnnoyance) {
        this.noAnnoyance = noAnnoyance;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public Byte getBuyerRate() {
        return buyerRate;
    }

    public void setBuyerRate(Byte buyerRate) {
        this.buyerRate = buyerRate;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderDetailId=").append(orderDetailId);
        sb.append(", uId=").append(uId);
        sb.append(", addrId=").append(addrId);
        sb.append(", payment=").append(payment);
        sb.append(", payFee=").append(payFee);
        sb.append(", postFee=").append(postFee);
        sb.append(", status=").append(status);
        sb.append(", totalWeight=").append(totalWeight);
        sb.append(", returnPrice=").append(returnPrice);
        sb.append(", servicePrice=").append(servicePrice);
        sb.append(", noAnnoyance=").append(noAnnoyance);
        sb.append(", logisticsCode=").append(logisticsCode);
        sb.append(", logisticsName=").append(logisticsName);
        sb.append(", buyerRate=").append(buyerRate);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", consignTime=").append(consignTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        OrderDetail other = (OrderDetail) that;
        return (this.getOrderDetailId() == null ? other.getOrderDetailId() == null : this.getOrderDetailId().equals(other.getOrderDetailId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getAddrId() == null ? other.getAddrId() == null : this.getAddrId().equals(other.getAddrId()))
            && (this.getPayment() == null ? other.getPayment() == null : this.getPayment().equals(other.getPayment()))
            && (this.getPayFee() == null ? other.getPayFee() == null : this.getPayFee().equals(other.getPayFee()))
            && (this.getPostFee() == null ? other.getPostFee() == null : this.getPostFee().equals(other.getPostFee()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTotalWeight() == null ? other.getTotalWeight() == null : this.getTotalWeight().equals(other.getTotalWeight()))
            && (this.getReturnPrice() == null ? other.getReturnPrice() == null : this.getReturnPrice().equals(other.getReturnPrice()))
            && (this.getServicePrice() == null ? other.getServicePrice() == null : this.getServicePrice().equals(other.getServicePrice()))
            && (this.getNoAnnoyance() == null ? other.getNoAnnoyance() == null : this.getNoAnnoyance().equals(other.getNoAnnoyance()))
            && (this.getLogisticsCode() == null ? other.getLogisticsCode() == null : this.getLogisticsCode().equals(other.getLogisticsCode()))
            && (this.getLogisticsName() == null ? other.getLogisticsName() == null : this.getLogisticsName().equals(other.getLogisticsName()))
            && (this.getBuyerRate() == null ? other.getBuyerRate() == null : this.getBuyerRate().equals(other.getBuyerRate()))
            && (this.getPaymentTime() == null ? other.getPaymentTime() == null : this.getPaymentTime().equals(other.getPaymentTime()))
            && (this.getConsignTime() == null ? other.getConsignTime() == null : this.getConsignTime().equals(other.getConsignTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCloseTime() == null ? other.getCloseTime() == null : this.getCloseTime().equals(other.getCloseTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderDetailId() == null) ? 0 : getOrderDetailId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getAddrId() == null) ? 0 : getAddrId().hashCode());
        result = prime * result + ((getPayment() == null) ? 0 : getPayment().hashCode());
        result = prime * result + ((getPayFee() == null) ? 0 : getPayFee().hashCode());
        result = prime * result + ((getPostFee() == null) ? 0 : getPostFee().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTotalWeight() == null) ? 0 : getTotalWeight().hashCode());
        result = prime * result + ((getReturnPrice() == null) ? 0 : getReturnPrice().hashCode());
        result = prime * result + ((getServicePrice() == null) ? 0 : getServicePrice().hashCode());
        result = prime * result + ((getNoAnnoyance() == null) ? 0 : getNoAnnoyance().hashCode());
        result = prime * result + ((getLogisticsCode() == null) ? 0 : getLogisticsCode().hashCode());
        result = prime * result + ((getLogisticsName() == null) ? 0 : getLogisticsName().hashCode());
        result = prime * result + ((getBuyerRate() == null) ? 0 : getBuyerRate().hashCode());
        result = prime * result + ((getPaymentTime() == null) ? 0 : getPaymentTime().hashCode());
        result = prime * result + ((getConsignTime() == null) ? 0 : getConsignTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getCloseTime() == null) ? 0 : getCloseTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
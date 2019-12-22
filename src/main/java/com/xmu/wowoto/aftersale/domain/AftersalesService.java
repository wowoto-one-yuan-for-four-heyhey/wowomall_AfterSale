package com.xmu.wowoto.aftersale.domain;

import java.time.LocalDateTime;

/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
public class AftersalesService {
    private Integer id;
    /**
     * 下单时对应商品类型，只有两种：（1）预售商品，取值为1（2）其他商品，取值为0
     */
    private Integer goodsType;
    /**
     * 申请售后时间
     */
    private LocalDateTime applyTime;
    /**
     * 申请售后理由
     */
    private String applyReason;
    /**
     *售后完成时间
     */
    private LocalDateTime endTime;
    /**
     * 售后类型，0退货，1换货
     */
    private Integer type;
    /**
     * 用户售后请求现在是否有效（用户可以主动取消售后请求，售后请求也可能超时）
     */
    private Boolean beApplied;
    /**
     * 申请服务的产品数量，如退货的件数
     */
    private Integer number;
    /**
     * 订单明细ID
     */
    private Integer orderItemId;
    /**
     * 管理员处理状态,有三个状态：未审核：0 审核通过：1 审核拒绝：2
     */
    private Integer statusCode;
    /**
     * 用户ID
     */
    private Integer userId;

    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private Boolean beDeleted;

    public Integer getId() {
        return this.id;
    }

    public Integer getGoodsType() {
        return this.goodsType;
    }

    public LocalDateTime getApplyTime() {
        return this.applyTime;
    }

    public String getApplyReason() {
        return this.applyReason;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public Integer getType() {
        return this.type;
    }

    public Boolean getBeApplied() {
        return this.beApplied;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Integer getOrderItemId() {
        return this.orderItemId;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public LocalDateTime getGmtCreate() {
        return this.gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return this.gmtModified;
    }

    public Boolean getBeDeleted() {
        return this.beDeleted;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public void setApplyTime(LocalDateTime applyTime) {
        this.applyTime = applyTime;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setBeApplied(Boolean beApplied) {
        this.beApplied = beApplied;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    public void setBeDeleted(Boolean beDeleted) {
        this.beDeleted = beDeleted;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AftersalesService)) return false;
        final AftersalesService other = (AftersalesService) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$goodsType = this.getGoodsType();
        final Object other$goodsType = other.getGoodsType();
        if (this$goodsType == null ? other$goodsType != null : !this$goodsType.equals(other$goodsType)) return false;
        final Object this$applyTime = this.getApplyTime();
        final Object other$applyTime = other.getApplyTime();
        if (this$applyTime == null ? other$applyTime != null : !this$applyTime.equals(other$applyTime)) return false;
        final Object this$applyReason = this.getApplyReason();
        final Object other$applyReason = other.getApplyReason();
        if (this$applyReason == null ? other$applyReason != null : !this$applyReason.equals(other$applyReason))
            return false;
        final Object this$endTime = this.getEndTime();
        final Object other$endTime = other.getEndTime();
        if (this$endTime == null ? other$endTime != null : !this$endTime.equals(other$endTime)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        final Object this$beApplied = this.getBeApplied();
        final Object other$beApplied = other.getBeApplied();
        if (this$beApplied == null ? other$beApplied != null : !this$beApplied.equals(other$beApplied)) return false;
        final Object this$number = this.getNumber();
        final Object other$number = other.getNumber();
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) return false;
        final Object this$orderItemId = this.getOrderItemId();
        final Object other$orderItemId = other.getOrderItemId();
        if (this$orderItemId == null ? other$orderItemId != null : !this$orderItemId.equals(other$orderItemId))
            return false;
        final Object this$statusCode = this.getStatusCode();
        final Object other$statusCode = other.getStatusCode();
        if (this$statusCode == null ? other$statusCode != null : !this$statusCode.equals(other$statusCode))
            return false;
        final Object this$userId = this.getUserId();
        final Object other$userId = other.getUserId();
        if (this$userId == null ? other$userId != null : !this$userId.equals(other$userId)) return false;
        final Object this$gmtCreate = this.getGmtCreate();
        final Object other$gmtCreate = other.getGmtCreate();
        if (this$gmtCreate == null ? other$gmtCreate != null : !this$gmtCreate.equals(other$gmtCreate)) return false;
        final Object this$gmtModified = this.getGmtModified();
        final Object other$gmtModified = other.getGmtModified();
        if (this$gmtModified == null ? other$gmtModified != null : !this$gmtModified.equals(other$gmtModified))
            return false;
        final Object this$beDeleted = this.getBeDeleted();
        final Object other$beDeleted = other.getBeDeleted();
        if (this$beDeleted == null ? other$beDeleted != null : !this$beDeleted.equals(other$beDeleted)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AftersalesService;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $goodsType = this.getGoodsType();
        result = result * PRIME + ($goodsType == null ? 43 : $goodsType.hashCode());
        final Object $applyTime = this.getApplyTime();
        result = result * PRIME + ($applyTime == null ? 43 : $applyTime.hashCode());
        final Object $applyReason = this.getApplyReason();
        result = result * PRIME + ($applyReason == null ? 43 : $applyReason.hashCode());
        final Object $endTime = this.getEndTime();
        result = result * PRIME + ($endTime == null ? 43 : $endTime.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $beApplied = this.getBeApplied();
        result = result * PRIME + ($beApplied == null ? 43 : $beApplied.hashCode());
        final Object $number = this.getNumber();
        result = result * PRIME + ($number == null ? 43 : $number.hashCode());
        final Object $orderItemId = this.getOrderItemId();
        result = result * PRIME + ($orderItemId == null ? 43 : $orderItemId.hashCode());
        final Object $statusCode = this.getStatusCode();
        result = result * PRIME + ($statusCode == null ? 43 : $statusCode.hashCode());
        final Object $userId = this.getUserId();
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        final Object $gmtCreate = this.getGmtCreate();
        result = result * PRIME + ($gmtCreate == null ? 43 : $gmtCreate.hashCode());
        final Object $gmtModified = this.getGmtModified();
        result = result * PRIME + ($gmtModified == null ? 43 : $gmtModified.hashCode());
        final Object $beDeleted = this.getBeDeleted();
        result = result * PRIME + ($beDeleted == null ? 43 : $beDeleted.hashCode());
        return result;
    }

    public String toString() {
        return "AftersalesService(id=" + this.getId() + ", goodsType=" + this.getGoodsType() + ", applyTime=" + this.getApplyTime() + ", applyReason=" + this.getApplyReason() + ", endTime=" + this.getEndTime() + ", type=" + this.getType() + ", beApplied=" + this.getBeApplied() + ", number=" + this.getNumber() + ", orderItemId=" + this.getOrderItemId() + ", statusCode=" + this.getStatusCode() + ", userId=" + this.getUserId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
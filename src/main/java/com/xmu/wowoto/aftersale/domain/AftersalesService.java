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

    @Override
    public boolean equals(final Object o) {

        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AftersalesService;
    }

    @Override
    public int hashCode() {

        return 0;
    }

    @Override
    public String toString() {
        return "AftersalesService(id=" + this.getId() + ", goodsType=" + this.getGoodsType() + ", applyTime=" + this.getApplyTime() + ", applyReason=" + this.getApplyReason() + ", endTime=" + this.getEndTime() + ", type=" + this.getType() + ", beApplied=" + this.getBeApplied() + ", number=" + this.getNumber() + ", orderItemId=" + this.getOrderItemId() + ", statusCode=" + this.getStatusCode() + ", userId=" + this.getUserId() + ", gmtCreate=" + this.getGmtCreate() + ", gmtModified=" + this.getGmtModified() + ", beDeleted=" + this.getBeDeleted() + ")";
    }
}
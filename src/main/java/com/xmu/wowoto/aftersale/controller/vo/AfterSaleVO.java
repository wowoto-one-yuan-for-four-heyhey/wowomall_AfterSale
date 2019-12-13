package com.xmu.wowoto.aftersale.controller.vo;


/**
 * @author wowoto
 * @date 12/12/2019
 */
public class AfterSaleVO {
    private Integer type;

    private String applyReason;

    private Integer number;

    private Integer orderItemId;

    @Override
    public String toString() {
        return "AfterSaleVO{" +
                "type=" + type +
                ", applyReason='" + applyReason + '\'' +
                ", number=" + number +
                ", orderItemId=" + orderItemId +
                '}';
    }

    /***************************************************
     * 生成代码
     ***************************************************/

    public Integer getType() {
        return type;
    }


    public String getApplyReason() {
        return applyReason;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }


    public Integer getNumber() {
        return number;
    }



}
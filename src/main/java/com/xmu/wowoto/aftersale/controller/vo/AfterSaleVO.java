package com.xmu.wowoto.aftersale.controller.vo;

import javax.xml.crypto.Data;

/**
 * @author wowoto
 * @date 12/12/2019
 */
public class AfterSaleVO {
    private Integer type;

    private String apply_reason;

    private Integer number;

    private Integer order_item_id;

    /***************************************************
     * 生成代码
     ***************************************************/

    @Override
    public String toString() {
        return "AfterSaleVO{" +
                "type=" + type +
                ", apply_reason='" + apply_reason + '\'' +
                ", number=" + number +
                ", order_item_id=" + order_item_id +
                '}';
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getApply_reason() {
        return apply_reason;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getOrder_item_id() {
        return order_item_id;
    }

    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOrder_item_id(Integer order_item_id) {
        this.order_item_id = order_item_id;
    }
}
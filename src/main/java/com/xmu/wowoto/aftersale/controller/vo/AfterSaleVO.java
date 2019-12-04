package com.xmu.wowoto.aftersale.controller.vo;

import javax.xml.crypto.Data;

public class AfterSaleVO {
    private int goods_type;

    private String apply_reason;

    private int number;

    private int order_item_id;

    /***************************************************
     * 生成代码
     ***************************************************/

    @Override
    public String toString() {
        return "AfterSaleVO{" +
                "goods_type=" + goods_type +
                ", apply_reason='" + apply_reason + '\'' +
                ", number=" + number +
                ", order_item_id=" + order_item_id +
                '}';
    }

    public int getGoods_type() {
        return goods_type;
    }

    public String getApply_reason() {
        return apply_reason;
    }

    public int getNumber() {
        return number;
    }

    public int getOrder_item_id() {
        return order_item_id;
    }

    public void setGoods_type(int goods_type) {
        this.goods_type = goods_type;
    }

    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setOrder_item_id(int order_item_id) {
        this.order_item_id = order_item_id;
    }
}

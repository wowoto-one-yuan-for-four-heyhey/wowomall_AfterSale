package com.xmu.wowoto.aftersale.controller.vo;


/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
public class AfterSaleUpdateVO {

    private Integer type;

    private String applyReason;


    @Override
    public String toString() {
        return "AfterSaleUpdateVO{" +
                "type=" + type +
                ", applyReason='" + applyReason + '\'' +
                '}';
    }

    public Integer getType() {
        return type;
    }

    public String getApplyReason() {
        return applyReason;
    }

}

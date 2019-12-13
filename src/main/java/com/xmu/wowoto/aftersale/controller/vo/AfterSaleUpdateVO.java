package com.xmu.wowoto.aftersale.controller.vo;


/**
 * @author MedalWill
 * @date 2019/12/13 17:56
 */
public class AfterSaleUpdateVO {

    private Integer type;

    private String applyReason;

    private Integer statusCode;

    @Override
    public String toString() {
        return "AfterSaleUpdateVO{" +
                "type=" + type +
                ", applyReason='" + applyReason + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getType() {
        return type;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}

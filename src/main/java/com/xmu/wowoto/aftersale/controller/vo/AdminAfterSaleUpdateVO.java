package com.xmu.wowoto.aftersale.controller.vo;

/**
 * @author MedalWill
 * @date 2019/12/13 17:45
 */
public class AdminAfterSaleUpdateVO {

    private String beApplied;

    private Integer status;

    @Override
    public String toString() {
        return "AdminAfterSaleUpdateVO{" +
                "beApplied='" + beApplied + '\'' +
                ", status=" + status +
                '}';
    }

    public String getBeApplied() {
        return beApplied;
    }

    public Integer getStatus() {
        return status;
    }

    public void setBeApplied(String beApplied) {
        this.beApplied = beApplied;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

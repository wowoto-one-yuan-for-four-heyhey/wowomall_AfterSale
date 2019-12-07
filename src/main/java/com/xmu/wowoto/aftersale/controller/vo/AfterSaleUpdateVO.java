package com.xmu.wowoto.aftersale.controller.vo;

import org.springframework.web.bind.annotation.PathVariable;

public class AfterSaleUpdateVO {

    private boolean type;

    private String apply_reason;

    private Integer status_code;

    /**************************
     生成代码
     **************************/
    @Override
    public String toString() {
        return "AfterSaleUpdateVO{" +
                "type=" + type +
                ", apply_reason='" + apply_reason + '\'' +
                ", status_code=" + status_code +
                '}';
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public boolean getType() {
        return type;
    }

    public String getApply_reason() {
        return apply_reason;
    }

    public Integer getStatus_code() {
        return status_code;
    }
}

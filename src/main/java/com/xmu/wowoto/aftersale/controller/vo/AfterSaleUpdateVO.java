package com.xmu.wowoto.aftersale.controller.vo;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wowoto
 * @date 12/12/2019
 */
public class AfterSaleUpdateVO {

    private Integer type;

    private String apply_reason;

    private Integer status_code;

    @Override
    public String toString() {
        return "AfterSaleUpdateVO{" +
                "type=" + type +
                ", apply_reason='" + apply_reason + '\'' +
                ", status_code=" + status_code +
                '}';
    }


    /**************************
     生成代码
     **************************/

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }


    public String getApply_reason() {
        return apply_reason;
    }

    public Integer getStatus_code() {
        return status_code;
    }
}

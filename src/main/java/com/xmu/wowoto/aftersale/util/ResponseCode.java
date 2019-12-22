package com.xmu.wowoto.aftersale.util;

/**
 *
 * @author wowoto
 * @date 12/11/2019
 */
public enum ResponseCode {
    GET_FAILED(691,"获取售后服务失败"),
    REQUEST_COUPON(692,"申请售后服务失败"),
    USE_FAILED(693 ,"修改售后服务失败"),
    DELETE_FAILED(694,"删除售货服务失败");

    private final Integer code;
    private final String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

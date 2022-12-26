package com.loops.loopsapi.utils;

import lombok.Data;

@Data
public class APIResponse {
    private Integer status;

    private Long userId;
    private Long merchantId;
    private Long virtualAcc;
    private Object valid;

    public APIResponse(){
        this.status = 200;
        this.userId = getUserId();
        this.merchantId = getMerchantId();
        this.valid = getValid();
        this.virtualAcc = getVirtualAcc();
    }
}

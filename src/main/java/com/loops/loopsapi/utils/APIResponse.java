package com.loops.loopsapi.utils;

import lombok.Data;

@Data
public class APIResponse {
    private Integer status;
    private Long merchantId;
    private Object valid;

    public APIResponse(){
        this.status = 200;
        this.merchantId = getMerchantId();
        this.valid = getValid();
    }
}

package com.loops.loopsapi.user.service;

import lombok.Data;

@Data
public class APIResponse {
    private Integer status;

    private Object valid;

    APIResponse (){
        this.status = 200;
        this.valid = getValid();
    }
}

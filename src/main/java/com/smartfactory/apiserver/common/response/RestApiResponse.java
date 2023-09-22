package com.smartfactory.apiserver.common.response;

import lombok.Data;

@Data
public class RestApiResponse {

    //BaseResponse result;
    String code;
    String message;
    String detail;
    Object data;

    public RestApiResponse() {};
    public RestApiResponse(BaseResponse baseResponse, Object data) {
        //this.result = baseResponse;
        this.code = baseResponse.getCode();
        this.message = baseResponse.getMessage();
        this.detail = baseResponse.getDetail();
        this.data = data;
    }

    public void setResult(BaseResponse baseResponse) {
        this.code = baseResponse.getCode();
        this.message = baseResponse.getMessage();
        this.detail = baseResponse.getDetail();
    }
}

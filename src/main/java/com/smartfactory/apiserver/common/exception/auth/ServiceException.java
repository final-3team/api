package com.smartfactory.apiserver.common.exception.auth;

import com.smartfactory.apiserver.common.response.ApiResponseCode;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ServiceException extends RuntimeException{
    private ApiResponseCode responseCode;
    private String message;

    @Builder
    public ServiceException(ApiResponseCode responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
        this.message = message;
    }

    @Builder
    public ServiceException(String message) {
        super(message);
        this.responseCode = ApiResponseCode.API_SERVICE_ERROR;
        this.message = message;
    }
}

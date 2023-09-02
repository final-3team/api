package com.smartfactory.apiserver.common.response;


public enum ResponseCode {
    SUCCESS("OK", "SUCCESS"),
    CREATED("OK", "CREATED"),
    ACCEPTED("OK", "ACCEPTED"),
    FAILED("FAILED", "UNKNOWN"),
    //Framework Error
    TOKEN_EXPIRED("AUTH_ERR_00", "The access token expired"),
    INVALID_CLIENT_ID("AUTH_ERR_01", "invalid app-id or client-secret"),
    INVALID_PARAMETER_ERROR("AUTH_ERR_02", "invalid parameter error"),
    FAILED_TO_LOGIN("AUTH_ERR_03", "failed to login"),
    API_SERVICE_ERROR("API_SVC_01", "internal server error");

    private String code;
    private String message;

    public String getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }

    ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

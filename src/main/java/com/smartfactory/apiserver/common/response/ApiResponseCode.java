package com.smartfactory.apiserver.common.response;

public enum ApiResponseCode {
    SUCCESS("OK", "SUCCESS"),
    CREATED("OK", "CREATED"),
    ACCEPTED("OK", "ACCEPTED"),
    UNKNWON("API_ERR_01", "occured unknown error"),
    //COMMON
    INVALID_PARAMETER_ERR("COM_ERR_01", "invalid request param"),
    //USER
    INVALID_USER_ID("USER_ERR_01", "invalid user-id"),
    INVALID_USER_ID_OR_PASSWORD("USER_ERR_02", "invalid user-id or invalid password"),
    INVALID_API_ACCESS_TOKEN("USER_ERR_03", "Invalid access_token"),
    ACCESS_TOKEN_EXPIRED("USER_ERR_04", "access token expired"),
    INVALID_CLIENT_ID_OR_CLIENT_SECRET("USER_ERR_05", "invalid client-id or client-secret"),
    NOT_EXIST_SMS_AUTHCODE_REQUEST("USER_ERR_06", "not exist sms auth code"),
    SMS_AUTHCODE_EXPIRED("USER_ERR_07", "sms auth code already expired."),
    INVALID_AUTHCODE("USER_ERR_08", "invalid sms auth code. please check it again"),
    NOT_REGISTERED_BY_KAKAO("USER_ERR_09", "not registered by kakao"),
    NOT_REGISTERED_BY_APPLE("USER_ERR_09_2", "not registered by apple"),
    FAILED_TO_REQUEST_AUTH_SMS("USER_ERR_10", "failed to request auth sms"),
    INVALID_PASSWORD("USER_ERR_11", "invalid password"),
    DUPLICATE_NICKNAME("USER_ERR_12", "duplicate nickname"),
    DUPLICATE_USER_ID("USER_ERR_13", "duplicate user-id"),
    SAME_CURRENT_PASSWORD("USER_ERR_14", "Same as current password."),
    NOT_MATCH_CURRENT_PASSWORD("USER_ERR_15", "not match the current password."),
    NOT_FOUND_USER_ID("USER_ERR_16", "not found user-id"),
    NOT_MATCH_USER_ID_AND_PHONE_NUMBER("USER_ERR_17", "userId and phone number do not match."),

    //BOARD
    INVALID_COMMUNITY_BOARD("BOARD_ERR_01", "invalid community board"),
    //COMMON
    INVALID_TYPE_AND_NAME("CMM_ERR_01", "null params type and name"),
    //FILE
    UNAUTHRIZATION_PATH("FILE_ERR_01", "unauthorization file path"),
    API_SERVICE_ERROR("API_SERVICE_EXCEPTION", "occured api service exception"),
    INVALID__FILE_SEQ("FILE_ERR_02", "invalid file seq");

    /*
     *  500번 에러는 사용자에게 나타내지 않는다. 관련된 500에러는 API서버에서 모두 핸들링해 Error메세지로 return
    //INTERNAL_SERVER_ERROR("ERROR", "internal_server_error");
    */
    private String code;
    private String message;


    public String getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }

    ApiResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

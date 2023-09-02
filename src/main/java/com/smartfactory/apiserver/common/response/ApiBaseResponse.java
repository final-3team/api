package com.smartfactory.apiserver.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Schema(description = "API Base Response")
public class ApiBaseResponse {
    @Schema(description = "코드 정의 값")
    protected String code;
    @Schema(description = "메시지 정의 값")
    protected String message;
    @Schema(description = "에러 발생 시 디테일한 사유")
    protected String detail;

    public ApiBaseResponse() {
    }
    public ApiBaseResponse(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
    @Builder
    public ApiBaseResponse(ResponseCode responseCode, String detail) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.detail = detail;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

}

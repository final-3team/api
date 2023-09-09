package com.smartfactory.apiserver.api.sample.dto;

import com.smartfactory.apiserver.common.response.ApiBaseResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

public class SampleDTO {
    @EqualsAndHashCode(callSuper = true)
    @Data
    public static class GetTBDataResponse extends ApiBaseResponse {
        private Long seq;
        private String name;
    }

    @Data
    @Schema(description = "테스트 디비 데이터 요청")
    public static class GetTBDataRequest{
        @Schema(description = "데이터 시퀀스")
        private Long seq;
        @Schema(description = "이름 정보", required = true)
        @NotBlank(message = "name은 필수 값입니다.")
        private String name;
    }
}

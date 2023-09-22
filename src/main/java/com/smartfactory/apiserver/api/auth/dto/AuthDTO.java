package com.smartfactory.apiserver.api.auth.dto;

import lombok.Builder;
import lombok.Data;

public class AuthDTO {
    @Data
    @Builder
    public static class TokenInfo{
        private String accessToken;
        private String refreshToken;
        private Long refreshTokenExpireAt;
    }
}

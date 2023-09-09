package com.smartfactory.apiserver.api.user.dto;

public class UserDTO {
    public static class SignInRequest{
        private String userId;
        private String password;
    }
    public static class SignInResponse{
        private String userId;
        private String accessToken;
        private String refreshToken;

    }
}

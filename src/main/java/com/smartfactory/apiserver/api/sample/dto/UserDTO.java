package com.smartfactory.apiserver.api.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {
    @Data
    @AllArgsConstructor
    public static class UserResponse{
        private String userId;
        private String userName;
        private String phoneNumber;
        private String emailAddress;
        private String userStatus;
        List<Authority> userAuth = new ArrayList<>();
    }
    @Data
    @AllArgsConstructor
    public static class Authority{
        private String authority;
    }
}

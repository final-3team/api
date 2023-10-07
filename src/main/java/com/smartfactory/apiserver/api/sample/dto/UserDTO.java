package com.smartfactory.apiserver.api.sample.dto;

import com.smartfactory.apiserver.common.constant.CommonCode.UserAuthority;
import com.smartfactory.apiserver.common.constant.CommonCode.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
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
        List<Authority> userAuth;
    }
    @Data
    @AllArgsConstructor
    public static class Authority{
        private String authority;
        private Date createAt;
    }
}

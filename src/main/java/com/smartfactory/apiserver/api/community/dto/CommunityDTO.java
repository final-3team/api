package com.smartfactory.apiserver.api.community.dto;

import com.smartfactory.apiserver.common.constant.CommonCode;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

public class CommunityDTO {

    @Data
    public static class CreatePostRequest{
        @NotBlank
        @NotNull
        private String category;
        @NotBlank
        @NotNull
        private String title;
        @NotBlank
        @NotNull
        private String body;
        @NotBlank
        private String password;
    }
}

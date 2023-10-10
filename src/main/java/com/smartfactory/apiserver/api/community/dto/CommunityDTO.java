package com.smartfactory.apiserver.api.community.dto;

import com.smartfactory.apiserver.common.constant.CommonCode;
import com.smartfactory.apiserver.domain.database.entity.CommentEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

import static com.smartfactory.apiserver.common.constant.CommonCode.*;

public class CommunityDTO {

    @Data
    public static class CreatePostRequest{
        @NotEmpty
        private String category;
        @NotEmpty
        private String title;
        @NotEmpty
        private String body;
       /* @NotBlank
        private String password;*/
    }

    @Data
    public static class UpdatePostRequest{
        @NotEmpty
        private Long postSeq;
        @NotEmpty
        private String category;
        @NotEmpty
        private String title;
        @NotEmpty
        private String body;
        //private String password;
    }

    @Data
    public static class ReadPostAndCommentsRequest{
        @NotNull
        private Long postSeq;
    }

    @Data
    @Builder
    public static class ReadPostAndCommentsResponse{
        private String userName;
        private String category;
        private String title;
        private String body;
        private List<Comment> comments;
    }

    @Data
    @Builder
    public static class Comment{
        private String content;
        private String userName;
        private Date updateAt;
    }

    @Data
    public static class ReadPostListRequest{
        private Long page;
    }
    @Data
    @Builder
    public static class ReadPostListResponse{
        private List<Post> posts;
    }

    @Data
    public static class Post{
        private String title;
        private String userName;
        private Long postSeq;
    }

    @Data
    public static class CreateCommentRequest{
        @NotEmpty
        private Long postSeq;
        @NotEmpty
        private String content;
    }

    @Data
    public static class UpdateCommentRequest{

    }




}

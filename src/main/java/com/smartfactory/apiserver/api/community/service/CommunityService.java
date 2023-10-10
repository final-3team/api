package com.smartfactory.apiserver.api.community.service;

import com.smartfactory.apiserver.api.community.dto.CommunityDTO;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.*;

public interface CommunityService {
    void createPost(CreatePostRequest createPostRequest);
    void updatePost(UpdatePostRequest updatePostRequest);

    ReadPostAndCommentsResponse readPostAndComments(ReadPostAndCommentsRequest readPostAndCommentsRequest);

    ReadPostListResponse readPostList(ReadPostListRequest readPostListRequest);

    void createComment(CreateCommentRequest createCommentRequest);
    void updateComment(UpdateCommentRequest updateCommentRequest);

}

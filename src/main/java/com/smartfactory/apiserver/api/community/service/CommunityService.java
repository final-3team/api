package com.smartfactory.apiserver.api.community.service;

import com.smartfactory.apiserver.api.community.dto.CommunityDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.*;

public interface CommunityService {
    void createPost(CreatePostRequest createPostRequest);

    ReadPostAndCommentsResponse readPostAndComments(ReadPostAndCommentsRequest readPostAndCommentsRequest);
    void updatePost(UpdatePostRequest updatePostRequest);

    void deletePost(DeletePostRequest deletePostRequest);


/*    ReadPostListResponse readPostList(ReadPostListRequest readPostListRequest);*/

    void createComment(CreateCommentRequest createCommentRequest);
    void updateComment(UpdateCommentRequest updateCommentRequest);

    Page<ReadPostListResponse> getPosts(Pageable pageable);

}

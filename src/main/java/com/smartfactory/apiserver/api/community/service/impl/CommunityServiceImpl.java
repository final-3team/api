package com.smartfactory.apiserver.api.community.service.impl;


import com.smartfactory.apiserver.api.community.service.CommunityService;
import com.smartfactory.apiserver.common.exception.BusinessException;
import com.smartfactory.apiserver.common.jwt.JwtTokenProvider;
import com.smartfactory.apiserver.common.response.ApiResponseCode;
import com.smartfactory.apiserver.domain.database.entity.CommentEntity;
import com.smartfactory.apiserver.domain.database.entity.PostEntity;
import com.smartfactory.apiserver.domain.database.entity.UserEntity;
import com.smartfactory.apiserver.domain.database.repository.CommentRepository;
import com.smartfactory.apiserver.domain.database.repository.PostRepository;
import com.smartfactory.apiserver.domain.database.repository.UserRepository;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.*;
import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Service("communityService")
@RequiredArgsConstructor
@Slf4j
public class CommunityServiceImpl implements CommunityService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CustomPostRepository customPostRepository;


    @Override
    @Transactional
    public void createPost(CreatePostRequest createPostRequest) {
//        jwtTokenProvider.getAuthentication("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0MTIzNDUiLCJhdXRoIjoiUk9MRV9HRU5FUkFMIiwiZXhwIjoxODI1Mzk3MDMxfQ.GpCOnt-maW8g5u539TIDIf1zNa1Rs_ABKMkub8_eVX4caldH_UQlpVk1Ce9t4YpxLm5_2nhF4vZaQKQTCZtB3Q").getName()

        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            PostEntity postEntity = PostEntity.builder()
                    .user(loadUserByUsername(auth.getName()))
                    .category(PostCategory.valueOf(createPostRequest.getCategory()))
                    .title(createPostRequest.getTitle())
                    .body(createPostRequest.getBody())
                    .status(PostStatus.ACTIVE)
//                    .password(createPostRequest.getPassword())
                    .build();
            postEntity = postRepository.save(postEntity);
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_SIGN_UP_USER, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public void updatePost(UpdatePostRequest updatePostRequest) {

        try{
            PostEntity postEntity = validByTokenIdAndPostOwner(updatePostRequest.getPostSeq());

            postEntity.setCategory(PostCategory.valueOf(updatePostRequest.getCategory()));
            postEntity.setTitle(updatePostRequest.getTitle());
            postEntity.setBody(updatePostRequest.getBody());

            postRepository.save(postEntity);
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_TO_FIND_POST, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public void deletePost(DeletePostRequest deletePostRequest) {
        try{
            PostEntity postEntity = validByTokenIdAndPostOwner(deletePostRequest.getPostSeq());

            postEntity.setStatus(PostStatus.INACTIVE);

            postRepository.save(postEntity);
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_TO_DELETE_POST, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ReadPostAndCommentsResponse readPostAndComments(ReadPostAndCommentsRequest readPostAndCommentsRequest) {
        PostEntity postEntity = postRepository.findById(readPostAndCommentsRequest.getPostSeq()).orElseThrow(() -> new BusinessException(ApiResponseCode.FAILED_TO_FIND_POST, HttpStatus.BAD_REQUEST));
        List<CommentEntity> commentEntityList = postEntity.getCommentEntityList();
        List<Comment> commentList = new ArrayList<>();

        for (CommentEntity commentEntity : commentEntityList) {
            Comment comment = Comment.builder()
                    .content(commentEntity.getContent())
                    .userName(commentEntity.getUser().getUserName())
                    .updateAt(commentEntity.getUpdateAt())
                    .build();
            commentList.add(comment);
        }

        ReadPostAndCommentsResponse response = ReadPostAndCommentsResponse.builder()
                .userName(postEntity.getUser().getUserName())
                .category(postEntity.getCategory().toString())
                .title(postEntity.getTitle())
                .body(postEntity.getBody())
                .build();

        response.setComments(commentList);

        return response;
    }

/*
    @Override
    @Transactional(readOnly = true)
    public ReadPostListResponse readPostList(ReadPostListRequest readPostListRequest) {
        return customPostRepository.findPostListByFromNum(readPostListRequest.getPage());
    }
*/

    @Override
    @Transactional
    public void createComment(CreateCommentRequest createCommentRequest) {
        try{
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            CommentEntity comment = CommentEntity.builder()
                    .user(loadUserByUsername(auth.getName()))
                    .post(postRepository.getById(createCommentRequest.getPostSeq()))
                    .content(createCommentRequest.getContent())
                    .build();
            comment = commentRepository.save(comment);
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_SIGN_UP_USER, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional
    public void updateComment(UpdateCommentRequest updateCommentRequest) {

    }

    @Override
    public Page<ReadPostListResponse> getPosts(Pageable pageable) {
        return customPostRepository.findPosts(pageable);
    }


    @Transactional(readOnly = true)
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntityByUserId(username).orElseThrow( () -> new BusinessException(ApiResponseCode.FAILED_SIGN_IN_USER, HttpStatus.BAD_REQUEST));
        return userEntity;
    }
    
    
    //post의 작성자와 token의 주인이 동일 user인지 판별하는 메서드
    @Transactional(readOnly = true)
    public PostEntity validByTokenIdAndPostOwner(Long postSeq) throws UsernameNotFoundException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userEntity = userRepository.findUserEntityByUserId(auth.getName()).orElseThrow(() -> new BusinessException(ApiResponseCode.FAILED_SIGN_IN_USER, HttpStatus.BAD_REQUEST));
        PostEntity postEntity = postRepository.findById(postSeq).orElseThrow(() -> new BusinessException(ApiResponseCode.FAILED_TO_FIND_POST, HttpStatus.BAD_REQUEST));
        if(!postEntity.getUser().equals(userEntity)){
            new BusinessException(ApiResponseCode.INVALID_CLIENT_ID_OR_CLIENT_SECRET, HttpStatus.BAD_REQUEST);
        }
        return postEntity;
    }

}

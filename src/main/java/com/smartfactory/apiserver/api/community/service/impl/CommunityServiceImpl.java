package com.smartfactory.apiserver.api.community.service.impl;


import com.smartfactory.apiserver.api.community.dto.CommunityDTO;
import com.smartfactory.apiserver.api.community.service.CommunityService;
import com.smartfactory.apiserver.common.constant.CommonCode;
import com.smartfactory.apiserver.common.exception.BusinessException;
import com.smartfactory.apiserver.common.jwt.JwtTokenProvider;
import com.smartfactory.apiserver.common.response.ApiResponseCode;
import com.smartfactory.apiserver.domain.database.entity.PostEntity;
import com.smartfactory.apiserver.domain.database.entity.UserEntity;
import com.smartfactory.apiserver.domain.database.repository.CommentRepository;
import com.smartfactory.apiserver.domain.database.repository.PostRepository;
import com.smartfactory.apiserver.domain.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.*;
import static com.smartfactory.apiserver.common.constant.CommonCode.*;

@Service("communityService")
@RequiredArgsConstructor
@Slf4j
public class CommunityServiceImpl implements CommunityService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    private final JwtTokenProvider jwtTokenProvider;


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
                    .password(createPostRequest.getPassword())
                    .build();
            postEntity = postRepository.save(postEntity);
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(ApiResponseCode.FAILED_SIGN_UP_USER, HttpStatus.BAD_REQUEST);
        }
    }


    @Transactional(readOnly = true)
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserEntityByUserId(username).orElseThrow( () -> new BusinessException(ApiResponseCode.FAILED_SIGN_IN_USER, HttpStatus.BAD_REQUEST));
        return userEntity;
    }
}
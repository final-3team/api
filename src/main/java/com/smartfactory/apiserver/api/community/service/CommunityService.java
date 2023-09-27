package com.smartfactory.apiserver.api.community.service;

import com.smartfactory.apiserver.api.community.dto.CommunityDTO;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.*;

public interface CommunityService {
    void createPost(CreatePostRequest createPostRequest);

}

package com.smartfactory.apiserver.domain.database.repository.custom;

import com.smartfactory.apiserver.api.community.dto.CommunityDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.*;
import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.ReadPostListResponse;

public interface CustomPostRepository {

    Page<ReadPostListResponse> findPosts(Pageable pageable);

}

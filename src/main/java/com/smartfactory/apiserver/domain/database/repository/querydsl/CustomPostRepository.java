package com.smartfactory.apiserver.domain.database.repository.querydsl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.ReadPostListResponse;

public interface CustomPostRepository {
    ReadPostListResponse findPostListByFromNum(Long fromNum);

    Page<ReadPostListResponse> findPosts(Pageable pageable);
}

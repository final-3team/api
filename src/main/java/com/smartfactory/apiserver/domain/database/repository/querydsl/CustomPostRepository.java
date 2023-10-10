package com.smartfactory.apiserver.domain.database.repository.querydsl;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.ReadPostListResponse;

public interface CustomPostRepository {
    ReadPostListResponse findPostListByFromNum(Long fromNum);
}

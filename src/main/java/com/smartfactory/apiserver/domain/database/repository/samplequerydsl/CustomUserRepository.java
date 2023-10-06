package com.smartfactory.apiserver.domain.database.repository.querydsl;


import static com.smartfactory.apiserver.api.sample.dto.SampleDTO.*;

public interface CustomUserRepository {
    SampleResponse findUserInfoByUserSeq(Long userSeq);
}

package com.smartfactory.apiserver.domain.database.repository.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.smartfactory.apiserver.domain.database.entity.QUserAuthorityEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.types.Projections.list;
import static com.smartfactory.apiserver.api.sample.dto.SampleDTO.*;

@Repository
@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public SampleResponse findUserInfoByUserSeq(Long userSeq) {
        return null;
    }
}

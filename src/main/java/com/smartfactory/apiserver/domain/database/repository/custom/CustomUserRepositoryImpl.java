package com.smartfactory.apiserver.domain.database.repository.custom;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;

import com.smartfactory.apiserver.api.sample.dto.UserDTO.Authority;
import com.smartfactory.apiserver.api.sample.dto.UserDTO.UserResponse;

import com.smartfactory.apiserver.domain.database.entity.QUserAuthorityEntity;
import com.smartfactory.apiserver.domain.database.entity.QUserEntity;

import com.smartfactory.apiserver.domain.database.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

import java.util.List;

import static com.smartfactory.apiserver.api.sample.dto.SampleDTO.*;

@Slf4j
@Repository
public class CustomUserRepositoryImpl extends QuerydslRepositorySupport implements CustomUserRepository {

    public CustomUserRepositoryImpl() {
        super(UserEntity.class);
    }

    @Override
    public SampleResponse findUserInfoByUserSeq(Long userSeq) {
        return null;
    }

    public Page<UserResponse> findUsers(Pageable pageable){
        try {

            QUserEntity userEntity = QUserEntity.userEntity;
            QUserAuthorityEntity authorityEntity = QUserAuthorityEntity.userAuthorityEntity;

            List<UserResponse> result = (List<UserResponse>)from(userEntity)
                    .leftJoin(authorityEntity).on(userEntity.userSeq.eq(authorityEntity.user.userSeq))
                    .orderBy(userEntity.userSeq.asc())
                    .limit(pageable.getPageSize())
                    .offset(pageable.getPageSize() * pageable.getPageNumber())
                    .transform(groupBy(userEntity.userSeq).list(Projections.constructor(UserResponse.class
                            , userEntity.userId
                            , userEntity.userName
                            , userEntity.phoneNumber
                            , userEntity.emailAddress
                            , userEntity.userStatus.stringValue()
                            , list(Projections.constructor(Authority.class,
                                    authorityEntity.authority.stringValue(),
                                    authorityEntity.createAt)
                            )
                    )));

            JPQLQuery<Long> count = from(userEntity)
                    .select(userEntity.count());
            long totalCount = count.fetchCount();
            log.debug("");

            return new PageImpl<>(result, pageable, totalCount);
        }catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

}

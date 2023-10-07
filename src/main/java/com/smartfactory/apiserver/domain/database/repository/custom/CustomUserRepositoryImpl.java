package com.smartfactory.apiserver.domain.database.repository.custom;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.smartfactory.apiserver.domain.database.entity.QUserAuthorityEntity;
import com.smartfactory.apiserver.api.sample.dto.UserDTO;
import com.smartfactory.apiserver.api.sample.dto.UserDTO.UserResponse;
import com.smartfactory.apiserver.common.constant.CommonCode.UserStatus;
import com.smartfactory.apiserver.domain.database.entity.QUserAuthorityEntity;
import com.smartfactory.apiserver.domain.database.entity.QUserEntity;
import com.smartfactory.apiserver.domain.database.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.types.Projections.list;
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

            JPQLQuery<UserEntity> jpqlQuery = from(userEntity);
            jpqlQuery.leftJoin(authorityEntity).on(userEntity.eq(authorityEntity.user));

            JPQLQuery<Tuple> tuple = jpqlQuery.select(userEntity, authorityEntity);
            //tuple.groupBy(userEntity);
            List<Tuple> result = tuple.fetch();
            log.debug("");

            /*JPQLQuery<UserResponse> query = from(userEntity)
                    .select(Projections.constructor(UserResponse.class
                            , userEntity.userId
                            , userEntity.userName
                            , userEntity.phoneNumber
                            , userEntity.emailAddress
                            , userEntity.userStatus
                    ))
                    .innerJoin(userEntity).on(authorityEntity.user.userSeq.eq(userEntity.userSeq))
                    .where(userEntity.userStatus.eq(UserStatus.USE))
                    .orderBy(userEntity.userSeq.desc())
                    .limit(pageable.getPageSize())
                    .offset(pageable.getPageSize() * pageable.getPageNumber());
            List<UserResponse> items = query.fetch();*/

                    /*
                    private String userId;
            private String userName;
            private String phoneNumber;
            private String emailAddress;
            private String userStatus;
            List<Authority> userAuth = new ArrayList<>();
                     */
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
}

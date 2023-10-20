package com.smartfactory.apiserver.domain.database.repository.custom;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.smartfactory.apiserver.common.constant.CommonCode;
import com.smartfactory.apiserver.domain.database.entity.PostEntity;
import com.smartfactory.apiserver.domain.database.entity.QPostEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;
import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.ReadPostListResponse;


@Repository
@Slf4j
public class CustomPostRepositoryImpl extends QuerydslRepositorySupport implements CustomPostRepository {

    public CustomPostRepositoryImpl() {
        super(PostEntity.class);
    }

   /* @Override
    public ReadPostListResponse findPostListByFromNum(Long fromNum) {


        *//*
            JPAQueryFactory를 이용한 방법으로 spring에서 제공하는 QuerydslRepositorySupport의 방식으로 변경하기 위해 주석처리한다.

        List<Tuple> results = queryFactory
                .select(postEntity.title,
                        postEntity.postSeq,
                        postEntity.user.userName
                        )
                .from(postEntity)
                .where(postEntity.status.eq(CommonCode.PostStatus.ACTIVE))
                .orderBy(postEntity.createAt.desc())
                .offset(fromNum * 10)
                .limit(10)
                .fetch();*//**//*
        List<Post> results = queryFactory
                .select(Projections.bean(Post.class,
                        postEntity.title,
                        postEntity.user.userName,
                        postEntity.postSeq
                        ))
                .from(postEntity)
                .where(postEntity.status.eq(CommonCode.PostStatus.ACTIVE))
                .orderBy(postEntity.createAt.desc())
                .offset(fromNum * 10)
                .limit(10)
                .fetch();

        return ReadPostListResponse.builder().posts(results).build();*//*
        return null;

    }*/

    @Override
    @Transactional(readOnly = true)
    public Page<ReadPostListResponse> findPosts(Pageable pageable) {
        try {
            QPostEntity postEntity = QPostEntity.postEntity;
            List<ReadPostListResponse> result = (List<ReadPostListResponse>) from(postEntity)
                    .where(postEntity.status.eq(CommonCode.PostStatus.ACTIVE))
                    .orderBy(postEntity.createAt.desc())
                    .offset(pageable.getPageNumber() * pageable.getPageSize())
                    .limit(pageable.getPageSize())
                    .transform(groupBy(postEntity.postSeq).list(Projections.constructor(ReadPostListResponse.class
                            , postEntity.title
                            , postEntity.user.userName
                            , postEntity.postSeq)));

            JPQLQuery<Long> count = from(postEntity).where(postEntity.status.eq(CommonCode.PostStatus.ACTIVE)).select(postEntity.count());
            long totalCount = count.fetchCount();


            return new PageImpl<>(result, pageable, totalCount);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }


}

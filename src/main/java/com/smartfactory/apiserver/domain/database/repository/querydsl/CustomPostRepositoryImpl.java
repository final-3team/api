package com.smartfactory.apiserver.domain.database.repository.querydsl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.smartfactory.apiserver.common.constant.CommonCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.Post;
import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.ReadPostListResponse;
import static com.smartfactory.apiserver.domain.database.entity.QPostEntity.postEntity;


@Repository
@RequiredArgsConstructor
public class CustomPostRepositoryImpl implements CustomPostRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public ReadPostListResponse findPostListByFromNum(Long fromNum) {


        /*List<Tuple> results = queryFactory
                .select(postEntity.title,
                        postEntity.postSeq,
                        postEntity.user.userName
                        )
                .from(postEntity)
                .where(postEntity.status.eq(CommonCode.PostStatus.ACTIVE))
                .orderBy(postEntity.createAt.desc())
                .offset(fromNum * 10)
                .limit(10)
                .fetch();*/
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

        System.out.println("----------------------------------------------------------------------");
        System.out.println("querydsl문 결과");
        System.out.println(results);
        System.out.println(ReadPostListResponse.builder().posts(results).build());
        return ReadPostListResponse.builder().posts(results).build();

    }
}

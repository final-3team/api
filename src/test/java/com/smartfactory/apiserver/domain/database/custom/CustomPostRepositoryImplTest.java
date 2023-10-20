package com.smartfactory.apiserver.domain.database.custom;


import com.smartfactory.apiserver.api.community.dto.CommunityDTO;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepository;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
//@ActiveProfiles("com.mysql.cj.jdbc.Driver")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomPostRepositoryImplTest {



    @Autowired
    CustomPostRepository customPostRepository;

    @Test
    @Transactional(readOnly = true)
    void findPostList(){
        Page<CommunityDTO.ReadPostListResponse> result = customPostRepository.findPosts(PageRequest.of(1, 1));
        log.error(String.valueOf(result.getContent().get(0).getPostSeq()));

        //System.out.println(customPostRepository.findPosts(Pageable.ofSize(10)).toString());
        System.out.println("하");
    }
}

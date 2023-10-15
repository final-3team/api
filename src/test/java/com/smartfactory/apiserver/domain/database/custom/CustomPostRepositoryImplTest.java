package com.smartfactory.apiserver.domain.database.custom;


import com.smartfactory.apiserver.api.community.dto.CommunityDTO;
import com.smartfactory.apiserver.config.database.DataSourceConfiguration;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepository;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest                //해당 테스트에 deafult DB가 in-memory DB라 설정이 필요함.
//@ActiveProfiles("com.mysql.cj.jdbc.Driver")
@ImportAutoConfiguration({DataSourceConfiguration.class, CustomPostRepositoryImpl.class})
public class CustomPostRepositoryImplTest {


    @Autowired
    CustomPostRepository customPostRepository;

    @Test
    @Transactional(readOnly = true)
    void findPostList(){
        Page<CommunityDTO.ReadPostListResponse> result = customPostRepository.findPosts(PageRequest.of(1, 10));
        System.out.println("하");
    }
}

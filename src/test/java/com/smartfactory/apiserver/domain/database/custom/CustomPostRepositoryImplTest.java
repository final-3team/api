package com.smartfactory.apiserver.domain.database.custom;


import com.smartfactory.apiserver.api.community.dto.CommunityDTO;
import com.smartfactory.apiserver.config.database.DataSourceConfiguration;
import com.smartfactory.apiserver.domain.database.entity.StoreContractEntity;
import com.smartfactory.apiserver.domain.database.repository.StoreContractRepository;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepository;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
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

import java.util.Optional;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest                //해당 테스트에 deafult DB가 in-memory DB라 설정이 필요함.
//@ActiveProfiles("com.mysql.cj.jdbc.Driver")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ImportAutoConfiguration({DataSourceConfiguration.class, CustomPostRepositoryImpl.class})
@Slf4j
public class CustomPostRepositoryImplTest {



    @Autowired
    CustomPostRepository customPostRepository;

    @Autowired
    StoreContractRepository storeContractRepository;

    @Test
    @Transactional(readOnly = true)
    void findPostList(){
//        Page<CommunityDTO.ReadPostListResponse> result = customPostRepository.findPosts(PageRequest.of(1, 1));
//        log.error(String.valueOf(result.getContent().get(0).getPostSeq()));


        log.error(String.valueOf(storeContractRepository.findById(1L).equals(null)));
        //System.out.println(customPostRepository.findPosts(Pageable.ofSize(10)).toString());

    }
}

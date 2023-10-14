package com.smartfactory.apiserver.domain.database.custom;


import com.smartfactory.apiserver.api.community.dto.CommunityDTO;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepository;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomPostRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
//@ActiveProfiles("com.mysql.cj.jdbc.Driver")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomPostRepositoryImplTest {



    @Autowired
    CustomPostRepository customPostRepository;

    @Test
    @Transactional(readOnly = true)
    void findPostList(){
        //System.out.println(customPostRepository.findPosts(Pageable.ofSize(10)).toString());
        System.out.println("하");
    }
}

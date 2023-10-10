package com.smartfactory.apiserver.domain.database.repository.custom;

import com.smartfactory.apiserver.api.sample.dto.UserDTO;
import com.smartfactory.apiserver.api.sample.dto.UserDTO.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.smartfactory.apiserver.api.sample.dto.SampleDTO.*;

public interface CustomUserRepository {
    SampleResponse findUserInfoByUserSeq(Long userSeq);

    Page<UserResponse> findUsers(Pageable pageable);
}

package com.smartfactory.apiserver.api.auth.service;

import com.smartfactory.apiserver.api.auth.dto.AuthDTO.SignInRequest;
import com.smartfactory.apiserver.api.auth.dto.AuthDTO.SignUpRequest;
import com.smartfactory.apiserver.api.auth.dto.AuthDTO.TokenInfo;
import com.smartfactory.apiserver.api.sample.dto.UserDTO.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthService {
    void signUp(SignUpRequest signUpRequest);
    TokenInfo signIn(SignInRequest signInRequest);

    Page<UserResponse> getUsers(Pageable pageable);
}

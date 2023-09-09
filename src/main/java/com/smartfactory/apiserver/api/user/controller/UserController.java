package com.smartfactory.apiserver.api.user.controller;


import com.smartfactory.apiserver.api.sample.dto.SampleDTO;
import com.smartfactory.apiserver.common.response.ResponseCode;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "사용자 API", description = "사용자 API")
@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    @PostMapping(value ="/sign-in", produces = "application/json")
    public ResponseEntity<?> signinUser(@RequestParam Long seq){
        try {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @GetMapping(value = "user-info", produces = "application/json")
    public ResponseEntity<?> getUserInformation(){
        return null;
    }
}

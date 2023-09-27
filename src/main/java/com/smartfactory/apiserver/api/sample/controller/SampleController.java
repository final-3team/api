package com.smartfactory.apiserver.api.sample.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class SampleController {
    @GetMapping(value = "user-info", produces = "application/json")
    public ResponseEntity<?> getUserInformation(@RequestParam Long userSeq) {
        return null;
    }


}

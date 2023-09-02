package com.smartfactory.apiserver.api.controller;

import com.smartfactory.apiserver.api.dto.SampleDTO.GetTBDataRequest;
import com.smartfactory.apiserver.api.dto.SampleDTO.GetTBDataResponse;
import com.smartfactory.apiserver.api.service.SampleService;
import com.smartfactory.apiserver.api.service.impl.SampleServiceImpl;
import com.smartfactory.apiserver.common.response.ResponseCode;
import com.smartfactory.apiserver.domain.database.entity.TBTestEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "샘플 API", description = "샘플 API")
@RestController
@RequestMapping("/sample")
@Slf4j
@RequiredArgsConstructor
public class SampleController {
    private final SampleService sampleService;
    @GetMapping(value ="get-test", produces = "application/json")
    public ResponseEntity<?> getTestData(@RequestParam Long seq){
        try {
            GetTBDataResponse response = sampleService.getTestDataBySeq(seq);
            response.setResponseCode(ResponseCode.SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }


    @PostMapping(value ="get-test", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "테스트 데이터 조회 API", description = "테스트 DB의 샘플 데이터를 조회한다.")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200"
                    , description = "조회성공", content = @Content(schema = @Schema(implementation = GetTBDataResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401"
                    , description = "에러", content = @Content(schema = @Schema(implementation = GetTBDataResponse.class)))
    })
    public ResponseEntity<?> getTestDataPost(@RequestBody @Validated GetTBDataRequest request){
        try {
            GetTBDataResponse response = sampleService.getTestDataBySeq(request.getSeq());
            response.setResponseCode(ResponseCode.SUCCESS);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }



}

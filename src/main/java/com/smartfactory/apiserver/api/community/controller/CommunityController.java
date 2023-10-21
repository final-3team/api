package com.smartfactory.apiserver.api.community.controller;


import com.smartfactory.apiserver.api.community.service.CommunityService;
import com.smartfactory.apiserver.common.response.ApiResponseCode;
import com.smartfactory.apiserver.common.response.BaseResponse;
import com.smartfactory.apiserver.common.response.RestApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.smartfactory.apiserver.api.community.dto.CommunityDTO.*;

@RestController
@RequestMapping("/api/v2/community")
@Slf4j
@RequiredArgsConstructor
public class
CommunityController {
    private final CommunityService communityService;


    @PostMapping(value = "/post", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createPost(@Valid @RequestBody CreatePostRequest createPostRequest) {
        communityService.createPost(createPostRequest);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS));
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/post")
    public ResponseEntity<?> getPost(@Valid ReadPostAndCommentsRequest readPostAndCommentsRequest) {
        ReadPostAndCommentsResponse response = communityService.readPostAndComments(readPostAndCommentsRequest);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS), response);
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/post", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePost(@Valid @RequestBody UpdatePostRequest updatePostRequest) {
        communityService.updatePost(updatePostRequest);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS));
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/post")
    public ResponseEntity<?> deletePost(@Valid DeletePostRequest deletePostRequest) {
        communityService.deletePost(deletePostRequest);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS));
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/comment", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createComment(@Valid @RequestBody CreateCommentRequest createCommentRequest) {
        communityService.createComment(createCommentRequest);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS));
        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }

    /*
        pageable 방식아님
    @GetMapping(value = "/postList", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> GetPostList(@Valid ReadPostListRequest readPostListRequest){
        ReadPostListResponse response =  communityService.readPostList(readPostListRequest);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS), response);

        return new ResponseEntity<>(restApiResponse,HttpStatus.OK);
    }*/

    @GetMapping(value = "/postList")
    public ResponseEntity<?> getPostList(@PageableDefault(size = 10) Pageable pageable) {
//        Page<ReadPostListResponse> response = communityService.getPosts(pageable);
        Page<ReadPostListResponse> response = communityService.getPosts(pageable);
        RestApiResponse restApiResponse = new RestApiResponse();
        restApiResponse.setResult(new BaseResponse(ApiResponseCode.SUCCESS), response);

        return new ResponseEntity<>(restApiResponse, HttpStatus.OK);
    }



/*    @GetMapping(value = "/test/inventoryStatus")
    @ResponseBody
    public ResponseEntity<?> test1234(){

    }*/


}

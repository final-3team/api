package com.smartfactory.apiserver;

import com.smartfactory.apiserver.api.community.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("API 테스트 케이스")
@SpringBootTest
@Slf4j
class ApiServerApplicationTests {

	@Autowired
	private CommunityService communityService;
	@Test
	@Order(1)
	@ExtendWith(InterceptorExtentionTest.class)
	void contextLoads() {

	}

	@BeforeEach
	void beforeEach(){
		System.out.println("각 테스트 들이 실행되기전 선 실행되어야하는 내용 처리");
		//@BeforeAll 각 테스트 메소드마다 한번만 실행
	}
	@DisplayName("포스트 목록 조회 테스트")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4})
	@Order(2)
	void getPostsTest(int page){
		communityService.getPosts(PageRequest.of(page, 1));
		System.out.println("page : " + String.valueOf(page));
		assertTrue(page >= 1 && page <= 4);
	}

	@AfterEach
	void afterEach(){
		System.out.println("각 테스트 들이 실행된 후 실행되어야하는 내용 처리");
		//@AfterAll  각 테스트 메소드마다 한번만 실행
	}
}

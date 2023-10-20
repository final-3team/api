package com.smartfactory.apiserver;

<<<<<<< HEAD
import com.smartfactory.apiserver.api.community.dto.CommunityDTO;
import com.smartfactory.apiserver.api.community.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
=======
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
>>>>>>> parent of 6bc681d (junit 테스트 코드 update)

@SpringBootTest
class ApiServerApplicationTests {

	@Test
	void contextLoads() {
	}

<<<<<<< HEAD
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
		Page<CommunityDTO.ReadPostListResponse> result = communityService.getPosts(PageRequest.of(page, 1));
		Assertions.assertEquals(15 - page, result.getContent().get(0).getPostSeq());		//게시판 seq 번호 확인
		assertEquals(result.getContent().get(0).getUserName(), "테스터2");			//게시판 작성자가 같은지
//		assertTrue(page >= 1 && page <= 4);
	}

	@AfterEach
	void afterEach(){
		System.out.println("각 테스트 들이 실행된 후 실행되어야하는 내용 처리");
		//@AfterAll  각 테스트 메소드마다 한번만 실행
	}
=======
>>>>>>> parent of 6bc681d (junit 테스트 코드 update)
}

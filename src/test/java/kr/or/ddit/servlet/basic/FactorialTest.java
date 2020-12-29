package kr.or.ddit.servlet.basic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactorialTest {
	
	/*  @Test : 테스트 메소드에 붇이는 어노테이션
	 			해당 어느테이션을 붙이지 않으면 테스트 메소드로 인식되지 않음(메스트 대상에서 제외)
				
				제한사항
	 			1. 메소드 시그니처를 정해진대로 구성해야 함
	 				접근제어자 : public
	 				반환타입 : void
	 				인자 : 없음
	 				
	 			테스트 메소드 통과조건
	 			1. 테스트 메소드를 실행하는 과정에서 예외가 없이 끝까지 실행된 경우
	 			2. assert 구문이 있을 경우 assert 구문이 전부 통과 했을 떼 (참으로 인정 되었을 때)
	 	
	 	@Before : 초기화 메소드에 붇이는 어노테이션 
	 			@Test 어노테이션이 붇은 테스트 메소드를 호출하기 전에 먼저 실행됨
	 			@Bofore ==> @Test (test) 
	 			@Bofore ==> @Test (test2) 
	 			@Bofore ==> @Test (test3) 
	 	
	 	@After : @Test 메소드 실행 이후에 실행된 메소드에 붇이는 어노테이션
	 			자원 해제를 주로 담당
	 			
	 	@BeforeClass, @AfterClass
	 		클래스 단위로 최초 1회씩 호출되는 메소드
	 		@BeforeClass
	 			@Bofore ==> @Test (test) ==> @After 
	 			@Bofore ==> @Test (test2) ==> @After 
	 			@Bofore ==> @Test (test3) ==> @After
	 		@AfterClass
	 		제한사항 : static 메소드로 선언을 해야 함
	 				==> 해당 메소드에소 사용하는 필드는 static 필드여야 함 ==> 사용 빈도가 떨어지는 원인 
	 		
	 */
	private static final Logger logger = LoggerFactory.getLogger(FactorialTest.class);

	private Facotrial factorial;
	
	@Before 
	public void setup() {
		logger.debug("setup()");
		factorial = new Facotrial();
		
	}
	
	@Test
	public void test() {
		logger.debug("test()");
		/***Given***/ // 현재 테스트 환경에서 주어신 조건을 기술

		/***When***/  // 테스트를 검증하고자 하는 행위(method call)
		int result = factorial.calculate(5);
		
		/***Then***/  // 코드를 실행한 경과와 예상한 값이 일치하는지 검증
		assertEquals(100, result);
	}
	
	@Test
	public void test2() {
		logger.debug("test2()");
		/***Given***/ // 현재 테스트 환경에서 주어신 조건을 기술
		
		/***When***/  // 테스트를 검증하고자 하는 행위(method call)
		int result = factorial.calculate(0);
		
		/***Then***/  // 코드를 실행한 경과와 예상한 값이 일치하는지 검증
		assertEquals(1, result);
	}
	
	@Test
	public void test3() {
		logger.debug("test3()");
		/***Given***/ // 현재 테스트 환경에서 주어신 조건을 기술
		
		/***When***/  // 테스트를 검증하고자 하는 행위(method call)
		int result = factorial.calculate(3);
		
		/***Then***/  // 코드를 실행한 경과와 예상한 값이 일치하는지 검증
		assertEquals(6, result);
	}

}

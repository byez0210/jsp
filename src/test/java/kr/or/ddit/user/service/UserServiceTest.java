package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServiceTest {
	private UserServiceI userService;
	// 전체 사용자 조회 테스트
	@Before
	public void setup() {
		userService = new UserService();
		
		//테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("testUser","테스트사용자", "testUserPass", new Date(), "대덕","대전 중구 중앙로 76","4층","34940","brown.png","uuid=generated-filename.png");
		userService.registUser(userVo);
		
		//신규 입력 테스트를  위해 테스트 과정에서 입력된 테이터를 삭제
		userService.deleteUser("ddit2");
	}
	
	@After 
	public void tearDown() {
		userService.deleteUser("testUser");
	}
	
	@Test
	public void selectAllUsertest() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userService.selectAllUser();
		
		/***Then***/
		assertEquals(21, userList.size());
	}
	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	@Test
	public void selectUserTest() {
		/***Given***/
		String userid = "brown";

		/***When***/
		UserVo user = userService.selectUser(userid);
		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}
	
	// 사용자 아이디가 존재하지 않을 떄, 특정 사용자 조회
	@Test
	public void selectUserNotExsistTest() {
		/***Given***/
		String userid = "brownNotexsist";
		
		/***When***/
		UserVo user = userService.selectUser(userid);
		/***Then***/
		assertNull(user);

	}

	// 사용자 페이징 조회 테스트
	@Test
	public void selectPagingUser() {
		/***Given***/
		PageVo  vo = new PageVo(2,5);
		
		/***When***/
		Map<String, Object>  map = userService.selectPagingUser(vo);
		List<UserVo> userList = (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
		int pagination = (int) Math.ceil((double)userCnt/vo.getPageSize());
//		System.out.println(pagination);
		
		/***Then***/
		assertEquals(5, pagination);
		assertEquals(21, userCnt);
	}
	
	@Test
	public void modifyUserTest() {
		/***Given***/
		
		// userid, usernm, pass, reg_dt, alias , addr1, addr2 , zipcode
		UserVo userVo = new UserVo("ddit","대덕인재","dditpass", new Date(), "개발원_m","대전시 중구 중앙로 76", "4층 대덕인재개발원","34940","brown.png","uuid=generated-filename.png");

		/***When***/
		int updateCnt = userService.modifyUser(userVo);

		/***Then***/
		assertEquals(1, updateCnt);

	}
	
	
	@Test
	public void registUser() {
		/***Given***/
		
		// userid, usernm, pass, reg_dt, alias , addr1, addr2 , zipcode
		UserVo userVo = new UserVo("ddit2","대덕인재","dditpass", new Date(), "개발원_m","대전시 중구 중앙로 76", "4층 대덕인재개발원","34940" ,"brown.png","uuid=generated-filename.png");
		
		/***When***/
		int insertCnt = userService.registUser(userVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	// 삭제 테스트 
		@Test
		public void deleteUserTest() {
			/***Given***/
			//해당 테스트가 실행될 때는 testUser라는 사용자가 before메소드애 의해 등록이 된 상태
			String userid = "testUser";

			/***When***/
			int deleteCnt = userService.deleteUser(userid);
			
			
			/***Then***/
			assertEquals(1, deleteCnt);
		}
		
		
}

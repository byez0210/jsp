package kr.or.ddit.user.respository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest {
	
	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUsertest() {
		/***Given***/
		UserDaoI userDao = new UserDao();

		/***When***/
		List<UserVo> userList = userDao.selectAllUser();
		
		/***Then***/
		assertEquals(16, userList.size());
	}
	// 사용자 아이디를 이용하여 특정 사용자 정보 조회
	
	@Test
	public void selectUserTest() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		String userid = "brown";

		/***When***/
		UserVo user = userDao.selectUser(userid);
		/***Then***/
		assertNotNull(user);
		assertEquals("브라운", user.getUsernm());
	}

	// 사용자 페이징 조회 테스트
	@Test
	public void selectPagingUser() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		PageVo  vo = new PageVo(2,5);
		
		/***When***/
		List<UserVo> pageList = userDao.selectPagingUser(vo);
		
		/***Then***/
		assertEquals(5, pageList.size());
	}
	
	// 사용자 전체 조회
	@Test
	public void selectAllUserCnt() {
		/***Given***/
		UserDaoI userDao = new UserDao();
		
		/***When***/
		int userCnt = userDao.selectAllUserCnt();
		
		/***Then***/
		assertEquals(16, userCnt);
	}
	
	
	
}

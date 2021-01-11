package kr.or.ddit.emp.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class EmpServiceTest {
	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUsertest() {
		/***Given***/
		EmpserviceI empService = new EmpService();

		/***When***/
		List<EmpVo> empList = empService.selectAllEmp();
		
		/***Then***/
		assertEquals(14, empList.size());
	}
}
	

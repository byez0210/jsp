package kr.or.ddit.emp.respository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.user.model.UserVo;

public class EmpDaoTest {
	
	// 전체 사용자 조회 테스트
	@Test
	public void selectAllUsertest() {
		/***Given***/
		EmpDaoI empDao = new EmpDao();

		/***When***/
		List<EmpVo> empList = empDao.selectAllEmp();
		
		/***Then***/
		assertEquals(14, empList.size());
	}
	
}
package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;

public interface EmpserviceI {
	// 전체 직원 조회
	List<EmpVo> selectAllEmp();
		
	// 사용자 페이징 조회
	List<EmpVo> selectPagingEmp(PageVo pageVo);
	
	int selectAllCnt();
}

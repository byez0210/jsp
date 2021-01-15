package kr.or.ddit.emp.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;

public interface EmpserviceI {
	// 전체 직원 조회
	List<EmpVo> selectAllEmp();
		
	// 사용자 페이징 조회
	Map<String,Object> selectPagingEmp(PageVo vo);
	
	
}

package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.emp.model.EmpVo;

public interface EmpserviceI {
	// 전체 직원 조회
		List<EmpVo> selectAllEmp();
}

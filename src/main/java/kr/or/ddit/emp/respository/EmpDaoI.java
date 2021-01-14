package kr.or.ddit.emp.respository;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;

public interface EmpDaoI {

	// 전체 직원 조회
	List<EmpVo> selectAllEmp();
	
	List<EmpVo> selectPagingEmp(PageVo pageVo);
	
	int selectAllCnt();
}

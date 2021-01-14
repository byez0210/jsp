package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.respository.EmpDao;
import kr.or.ddit.emp.respository.EmpDaoI;

public class EmpService  implements EmpserviceI{
	private EmpDaoI empDao = new EmpDao();

	@Override
	public List<EmpVo> selectAllEmp() {
		
		return empDao.selectAllEmp();
	}

	@Override
	public List<EmpVo> selectPagingEmp(PageVo pageVo) {
		
		return empDao.selectPagingEmp(pageVo);
	}

	@Override
	public int selectAllCnt() {
		
		return empDao.selectAllCnt();
	}
	
}

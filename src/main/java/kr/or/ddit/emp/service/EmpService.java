package kr.or.ddit.emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	//직원 페이징 리스트
	@Override
	public Map<String, Object> selectPagingEmp(PageVo pageVo) {
		
		Map<String , Object> map = new HashMap<String, Object>();
		List<EmpVo>  empList = empDao.selectPagingEmp(pageVo);
		int empCnt = empDao.selectAllCnt();
		map.put("empList", empList);
		map.put("empCnt", empCnt);
		
		return map;
	}

	
}

package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.respository.LprodDao;
import kr.or.ddit.lprod.respository.LprodDaoI;

public class LprodService implements LprodServiceI{

	private LprodDaoI lprodDao = new LprodDao();
	@Override
	public List<LprodVo> selectAllLprod() {
		
		return lprodDao.selectAllLprod();
	}

}

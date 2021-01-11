package kr.or.ddit.lprod.respository;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodDaoI {
	
	List<LprodVo> selectAllLprod();

}

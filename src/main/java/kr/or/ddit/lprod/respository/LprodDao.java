package kr.or.ddit.lprod.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodDao implements LprodDaoI {

	@Override
	public List<LprodVo> selectAllLprod() {
		SqlSession session = MybatisUtil.getSqlSession();
		
		List<LprodVo> lprodList =  session.selectList("lprod.selectAllLprod");
		
		session.close();
		
		return lprodList;
	}

}

package kr.or.ddit.emp.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.emp.model.EmpVo;

public class EmpDao implements  EmpDaoI{

	@Override
	public List<EmpVo> selectAllEmp() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<EmpVo> empList = sqlSession.selectList("emps.selectAllEmp");
		
		sqlSession.close();
		
		return empList;
	}

	@Override
	public List<EmpVo> selectPagingEmp(PageVo pageVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<EmpVo> empList =sqlSession.selectList("emps.selectPagingEmp",pageVo);
		
		sqlSession.close();
		
		return empList;
	}

	@Override
	public int selectAllCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int empCnt = sqlSession.selectOne("emps.selectAllCnt");
		
		sqlSession.close();
		
		return empCnt;
	}

}

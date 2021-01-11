package kr.or.ddit.emp.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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

}

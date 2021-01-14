package kr.or.ddit.user.respository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao  implements UserDaoI{

	@Override
	public List<UserVo> selectAllUser() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		// Session : 웹 사이트의 여러 페이지에 걸쳐 사용되는 사용자 정보를 저장하는 방법
		// select : 리턴되는 값의 복수 유무를 판단
		//			1. 단건 : 일반객체를 반환(UserVo)selectOne()
		//			2. 여러건 : List<UserVO> selectList()
		//	insert,update, delete : insert,update, delete 
		
		// 메소드 이름과 실행할 sql id를 동일하게 맞추자(유지보수 - 다른 개발자의 가독성)
		
		List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
		
		//  사용한 자원 반환
		sqlSession.close();
		
		return userList;
	}

	@Override
	public UserVo selectUser(String userid) {
		SqlSession sqlSession =  MybatisUtil.getSqlSession();
		
		UserVo user = sqlSession.selectOne("users.selectUser", userid);
		sqlSession.close();
		
		return user;
	}
	//데이터 베이스라는 황경을 가져올 떄 유의해야함 
	//실제 운영하는 db, 개발할 떄 사용하는 db
	@Override
	public List<UserVo> selectPagingUser(PageVo vo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<UserVo>  userList = sqlSession.selectList("users.selectPagingUser" , vo);
		sqlSession.close();
		
		return userList;
		
	}

	@Override
	public int selectAllUserCnt() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int userCnt = sqlSession.selectOne("users.selectAllUserCnt");
		
		sqlSession.close();
		
		return userCnt;
	}

	@Override
	public int modifyUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int updateCnt = sqlSession.update("users.modifyUser", userVo);

		if(updateCnt ==1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return updateCnt;
	}

	@Override
	public int registUser(UserVo userVo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int insertCnt= sqlSession.insert("users.registUser", userVo);
		
		if(insertCnt ==1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int deleteUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int deleteCnt= sqlSession.delete("users.deleteUser", userid);
		
		if(deleteCnt ==1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return deleteCnt;
	}
	
	
}

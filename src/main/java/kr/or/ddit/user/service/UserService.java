package kr.or.ddit.user.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.respository.UserDao;
import kr.or.ddit.user.respository.UserDaoI;

public class UserService implements UserServiceI {
	
	private UserDaoI userDao = new UserDao();
	
	@Override
	public List<UserVo> selectAllUser() {
		 List<UserVo> list =null;
		try {
			list = userDao.selectAllUser();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public UserVo selectUser(String userid) {
		
		return userDao.selectUser(userid);
		
	}
	//데이터 베이스라는 황경을 가져올 떄 유의해야함 
	//실제 운영하는 db, 개발할 떄 사용하는 db
	@Override
	public Map<String,Object> selectPagingUser(PageVo vo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<UserVo> userList = userDao.selectPagingUser(vo);
		int userCnt = userDao.selectAllUserCnt();
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
		
	}
}

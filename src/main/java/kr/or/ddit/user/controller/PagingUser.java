package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/pagingUser")
public class PagingUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceI userService = new UserService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//left.jsp : /pagingUser?page=1pageSize=5
		// ===>      /pagingUser
		
		// doGet 메소드에서 page,pageSize 파라미터가 request 객체에 존재하지 않을 때
		// page 는 1, pageSize 5 로 생각을 코드로 작성
		// 파라미터가 존재하면 해당 파라미터를 를 이용
		
		// primitive Type ==> class(wrapper) Integer
		// if /else ==> ? // 조건 ?  true 일 때 반환 값 : false일 때 반환할 값
		// refactoring : 코드를 (깔끔하게) 바꾸는 기본 동작방식을 유지한채 변경하는 기법
		
//		alt + shift + l
		
		String pageParam = request.getParameter("page");
		String pageSizeparam = request.getParameter("pageSize");

//		int page = Integer.parseInt(request.getParameter("page"));
		// 널이 나올수도 있음  전과 요구사항이 다름
		
		int page = pageParam == null ? 1 :  Integer.parseInt(pageParam);
		int pageSize =  pageSizeparam  == null ? 5 : Integer.parseInt(pageSizeparam);
		
		PageVo vo = new PageVo(page,pageSize);
		Map<String, Object>  map = userService.selectPagingUser(vo);
		
		List<UserVo> userList =  (List<UserVo>)map.get("userList");
		int userCnt = (int)map.get("userCnt");
		int pagination = (int) Math.ceil((double)userCnt/pageSize);
		
		request.setAttribute("userList", userList);
		request.setAttribute("pagination", pagination);
		request.setAttribute("pageVo", vo);
		
		request.getRequestDispatcher("/user/pagingUser.jsp").forward(request, response);
	}


}

package kr.or.ddit.user.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
import kr.or.ddit.util.FileUtil;
@MultipartConfig
@WebServlet("/userModify")
public class UserModify  extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(UserModify.class);
	private UserServiceI userService  = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("doget 진입");
		String userid = req.getParameter("userid");
		logger.debug("userid 값 :{}" ,userid);
		
		UserVo user = userService.selectUser(userid);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/user/userModify.jsp").forward(req, resp);
	}
	
	//사용자 정보 수정 요청 처리 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터를 읽기전에 실행
		// servlet의 dopost 메소드 마다 실행 필요 ==> filter
		req.setCharacterEncoding("utf-8");
	
		
		String userid = req.getParameter("userid");
		String usernm = req.getParameter("usernm");
		String pass = req.getParameter("pass");
		logger.debug(" dopost() userid값 : {}", userid);
		logger.debug(" dopost() update값 : {}", req.getParameter("reg_dt"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt = null;
		
		
		try {
			reg_dt = sdf.parse(req.getParameter("reg_dt"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		
		Part profile = req.getPart("profile");
		logger.debug(" profile값 : {}", profile);
		String filename="";
		String realfilename="";
		
		if(profile.getSize()> 0) {
			filename = FileUtil.getFileName(profile.getHeader("Content-Disposition"));
			realfilename = FileUtil.getFileExtenstion(filename);
			realfilename = UUID.randomUUID().toString() + realfilename;
			
			profile.write("d:\\upload\\" + realfilename);
		}
		else {
			UserVo user = userService.selectUser(userid);
			filename = user.getFilename();
			realfilename= user.getRealfilename();
		}
		
		UserVo userVo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode, filename, realfilename);
		
		int updateCnt = 0;
		
		try {
			updateCnt = userService.modifyUser(userVo);
		} catch (Exception e) {
			updateCnt =0;
		}
		
		//	사용자 수정이 정상적으로 된 경우 ==> 해당 사용자의 상세조회 페이지로 이동
		if(updateCnt ==1 ) {
			logger.debug(" updateCnt값 : {}", updateCnt);
			//	 불가능 - get 방식으로 보낼 수 없음 req.getRequestDispatcher("/user/user.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath() +"/user?userid="+ userid);
		}
		//사용자 수정이 비정상적으로 된 경우 ==> 해당 사용자의 정보수정 페이지로 이동
		else {
			doGet(req, resp);
		}
		
	}
}

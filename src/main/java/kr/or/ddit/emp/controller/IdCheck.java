package kr.or.ddit.emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;
@WebServlet("/idCheck")
public class IdCheck extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(IdCheck.class);
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid  = req.getParameter("userid");
		
		userService.selectAllUser();
		
		
	}
	
}

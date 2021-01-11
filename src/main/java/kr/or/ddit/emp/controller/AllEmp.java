package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.service.EmpserviceI;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/allEmp")
public class AllEmp extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmpserviceI empService = new EmpService();
		
		List<EmpVo> empList = empService.selectAllEmp();
		
		req.setAttribute("empList", empList);
		
		req.getRequestDispatcher("/emp/empList.jsp").forward(req, resp);
	
	
	}

}

package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.emp.model.EmpVo;
import kr.or.ddit.emp.service.EmpService;
import kr.or.ddit.emp.service.EmpserviceI;

@WebServlet("/pagingEmp")
public class PagingEmp  extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(PagingEmp.class);
	private EmpserviceI empService = new EmpService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = Integer.parseInt( req.getParameter("page"));
		int pageSize = Integer.parseInt( req.getParameter("pageSize"));
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		List<EmpVo> empList =  empService.selectPagingEmp(pageVo);
		
		req.setAttribute("empList", empList);
		
		req.getRequestDispatcher("/emp/PagingEmp.jsp").forward(req, resp);
		
		
	}

}

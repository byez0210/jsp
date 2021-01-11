package kr.or.ddit.lprod.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceI;


@WebServlet("/allLprod")
public class AllLprod  extends HttpServlet{
	
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		LprodServiceI lprodService = new LprodService();
		
		List<LprodVo> lprodList = lprodService.selectAllLprod();
		
		req.setAttribute("lprodList",lprodList);
		
		req.getRequestDispatcher("/lprod/lprod.jsp").forward(req, resp);
		
	};
}

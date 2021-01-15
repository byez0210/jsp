package kr.or.ddit.emp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		
		
		
		
		String pageParam = req.getParameter("page");
		String pageSizeParam = req.getParameter("pageSize");
		
		
		int page = pageParam ==  null ? 1: Integer.parseInt( pageParam);
		int pageSize = pageSizeParam == null ?  5  : Integer.parseInt( pageSizeParam);
		
		PageVo pageVo = new PageVo(page, pageSize);
		
		Map<String , Object> map =  empService.selectPagingEmp(pageVo);
		List<EmpVo> empList = (List<EmpVo>)map.get("empList");
		int empCnt =  (int)map.get("empCnt");
		int pagination = (int)Math.ceil((double)(empCnt/pageSize));
		
		req.setAttribute("empList", empList);
		req.setAttribute("pagination", pagination);
		req.setAttribute("pageVo", pageVo);
		
		req.getRequestDispatcher("/emp/PagingEmp.jsp").forward(req, resp);
		
		
	}

}

package kr.or.ddit.servlet.scope;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(mulCalculation.class);


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/mulCalculation.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int result = num1*num2 ;
		
		logger.debug(result+"");
		
		HttpSession session =req.getSession();
		session.setAttribute("mulResult", result);
		
		req.getRequestDispatcher("/jsp/mulResult.jsp").forward(req, resp);
	}

}

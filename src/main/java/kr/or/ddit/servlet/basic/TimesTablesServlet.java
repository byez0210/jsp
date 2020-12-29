package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TimesTablesServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
		System.out.println("basicServlet.init()");
	}
	
	//doXXX 메소드의 인자 : req, res
	// GET, POST, DELETE, PUSH, HEAD... : HTTP 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		resp.setContentType("text/html; charset=utf-8");
		
		
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>Times Tables Servlet</title>");
		pw.println("		<style>");
		pw.println("			td {");
		pw.println("				border : 1px solid black }");
		pw.println("			table{");
		pw.println("				width : 100% }");
		pw.println("		</style>");
		pw.println("	</head>");
		pw.println("	<body> ");
		pw.println("		<table>");
		for (int j =1; j<= 9; j++){
		pw.println("			<tr> ");
			for (int i = 2; i<=9; i++) {
				pw.println("			<td>" + i + "* " + j +" = " + i*j + "</td>");
			}
		pw.println("			</tr> ");
		}
		pw.println("		</table> ");
		pw.println("	</body>");
		pw.println("</html>");
		
		pw.flush();		//더이상 작성할 내용이 없으므로 작업을 마무리 한다
		pw.close();		//사용한 자원 반납
	}
	
	
	
}

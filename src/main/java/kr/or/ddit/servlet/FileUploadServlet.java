package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
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

import kr.or.ddit.util.FileUtil;

@MultipartConfig
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet{

	private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	private static final long serialVersionUID = 1L;

	//doget : 파일 업로드를 테스트 화면응 응답으로 셍성
	//		  webapp/jsp/fileupload
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/fileupload.jsp").forward(req, resp);
	}
	//dopost : 파일 업로드화면에서 서버로 파일을 업로드 요청
	//			요청 처리 후
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		logger.debug("contextType : {} ", req.getContentType());
		logger.debug("userid : {}", req.getParameter("userid"));
		logger.debug("file : {}", req.getParameter("file"));
		
		Part part = req.getPart("file");
		
		logger.debug(part.getHeader("Content-Disposition"));
		
		if(part.getSize() >0 ) {
			//사용자가 업로드한 파일 이름
			String filename = FileUtil.getFileName(part.getHeader("Content-Disposition"));
			//서버에 저장할 때 다른 사용자의 파일과 중복되지 앟ㄴ도록 생성한 파일이름
			
			String realFileName=  UUID.randomUUID().toString();
			part.write("d:\\upload\\" +filename);
		}
		
		//복수개의 파일을 업로드 하고 파트 이름을 모를 때
		Collection<Part> parts = req.getParts();
		for(Part p : parts){
			
		}
		
//		logger.debug("Content-Disposition :{} ", part.getHeader("Content-Disposition"));
		
//		InputStreamReader isr =  new InputStreamReader(  req.getInputStream());
//		
//		char [] buff = new char[512];
//		while(isr.read(buff))!= 1 {
//			System.out.println(buff);
//		}
		
		doGet(req, resp);
	}
}

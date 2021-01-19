package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class encoding implements Filter {
private static final Logger logger = LoggerFactory.getLogger(encoding.class);
private String encoding;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		if(encoding == null) {
			encoding ="utf-8";
		}
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		logger.debug("encoding : {} ", encoding);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}

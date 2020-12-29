package kr.or.ddit.servlet.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Facotrial {
	private static final Logger logger = LoggerFactory.getLogger(Facotrial.class);
	
	public static void main(String[] args) {

		Facotrial factorial = new Facotrial();
		
		int result = factorial.calculate(5);
		
		if (result == 120) {
			logger.debug("success");
		}
		else {
			logger.debug("fail");
		}
		
		result = factorial.calculate(0);
		
		if (result == 1) {
			logger.debug("success");
		}
		else {
			logger.debug("fail");
		}
	}
	
	/**
	 * 
	 * Method : calculate
	 * 작성자 : PC-23
	 * 변경이력 : 
	 * @param n
	 * @return 
	 * Method 설명 :
	 */
//	private int calculate(int n) {
//		int fac = 1;
//		for(int i =1; i <=n; i++) {
//			fac = fac *i;
//		}
//		return fac;
//	}
	public int calculate(int n) {
		if( n <= 1)
			return 1;
		else
			return n*calculate(n-1);
		}
	
}

package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);

	/** 
	 * Method : getCookieValue
	 * 작성자 : PC-23
	 * 변경이력 : 
	 * @param cookieStr
	 * @param cookieName
	 * @return 
	 * Method 설명 : cookieStr에서 cookieName에 해당하는 쿠키 값을 조회 
	 */
	//cookieStr :rememberme=Y; test=T; userid=brown
	//cookieName : userid,rememberme
	//return : brown ,Y
	public static String getCookieValue(String cookieStr, String cookieName) {
		
		//rememberme=Y; test=T; userid=brown
		
		String[] cookies = cookieStr.split("; ");
		
		String result = "";
		for(int i = 0; i<cookies.length; i++) {
			String[] cookies1 = cookies[i].split("=");
			if(cookies1[0].equals(cookieName)) {
				return cookies1[1];
			}
		}
		
		
		//cookies[0] = rememberme=Y;
		//cookies[1] = test=T;
		//cookies[2] = userid=brown
		
		return "";
	}
}

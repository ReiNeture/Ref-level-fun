package fubuki.ref.util;

import java.util.Objects;

import jakarta.servlet.http.HttpSession;

public class UserStatus {

	public static boolean isLogined(HttpSession session) {
		
		if( Objects.isNull(session.getAttribute("id") ) )
			throw new IllegalStateException("Not Logined");
		if( (long) session.getAttribute("id") < 0 )
			throw new IllegalStateException("Not Logined");
		
		return true;
	}
	
}

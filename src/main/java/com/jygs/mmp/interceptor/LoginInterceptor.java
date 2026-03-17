package com.jygs.mmp.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginInterceptor  implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		
			HttpSession session=request.getSession();
			String userEmail=(String)session.getAttribute("userEmail");
			
			if( userEmail == null ) { //로그인이 되어 있지 않은 상황 
				response.sendRedirect("/");
				return false;
			}//end if
		    
			return true;
	}
	
}

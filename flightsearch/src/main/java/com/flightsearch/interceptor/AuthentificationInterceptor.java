package com.flightsearch.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.flightsearch.model.UserModel;

@Component
public class AuthentificationInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("in prehandler");
		
		UserModel user = (UserModel) request.getSession().getAttribute("user");
		if(user == null) {
			response.sendRedirect("/flightsearch/loginForm");
			return false;
		}
		
		System.out.println("user : " + user);
		System.out.println("isAdmin : " + user.isAdmin());
		if(!user.isAdmin()) {
			response.sendRedirect("/flightsearch");
			return false;
		}
		
		return true;
	}

}

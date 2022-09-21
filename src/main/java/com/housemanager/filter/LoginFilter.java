package com.housemanager.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginFilter implements Filter{

	String ex=",.css,.js,.png,.jpg,";

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		String url=req.getRequestURI();
		int pos=url.lastIndexOf(".");
		if(pos>0){
			if(ex.indexOf(","+url.substring(pos)+",")>=0){
				chain.doFilter(request, response);
				return;
			}
		}


		if(url.indexOf("login.jsp")>=0  || url.indexOf("user/login")>=0|| url.indexOf("user/saveuser")>=0|| url.indexOf("user/usersave")>=0|| url.indexOf("user/savepassword")>=0|| url.indexOf("user/passwordsave")>=0)
			chain.doFilter(request, response);//ͨ������
		else {
			if(req.getSession().getAttribute("user")==null){
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}else{
				chain.doFilter(request, response);//ͨ������
			}
		}
	}
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.service.BoardCommand;

public class Login implements BoardCommand{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute("userid", request.getParameter("id"));
		session.setAttribute("gender", request.getParameter("gender"));
	   }
}

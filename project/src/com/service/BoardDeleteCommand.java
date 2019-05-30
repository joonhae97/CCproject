package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ApplyDAO;
public class BoardDeleteCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		ApplyDAO dao = new ApplyDAO();
		dao.deleteApplication(userid);
	}

}

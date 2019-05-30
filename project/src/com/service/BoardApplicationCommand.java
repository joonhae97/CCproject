package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.BoardCommand;
import db.ApplyDAO;
import db.ApplyDTO;

public class BoardApplicationCommand implements BoardCommand{
	 public void execute(HttpServletRequest request, HttpServletResponse response ){
		ApplyDAO data=new ApplyDAO();
		ApplyDTO dto=new ApplyDTO();
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		dto=data.application(userid);
		request.setAttribute("dto", dto);
	}
}

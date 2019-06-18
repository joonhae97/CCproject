package com.register.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.register.service.BoardCommand;
import com.register.db.ApplyDAO;
import com.register.db.ApplyDTO;

public class BoardApplicationCommand implements BoardCommand{
	 public void execute(HttpServletRequest request, HttpServletResponse response ){
		ApplyDAO data=new ApplyDAO();
		ApplyDTO dto=new ApplyDTO();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		dto=data.application(id);
		request.setAttribute("dto", dto);
	}
}

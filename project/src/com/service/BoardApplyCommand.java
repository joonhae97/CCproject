package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ApplyDAO;

public class BoardApplyCommand implements BoardCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String arr[];
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		String gender = (String) session.getAttribute("gender");

		arr = request.getParameterValues("college");
		String college = "";
		if (arr != null) {
			for (String val : arr) {
				college += val + " ";
			}
		}

		arr = request.getParameterValues("hometown");
		String hometown = "";
		if (arr != null) {
			for (String val : arr) {
				hometown += val + " ";
			}
		}

		arr = request.getParameterValues("age");
		String age = "";
		if (arr != null) {
			for (String val : arr) {
				age += val + " ";
			}
		}

		String minheight = request.getParameter("minheight");
		String maxheight = request.getParameter("maxheight");
		
		arr = request.getParameterValues("interesting");
		String interesting = "";
		if (arr != null) {
			for (String val : arr) {
				interesting += val + " ";
			}
		}

		arr = request.getParameterValues("character");
		String character = "";
		if (arr != null) {
			for (String val : arr) {
				character += val + " ";
			}
		}
		/*LocalDateTime time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));*/
		
		ApplyDAO dao = new ApplyDAO();
		dao.write(userid, gender, college, hometown, age, minheight,maxheight, interesting, character);
	}
}

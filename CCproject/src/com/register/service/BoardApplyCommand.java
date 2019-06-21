package com.register.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.register.db.ApplyDAO;
public class BoardApplyCommand implements BoardCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String arr[];
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionID");
		ApplyDAO dao=new ApplyDAO();
		String gender = dao.getUserGender(id);

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
		
		
		dao.write(id, gender, college, hometown, age, minheight,maxheight, interesting, character);
	}
}

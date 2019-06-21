package com.register.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.service.BoardApplicationCommand;
import com.register.service.BoardApplyCommand;
import com.register.service.BoardCommand;
import com.register.service.BoardDeleteCommand;
import com.register.service.BoardListCommand;
import com.register.service.BoardMatchCommand;
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException
	{
		reqPro(request,response);
	}
	
	protected void doPost(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException,IOException
	{
		reqPro(request,response);
	}
	
	//doPost, doGet?��?�?리�??�? ????
	protected void reqPro(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		
		BoardCommand command=null;
		String nextPage = null;
		
		if(com.equals("/apply.ro")) {
			command=new BoardDeleteCommand();
			command.execute(request, response);
			nextPage="RegisterApply.jsp";			
		}
		else if(com.equals("/BoardApplyAction.ro")) {
		command = new BoardApplyCommand();
			command.execute(request, response);
			nextPage="match.ro";
		}
		else if(com.equals("/match.ro")) {
			command = new BoardMatchCommand();
			command.execute(request, response);
			nextPage="RegisterList.ro";
		}
		else if(com.equals("/application.ro")) {
			command = new BoardApplicationCommand();
			command.execute(request, response);
			nextPage="RegisterApplication.jsp";
		}
		else if(com.equals("/RegisterList.ro")) {
			command = new BoardListCommand();
			command.execute(request, response);
			nextPage="RegisterList.jsp";
		}
		else if(com.equals("/delete.ro")) {
			command=new BoardDeleteCommand();
			command.execute(request,response);
			nextPage="RegisterList.ro";
		}
		
		//??�?릿�???? jsp�? ?��???면�?? ?��?��?��?? �??? ??겨주?? �?체�?? ????. 
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);//RequestDispatcher?��?��???��??.getRequestDispatcher("")???? jsp???��??? 기�??
		dis.forward(request,response);//request, response�? ??. jsp 쪽�?��? ?�른�? ??겨주?�면 request.setAttribute("msg",msg)?��?��???��?
	}
}

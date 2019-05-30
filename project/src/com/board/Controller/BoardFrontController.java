package com.board.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.BoardApplicationCommand;
import com.service.BoardApplyCommand;
import com.service.BoardCommand;
import com.service.BoardDeleteCommand;
import com.service.BoardListCommand;
import com.service.BoardMatchCommand;
import com.service.Login;
@WebServlet("*.do")//*.do라고 주소 url에 표시해주어야 이 서블릿 클래스가 실행됨.
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
	
	//doPost, doGet일괄처리하기 위함
	protected void reqPro(HttpServletRequest request, 
	HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		
		BoardCommand command=null;
		String nextPage = null;
		
		if(com.equals("/apply.do")) {
			command=new BoardDeleteCommand();
			command.execute(request, response);
			nextPage="apply.jsp";			
		}
		else if(com.equals("/BoardApplyAction.do")) {
			command = new BoardApplyCommand();
			command.execute(request, response);
			nextPage="match.do";
		}
		else if(com.equals("/match.do")) {
			command = new BoardMatchCommand();
			command.execute(request, response);
			nextPage="list.do";
		}
		else if(com.equals("/application.do")) {
			command = new BoardApplicationCommand();
			command.execute(request, response);
			nextPage="application.jsp";
		}
		else if(com.equals("/list.do")) {
			command = new BoardListCommand();
			command.execute(request, response);
			nextPage="list.jsp";
		}
		else if(com.equals("/delete.do")) {
			command=new BoardDeleteCommand();
			command.execute(request,response);
			nextPage="list.do";
		}
		else if(com.equals("/loginform.do")) {
			nextPage="loginform.jsp";
		}
		else if(com.equals("/login.do")) {
			command = new Login();
			command.execute(request, response);
			nextPage="list.do";
		}
		
		//서블릿에서 jsp를 호출하면서 데이터를 같이 넘겨주는 객체를 선언. 
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);//RequestDispatcher인터페이스.getRequestDispatcher("")안에 jsp파일명을 기술
		dis.forward(request,response);//request, response만 됨. jsp 쪽으로 다른거 넘겨주려면 request.setAttribute("msg",msg)이런식으로
	}
}

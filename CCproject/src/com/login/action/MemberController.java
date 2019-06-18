package com.login.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	 
    /**
     * GET ����� ��� doGet()
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            doProcess(request,response);
    }      
        
    /**
     * POST ����� ��� doPost()
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            doProcess(request,response);
    }                          
        
    /**
     * ��ɾ ���� �ش� Action�� ������ �ش�.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doProcess(HttpServletRequest request, HttpServletResponse response) 
             throws ServletException, IOException {
        
        // �Ѿ�� Ŀ�ǵ带 �����ϴ� ����
        String requestURI = request.getRequestURI();
        int cmdIdx = requestURI.lastIndexOf("/")+1;
        
        String command = requestURI.substring(cmdIdx);
        
        // URI, command Ȯ��
        //System.out.println("requestURI : "+requestURI);
        //System.out.println("command : "+command);
        
        ActionForward forward = null;
        Action action = null;
        
        // ������ ȭ�� URL
        String form = "MainForm.jsp?contentPage=";
        
        // Ŀ�ǵ忡 �ش��ϴ� �׼��� �����Ѵ�.
        try {
            // ȭ����ȯ
            if(command.equals("Main.do")) // ����ȭ�� �̵�
            {
                forward=new ActionForward();
                forward.setRedirect(false);
                forward.setNextPath("main.jsp");
            }
            else if(command.equals("LoginForm.do"))    // �α���ȭ�� �̵�
            {
                forward=new ActionForward();
                forward.setRedirect(false);
                forward.setNextPath("loginform.jsp");
            }
            else if(command.equals("JoinForm.do"))    // ȸ������ȭ�� �̵�
            {
                forward=new ActionForward();
                forward.setRedirect(false);
                forward.setNextPath("joinform.jsp");
            }
            else if(command.equals("Result.do")) // ���� ó����� ȭ�� �̵�
            {
                forward=new ActionForward();
                forward.setRedirect(false);
                forward.setNextPath("main.jsp");
            }
            // ���� ó�� �׼�
            else if(command.equals("MemberLoginAction.do")) // �α��� ó��
            {
                action = new MemberLoginAction();
                forward = action.execute(request, response);
            }
            else if(command.equals("MemberLogoutAction.do")) // �α׾ƿ� ó��
            {
                action = new MemberLogoutAction();
                forward = action.execute(request, response);
            }
            else if(command.equals("MemberJoinAction.do")) // ȸ������ ó��
            {
                action = new MemberJoinAction();
                forward = action.execute(request, response);
            }
           
 
            // ȭ���̵� - isRedirext() ���� ���� sendRedirect �Ǵ� forward�� ���
            // sendRedirect : ���ο� ������������ request�� response��ü�� ���Ӱ� �����ȴ�.
            // forward : ���� �������� �������� forwad�� ���� ȣ��� �������� request�� response ��ü�� ����
            if(forward != null){
                if (forward.isRedirect()) {
                    response.sendRedirect(forward.getNextPath());
                } else {
                    RequestDispatcher dispatcher = request
                            .getRequestDispatcher(forward.getNextPath());
                    dispatcher.forward(request, response);
                }
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end doProcess

}
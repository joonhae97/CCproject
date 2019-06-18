package com.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import com.login.beans.MemberBean;
import com.login.dao.MemberDAO;

public class MemberLoginAction implements Action {
	 public ActionForward execute(HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
	        ActionForward forward = new ActionForward();
	        HttpSession session=request.getSession();
	        
	        // ���̵�� ��й�ȣ�� �����´�.
	        String id = request.getParameter("id");
	        String password = request.getParameter("password");
	        
	        // DB���� ���̵�, ��й�ȣ Ȯ��
	        MemberDAO dao = MemberDAO.getInstance();
	        int check = dao.loginCheck(id, password);
	        if(check == 0)    // ��й�ȣ Ʋ����� -> �ٽ� �α��� ȭ������ �̵�
	        { 
	            // �α��� ���н� �޽����� request�� ��´�.
	               request.setAttribute("fail", "0");
	               
	               forward.setRedirect(false);
	               forward.setNextPath("LoginForm.do");
	        }
	        else if(check == -1) // ���̵� ���� ��� -> �ٽ� �α��� ȭ������ �̵�
	        {
	            request.setAttribute("fail", "-1");
	 
	               forward.setRedirect(false);
	               forward.setNextPath("LoginForm.do");
	        }
	        else
	        {
	            //�α��� ���� -> ���ǿ� ���̵� ����
	               session.setAttribute("sessionID", id);
	               
	               // �α��� ������ ����ȭ������ �̵�
	               forward.setRedirect(true);
	               forward.setNextPath("BoardList.bo");
	        }
	           
	        return forward;
	    }
}

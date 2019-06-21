package com.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberLogoutAction implements Action {
	public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ActionForward forward = new ActionForward();
        
        // �α׾ƿ��� ���������� ��� �����Ѵ�.
        request.getSession().invalidate();
        
        // �α׾ƿ� �� ����ȭ������ ���ư���.
        forward.setRedirect(true);
        forward.setNextPath("Main.do");
        
        return forward;
    }


}

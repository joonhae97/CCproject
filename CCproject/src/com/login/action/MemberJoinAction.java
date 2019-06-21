package com.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.login.beans.MemberBean;
import com.login.dao.MemberDAO;
import com.login.action.Action;

public class MemberJoinAction implements Action {
	    public ActionForward execute(HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
	        request.setCharacterEncoding("utf-8"); // ���ڵ�
	        
	        ActionForward forward = new ActionForward();
	        
	        MemberDAO dao = MemberDAO.getInstance();
	        
	        // �Էµ� ������ �ڹٺ� �����Ѵ�.
	        MemberBean member = new MemberBean();
	        member.setId(request.getParameter("id"));
	        member.setPw(request.getParameter("password"));
	        member.setName(request.getParameter("name"));
	        member.setGender(request.getParameter("gender"));
	        member.setEmail(request.getParameter("email"));
	        member.setCollege(request.getParameter("college"));
	        member.setHometown(request.getParameter("hometown"));
	        member.setAge(request.getParameter("age"));
	        member.setHeight(request.getParameter("height"));
	        member.setInteresting(request.getParameter("interesting"));
	        member.setCharacter(request.getParameter("character"));
	        member.setKey(0);
	       
	        // ȸ������ ����
	        dao.joinMember(member);
	        
	        // ���Լ���
	        forward.setRedirect(true);
	           forward.setNextPath("Main.do");
	        
	           // ���Լ��� �޽����� ���ǿ� ��´�.
	           request.getSession().setAttribute("msg", "1");
	           
	        return forward;
	    }


}

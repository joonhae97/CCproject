package com.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.login.beans.MemberBean;
import com.login.dao.MemberDAO;
import com.login.action.Action;

public class MemberJoinAction implements Action {
	    public ActionForward execute(HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
	        request.setCharacterEncoding("euc-kr"); // 인코딩
	        
	        ActionForward forward = new ActionForward();
	        
	        MemberDAO dao = MemberDAO.getInstance();
	        
	        // 입력된 정보를 자바빈에 세팅한다.
	        MemberBean member = new MemberBean();
	        member.setId(request.getParameter("id"));
	        member.setPw(request.getParameter("password"));
	        member.setName(request.getParameter("name"));
	        member.setGender(request.getParameter("gender"));
	        member.setEmail(request.getParameter("email"));
	       
	        // 회원가입 실행
	        dao.joinMember(member);
	        
	        // 가입성공
	        forward.setRedirect(true);
	           forward.setNextPath("Main.do");
	        
	           // 가입성공 메시지를 세션에 담는다.
	           request.getSession().setAttribute("msg", "1");
	           
	        return forward;
	    }


}

package com.board.action;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
 
import com.board.model.BoardBean;
import com.board.model.BoardDAO;
import com.common.action.Action;
import com.common.action.ActionForward;

public class BoardListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
			ActionForward forward = new ActionForward();
	        // ���� ������ ��ȣ �����
	        int spage = 1;
	        String page = request.getParameter("page");
	        if(page != null)
	            spage = Integer.parseInt(page);
	      	        // �˻����ǰ� �˻������� �����´�.
	        String opt = request.getParameter("opt");
	        String condition = request.getParameter("condition");
        
	       
        // �˻����ǰ� ������ Map�� ��´�.
        HashMap<String, Object> listOpt = new HashMap<String, Object>();
        listOpt.put("opt", opt);
        listOpt.put("condition", condition);
        listOpt.put("start", spage*10-9);
        
        BoardDAO dao = BoardDAO.getInstance();
        int listCount = dao.getBoardListCount(listOpt);
        System.out.println("try");
        ArrayList<BoardBean> list =  dao.getBoardList(listOpt);
        System.out.println("success");

        // �� ȭ�鿡 10���� �Խñ��� ����������
        // ������ ��ȣ�� �� 5��, ���ķδ� [����]���� ǥ��
        
        // ��ü ������ ��
        int maxPage = (int)(listCount/10.0 + 0.9);
        //���� ������ ��ȣ
        int startPage = (int)(spage/5.0 + 0.8) * 5 - 4;
        //������ ������ ��ȣ
        int endPage = startPage + 4;
        if(endPage > maxPage)    endPage = maxPage;
        
        // 4�� ��������ȣ ����
        request.setAttribute("spage", spage);
        request.setAttribute("maxPage", maxPage);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        
        // ���� �� ���� �۸�� ����
        //request.setAttribute("listCount", listCount);
        request.setAttribute("list", list);
        // �ܼ� ��ȸ�̹Ƿ� forward()��� (= DB�� ���º�ȭ �����Ƿ�) 
        forward.setRedirect(false);
        forward.setNextPath("BoardListForm.bo");

        return forward;
    }

}
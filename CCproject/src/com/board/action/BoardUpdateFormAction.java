package com.board.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.board.model.BoardBean;
import com.board.model.BoardDAO;
import com.common.action.Action;
import com.common.action.ActionForward;
 
public class BoardUpdateFormAction implements Action
{
    @Override
    public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ActionForward forward = new ActionForward();
        
        // ������ ��ȣ�� �� ��ȣ�� �����´�.
        String pageNum = request.getParameter("page");
        String num = request.getParameter("num");
        int boardNum = Integer.parseInt(num);
 
        BoardDAO dao = BoardDAO.getInstance();
        BoardBean board = dao.getDetail(boardNum);
        
        request.setAttribute("board", board);
        request.setAttribute("pageNum", pageNum);
        
        forward.setRedirect(false); // �ܼ��� ��ȸ�̹Ƿ�
        forward.setNextPath("BoardUpdateForm.bo");
        
        return forward;
    }
}



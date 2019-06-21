package com.board.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.common.action.Action;
import com.common.action.ActionForward;
 
/**
 * ȭ�� ��ȯ�� ó���ϴ� Action
 *
 */
public class BoardFormChangeAction implements Action
{
    private String form = "main.jsp?contentPage=";
    private String path;
    
    /**
     * ��ɾ�κ��� ���� �̵��� ������ ��θ� �����Ѵ�.
     * @param command ��ɾ�
     */
    public void setCommand(String command){
        int idx = command.indexOf(".");
        path = command.substring(0, idx)+".jsp";
    }
 
    @Override
    public ActionForward execute(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ActionForward forward = new ActionForward();
        
        forward.setRedirect(false);
        
        // ����ȭ���� ��� MainForm.jsp�� ��η� �����Ѵ�.
        if(path.equals("main.jsp"))
            forward.setNextPath(path);
        else
            forward.setNextPath(path);
        
        return forward;
    }
}



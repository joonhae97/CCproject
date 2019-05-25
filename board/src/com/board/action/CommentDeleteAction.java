package com.board.action;
 
import java.io.PrintWriter;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.controller.CommandAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
 
public class CommentDeleteAction  implements CommandAction
{
    @Override
    public String requestPro(HttpServletRequest request,
    	    HttpServletResponse response) throws Throwable {
    	
    	Connection conn = null;
    	Statement stmt = null;
        
    	int comment_num = Integer.parseInt(request.getParameter("comment_num"));

        response.setContentType("text/html;charset=euc-kr"); 
        
        try {
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
	          // +
				//		"useUnicode=true&characterEncoding = euc-kr";
        	String dbUser = "scott";
        	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();

        	String sql = "DELETE FROM BOARD_COMMENT WHERE COMMENT_NUM = " + comment_num;
        	System.out.println(sql);
			stmt.executeUpdate(sql);

            
        } catch (Exception e) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        }
        
        PrintWriter out = response.getWriter();
        
        // 정상적으로 댓글을 삭제했을경우 1을 전달한다.
        out.println("1");
        out.close();

    
    // DB 자원해제
  
    try {
        if ( stmt != null ){ stmt.close(); stmt=null; }
        if ( conn != null ){ conn.close(); conn=null; }
    } catch (Exception e) {
        throw new RuntimeException(e.getMessage());
    }
  
    return "content.jsp";

    }
}
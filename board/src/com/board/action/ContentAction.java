package com.board.action;
 
import java.sql.*;
import java.util.ArrayList;
 


import javax.servlet.http.HttpServletRequest;
 
import javax.servlet.http.HttpServletResponse;
 
import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import com.board.beans.board;
import com.board.beans.comment;
import com.board.controller.CommandAction;
 
public class ContentAction implements CommandAction {
	
    public String requestPro(HttpServletRequest request,
 
    HttpServletResponse response) throws Throwable {
 
    	Class.forName("com.mysql.jdbc.Driver");
    	
    	int num = Integer.parseInt(request.getParameter("num"));
    	Connection conn = null;
    	Statement stmt = null;    	
    	ResultSet rs = null;   
    	
    	int score = 0;
    	
    	try {
    		HttpSession session = request.getSession();
    		String id = (String) session.getAttribute("id");
    		if(id == null){    			
    			return "loginerror.jsp";
    		}
    		
    		String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
    		
    			//	+
    			//				"useUnicode=true&characterEncoding = euc-kr";
    		String dbUser = "scott";
    		String dbPass = "1234";
    		
    		String query = "select * from board where num = "+num;
    		
    		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
    		
    		stmt = conn.createStatement();    		
    		rs = stmt.executeQuery(query);    		
    		
    		ArrayList<board> articleList = new ArrayList<board>();
    		
    		while(rs.next()){
    			board article = new board();
    			article.setNum(rs.getInt("num"));    			
    			article.setSubject(rs.getString("subject"));
    			article.setContent(rs.getString("content"));
    			article.setId(rs.getString("id"));
    			article.setBoarddate(rs.getString("boarddate"));
    			score = Integer.parseInt(rs.getString("score")) + 1;
    			article.setScore(String.valueOf(score));
    			article.setEmail(rs.getString("email"));
    			articleList.add(article);
    		}
    		request.setAttribute("articleList",articleList);
    		
    		String query2 =  "UPDATE board SET score='" + score +    						
					"' WHERE num=" + num;    		
    		stmt.executeUpdate(query2); 
    		
    		
    		
    	} catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    	
    	ArrayList<comment> list = new ArrayList<comment>();
        
        try {
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
		          // +
					//		"useUnicode=true&characterEncoding = euc-kr";
            String dbUser = "scott";
            String dbPass = "1234";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
                
                /* 댓글의 페이지 처리를 하고싶다면 이 쿼리를 사용하면 된다.
                 * SELECT * FROM
                 *            (SELECT  ROWNUM AS rnum,
                 *                   data.*
                 *             FROM
                 *                   (SELECT LEVEL,
                 *                           COMMENT_NUM,
                 *                             COMMENT_BOARD,
                 *                           COMMENT_ID,
                 *                           COMMENT_DATE,
                 *                           COMMENT_PARENT,
                 *                           COMMENT_CONTENT
                 *                    FROM BOARD_COMMENT
                 *                    WHERE COMMENT_BOARD = ?
                 *                   START WITH COMMENT_PARENT = 0
                 *                   CONNECT BY PRIOR COMMENT_NUM = COMMENT_PARENT) 
                 *              data)
                 *    WHERE rnum>=? and rnum<=? ;
                 */

           	String sql = "select * from BOARD_COMMENT where COMMENT_BOARD = " + num ;
           		
    		stmt = conn.createStatement();    		  
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                comment comment1 = new comment();
                //comment1.setComment_level(rs.getInt("LEVEL"));
                comment1.setComment_num(rs.getInt("COMMENT_NUM"));
                comment1.setComment_board(rs.getInt("COMMENT_BOARD"));
                comment1.setComment_id(rs.getString("COMMENT_ID"));
                comment1.setComment_date(rs.getDate("COMMENT_DATE"));
                comment1.setComment_parent(rs.getInt("COMMENT_PARENT"));
                comment1.setComment_content(rs.getString("COMMENT_CONTENT"));
                list.add(comment1);
            }
    		request.setAttribute("commentList",list);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    	
    	
    	
    	try{
    		if(rs != null) try{rs.close();} catch(SQLException ex){}
    		if(stmt != null) try{stmt.close();} catch(SQLException ex) {}
    		
    		if(conn != null) try{conn.close();} catch(SQLException ex) {}
    	}catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
 
        return "content.jsp";
 
    }
 
}
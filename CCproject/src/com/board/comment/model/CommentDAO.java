package com.board.comment.model;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDAO 
{
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    private static CommentDAO instance;
    
    private CommentDAO(){}
    public static CommentDAO getInstance(){
        if(instance==null)
            instance=new CommentDAO();
        return instance;
    }
    
    // 시퀀스를 가져온다.
    public int getSeq() 
    {
        int result = 1;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            conn.setAutoCommit(false);
            
            // 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
            String sql = "SELECT COMMENT_NUM FROM BOARD_COMMENT";
            pstmt = conn.prepareStatement(sql);
            // 쿼리 실행
            rs = pstmt.executeQuery(); // 쿼리 실행
 
            if (rs.next())    result = rs.getInt(1);
 
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
 
        close();
        return result;
    } // end getSeq
    
    
    // 댓글 등록
    public boolean insertComment(CommentBean comment)
    {
        boolean result = false;
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            conn.setAutoCommit(false);
            
            String sql = "INSERT INTO BOARD_COMMENT (COMMENT_NUM, COMMENT_BOARD, COMMENT_ID, COMMENT_DATE"
            		+ " , COMMENT_PARENT, COMMENT_CONTENT) VALUES(null,?,?,now(),?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comment.getComment_board());
            pstmt.setString(2, comment.getComment_id());
            pstmt.setInt(3, comment.getComment_parent());
            pstmt.setString(4, comment.getComment_content());
            
            int flag = pstmt.executeUpdate();
            if(flag > 0){
                result = true;
                conn.commit(); // 완료시 커밋
            }
            
        } catch (Exception e) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } 
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return result;    
    } // end boardInsert();    
    
    // 댓글 목록 가져오기
    public ArrayList<CommentBean> getCommentList(int boardNum)
    {
        ArrayList<CommentBean> list = new ArrayList<CommentBean>();
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            conn.setAutoCommit(false);
            
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
            
            String sql = "SELECT * FROM BOARD_COMMENT WHERE COMMENT_BOARD = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                CommentBean comment = new CommentBean();
                comment.setComment_num(rs.getInt("COMMENT_NUM"));
                comment.setComment_board(rs.getInt("COMMENT_BOARD"));
                comment.setComment_id(rs.getString("COMMENT_ID"));
                comment.setComment_date(rs.getDate("COMMENT_DATE"));
                comment.setComment_parent(rs.getInt("COMMENT_PARENT"));
                comment.setComment_content(rs.getString("COMMENT_CONTENT"));
                list.add(comment);
            }
                
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return list;
    } // end getCommentList
    
    // 댓글 1개의 정보를 가져온다.
    public CommentBean getComment(int comment_num)
    {
        CommentBean comment = null;
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            conn.setAutoCommit(false);
            
            String sql  = "SELECT * FROM BOARD_COMMENT WHERE COMMENT_NUM = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comment_num);
            
            rs = pstmt.executeQuery();
            while(rs.next())
            {
                comment = new CommentBean();
                comment.setComment_num(rs.getInt("COMMENT_NUM"));
                comment.setComment_board(rs.getInt("COMMENT_BOARD"));
                comment.setComment_id(rs.getString("COMMENT_ID"));
                comment.setComment_date(rs.getDate("COMMENT_DATE"));
                comment.setComment_parent(rs.getInt("COMMENT_PARENT"));
                comment.setComment_content(rs.getString("COMMENT_CONTENT"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return comment; 
    } // end getComment
    
    
    // 댓글 삭제
    public boolean deleteComment(int comment_num) 
    {
        boolean result = false;
 
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            conn.setAutoCommit(false);
 
            String sql = "DELETE FROM BOARD_COMMENT WHERE COMMENT_NUM = ?";
           
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comment_num);
            
            int flag = pstmt.executeUpdate();
            if(flag > 0){
                result = true;
                conn.commit(); // 완료시 커밋
            }    
            
        } catch (Exception e) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        }
 
        close();
        return result;
    } // end deleteComment    

    // DB 자원해제
    private void close()
    {
        try {
            if ( pstmt != null ){ pstmt.close(); pstmt=null; }
            if ( conn != null ){ conn.close(); conn=null;    }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    } // end close()    
        
}



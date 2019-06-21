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
    
    // �������� �����´�.
    public int getSeq() 
    {
        int result = 1;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);
            
            // ������ ���� �����´�. (DUAL : ������ ���� ������������ �ӽ� ���̺�)
            String sql = "SELECT COMMENT_NUM FROM BOARD_COMMENT";
            pstmt = conn.prepareStatement(sql);
            // ���� ����
            rs = pstmt.executeQuery(); // ���� ����
 
            if (rs.next())    result = rs.getInt(1);
 
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
 
        close();
        return result;
    } // end getSeq
    
    
    // ��� ���
    public boolean insertComment(CommentBean comment)
    {
        boolean result = false;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
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
                conn.commit(); // �Ϸ�� Ŀ��
            }
            
        } catch (Exception e) {
            try {
                conn.rollback(); // ������ �ѹ�
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } 
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return result;    
    } // end boardInsert();    
    
    // ��� ��� ��������
    public ArrayList<CommentBean> getCommentList(int boardNum)
    {
        ArrayList<CommentBean> list = new ArrayList<CommentBean>();
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);
            
            /* ����� ������ ó���� �ϰ�ʹٸ� �� ������ ����ϸ� �ȴ�.
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
    
    // ��� 1���� ������ �����´�.
    public CommentBean getComment(int comment_num)
    {
        CommentBean comment = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
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
    
    
    // ��� ����
    public boolean deleteComment(int comment_num) 
    {
        boolean result = false;
 
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);
 
            String sql = "DELETE FROM BOARD_COMMENT WHERE COMMENT_NUM = ?";
           
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, comment_num);
            
            int flag = pstmt.executeUpdate();
            if(flag > 0){
                result = true;
                conn.commit(); // �Ϸ�� Ŀ��
            }    
            
        } catch (Exception e) {
            try {
                conn.rollback(); // ������ �ѹ�
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
            throw new RuntimeException(e.getMessage());
        }
 
        close();
        return result;
    } // end deleteComment    

    // DB �ڿ�����
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



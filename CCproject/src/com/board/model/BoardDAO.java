package com.board.model;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.board.model.BoardBean;

public class BoardDAO 
{
    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;
    
    private static BoardDAO instance;
    
    private BoardDAO(){}
    public static BoardDAO getInstance(){
        if(instance==null)
            instance=new BoardDAO();
        return instance;
    }
    
    // �������� �����´�.
    public int getSeq()
    {
        int result = 1;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
            
            // ������ ���� �����´�. (DUAL : ������ ���� ������������ �ӽ� ���̺�)
            String sql = "SELECT BOARD_NUM FROM board";   
            pstmt = conn.prepareStatement(sql);
            // ���� ����
            rs = pstmt.executeQuery();
            
            if(rs.next())    result = rs.getInt(1);
 
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return result;    
    } // end getSeq
    
    // �� ����
    public boolean boardInsert(BoardBean board)
    {
        boolean result = false;
        int currval = 0;
        System.out.println("ss");
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);

            
            Statement stmt = conn.createStatement();
			String sql = "select board_num from board";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				currval = rs.getInt("board_num");
			}
			
            sql = "INSERT INTO board (BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE"
            		+ ", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_COUNT, BOARD_DATE) VALUES(?,?,?,?,?,?,?,?,?,now())";
            // ������ ���� �۹�ȣ�� �׷��ȣ�� ���
 
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, currval+1);
            pstmt.setString(2, board.getBoard_id());
            pstmt.setString(3, board.getBoard_subject());
            pstmt.setString(4, board.getBoard_content());
            pstmt.setString(5, board.getBoard_file());
            pstmt.setInt(6,currval+1);
            pstmt.setInt(7, 0);
            pstmt.setInt(8, 0);
            pstmt.setInt(9, 0);
            
            int flag = pstmt.executeUpdate();
            if(flag > 0){
               result = true;
               conn.commit(); 
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        close();
        return result;    
    } // end boardInsert();
    
 // �۸�� ��������
    public ArrayList<BoardBean> getBoardList(HashMap<String, Object> listOpt)
    {
        ArrayList<BoardBean> list = new ArrayList<BoardBean>();
        String opt = (String)listOpt.get("opt"); // �˻��ɼ�(����, ����, �۾��� ��..)
        String condition = (String)listOpt.get("condition"); // �˻�����
        int start = (Integer)listOpt.get("start"); // ���� ��������ȣ
        System.out.println(opt);
        System.out.println(condition);
        System.out.println(start);
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
            
    		
            // �۸�� ��ü�� ������ ��
            if(opt == null)
            {
                // BOARD_RE_REF(�׷��ȣ)�� �������� ���� �� ������ �׷��ȣ�� ����
                // BOARD_RE_SEQ(�亯�� ����)�� ������������ ���� �� �Ŀ�
                // 10���� ���� �� ȭ�鿡 �����ִ�(start��° ���� start+9����) ����
                // desc : ��������, asc : �������� ( ���� ���� )
            	
            	String sql = "select * from board order by BOARD_RE_REF desc, BOARD_RE_SEQ asc LIMIT 10 OFFSET ?";
            	pstmt = conn.prepareStatement(sql);
                	pstmt.setInt(1, start);
                
            }
            else if(opt.equals("0")) // �������� �˻�
            {
            	
            	String sql = "select * from board where BOARD_SUBJECT like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc "
            			+ "LIMIT 10 OFFSET ?";

                pstmt = conn.prepareStatement(sql);
                	pstmt.setString(1, "%"+condition+"%");
                	pstmt.setInt(2, start);
         
                
            }
            else if(opt.equals("1")) // �������� �˻�
            {
            	String sql = "select * from board where BOARD_CONTENT like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc "
            			+ "LIMIT 10 OFFSET ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%"+condition+"%");
            	pstmt.setInt(2, start);

               
            }
            else if(opt.equals("2")) // ����+�������� �˻�
            {
            	String sql = "select * from board where BOARD_SUBJECT like ? OR BOARD_CONTENT like ? "
            			+ "order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc"
            			+ "LIMIT 10 OFFSET ?";
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%"+condition+"%");
                pstmt.setString(2, "%"+condition+"%");
            	pstmt.setInt(3, start);

               
                
            }
            else if(opt.equals("3")) // �۾��̷� �˻�
            {
            	String sql = "select * from board where BOARD_ID like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc "
            			+ "LIMIT 10 OFFSET ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%"+condition+"%");
            	pstmt.setInt(2, start);

            }
            
            rs = pstmt.executeQuery();
            
            while(rs.next())
            {
                BoardBean board = new BoardBean();
                board.setBoard_num(rs.getInt("BOARD_NUM"));
                board.setBoard_id(rs.getString("BOARD_ID"));
                board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
                board.setBoard_content(rs.getString("BOARD_CONTENT"));
                board.setBoard_file(rs.getString("BOARD_FILE"));
                board.setBoard_count(rs.getInt("BOARD_COUNT"));
                board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
                board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
                board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
                board.setBoard_date(rs.getDate("BOARD_DATE"));

                list.add(board);
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return list;
    } // end getBoardList
    
    // ���� ������ �������� �޼���
    public int getBoardListCount(HashMap<String, Object> listOpt)
    {
        int result = 0;
        String opt = (String)listOpt.get("opt"); // �˻��ɼ�(����, ����, �۾��� ��..)
        String condition = (String)listOpt.get("condition"); // �˻�����
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);

            
            if(opt == null)    // ��ü���� ����
            {
            	String sql = "select count(*) from board";
                pstmt = conn.prepareStatement(sql);
                
                // StringBuffer�� ����.
                sql = null;
            }
            else if(opt.equals("0")) // �������� �˻��� ���� ����
            {
            	String sql = "select count(*) from board where BOARD_SUBJECT like ?";
                pstmt = conn.prepareStatement(sql);
                               
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, '%'+condition+'%');
                
                sql = null;
            }
            else if(opt.equals("1")) // �������� �˻��� ���� ����
            {
            	String sql = "select count(*) from board where BOARD_CONTENT like ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, '%'+condition+'%');
                sql = null;
            }
            else if(opt.equals("2")) // ����+�������� �˻��� ���� ����
            {
            	String sql = "select count(*) from board where BOARD_SUBJECT like ? or BOARD_CONTENT like ?";
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, '%'+condition+'%');
                pstmt.setString(2, '%'+condition+'%');
                sql = null;
            }
            else if(opt.equals("3")) // �۾��̷� �˻��� ���� ����
            {
            	String sql = "select count(*) from board where BOARD_ID like ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, '%'+condition+'%');
                sql = null;
            }
            
            rs = pstmt.executeQuery();
            if(rs.next())    result = rs.getInt(1);
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return result;
    } // end getBoardListCount
    
    // �󼼺���
    public BoardBean getDetail(int boardNum)
    {    
        BoardBean board = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);


        	String sql = "select * from board where BOARD_NUM = ?";
   
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                board = new BoardBean();
                board.setBoard_num(boardNum);
                board.setBoard_id(rs.getString("BOARD_ID"));
                board.setBoard_subject(rs.getString("BOARD_SUBJECT"));
                board.setBoard_content(rs.getString("BOARD_CONTENT"));
                board.setBoard_file(rs.getString("BOARD_FILE"));
                board.setBoard_count(rs.getInt("BOARD_COUNT"));
                board.setBoard_re_ref(rs.getInt("BOARD_RE_REF"));
                board.setBoard_re_lev(rs.getInt("BOARD_RE_LEV"));
                board.setBoard_re_seq(rs.getInt("BOARD_RE_SEQ"));
                board.setBoard_date(rs.getDate("BOARD_DATE"));
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return board;
    } // end getDetail()
    
    // ��ȸ�� ����
    public boolean updateCount(int boardNum)
    {
        boolean result = false;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);


            String sql = "update board set BOARD_COUNT = BOARD_COUNT+1 where BOARD_NUM = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            
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
    } // end updateCount
    
 // ������ ���ϸ��� �����´�.
    public String getFileName(int boardNum)
    {
        String fileName = null;
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);

            
            String sql = "SELECT BOARD_FILE from board where BOARD_NUM=?";
            
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, boardNum);
            
            rs = pstmt.executeQuery();
            if(rs.next()) fileName = rs.getString("BOARD_FILE");
            
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return fileName;
    } // end getFileName
        
    // �Խñ� ����
    public boolean deleteBoard(int boardNum) 
    {
        boolean result = false;
 
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);

            
            String sql = "DELETE FROM board WHERE BOARD_NUM =?";
            		
           
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            
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
    } // end deleteBoard

 // �� ����
    public boolean updateBoard(BoardBean border) 
    {
        boolean result = false;
        
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			conn.setAutoCommit(false);
            
            String sql = "UPDATE board SET BOARD_SUBJECT=? ,BOARD_CONTENT=? ,BOARD_FILE=? ,BOARD_DATE=now() WHERE BOARD_NUM=?";
       
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, border.getBoard_subject());
            pstmt.setString(2, border.getBoard_content());
            pstmt.setString(3, border.getBoard_file());
            pstmt.setInt(4, border.getBoard_num());
            
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
    } // end updateBoard


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



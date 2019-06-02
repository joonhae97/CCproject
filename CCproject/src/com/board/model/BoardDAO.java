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
            
            // 시퀀스 값을 가져온다. (DUAL : 시퀀스 값을 가져오기위한 임시 테이블)
            String sql = "SELECT BOARD_NUM FROM board";   
            pstmt = conn.prepareStatement(sql);
            // 쿼리 실행
            rs = pstmt.executeQuery();
            
            if(rs.next())    result = rs.getInt(1);
 
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        close();
        return result;    
    } // end getSeq
    
    // 글 삽입
    public boolean boardInsert(BoardBean board)
    {
        boolean result = false;
        int currval = 0;
        System.out.println("ss");
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            conn.setAutoCommit(false);
            
            Statement stmt = conn.createStatement();
			String sql = "select board_num from board";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				currval = rs.getInt("board_num");
			}
			
            sql = "INSERT INTO board (BOARD_NUM, BOARD_ID, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE"
            		+ ", BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_COUNT, BOARD_DATE) VALUES(?,?,?,?,?,?,?,?,?,now())";
            // 시퀀스 값을 글번호와 그룹번호로 사용
 
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
    
 // 글목록 가져오기
    public ArrayList<BoardBean> getBoardList(HashMap<String, Object> listOpt)
    {
        ArrayList<BoardBean> list = new ArrayList<BoardBean>();
        String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
        String condition = (String)listOpt.get("condition"); // 검색내용
        int start = (Integer)listOpt.get("start"); // 현재 페이지번호
        System.out.println(opt);
        System.out.println(condition);
        System.out.println(start);
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
    		
            // 글목록 전체를 보여줄 때
            if(opt == null)
            {
                // BOARD_RE_REF(그룹번호)의 내림차순 정렬 후 동일한 그룹번호일 때는
                // BOARD_RE_SEQ(답변글 순서)의 오름차순으로 정렬 한 후에
                // 10개의 글을 한 화면에 보여주는(start번째 부터 start+9까지) 쿼리
                // desc : 내림차순, asc : 오름차순 ( 생략 가능 )
            	
            	String sql = "select * from board order by BOARD_RE_REF desc, BOARD_RE_SEQ asc LIMIT 10 OFFSET ?";
            	pstmt = conn.prepareStatement(sql);
                	pstmt.setInt(1, start);
                
            }
            else if(opt.equals("0")) // 제목으로 검색
            {
            	
            	String sql = "select * from board where BOARD_SUBJECT like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc "
            			+ "LIMIT 10 OFFSET ?";

                pstmt = conn.prepareStatement(sql);
                	pstmt.setString(1, "%"+condition+"%");
                	pstmt.setInt(2, start);
         
                
            }
            else if(opt.equals("1")) // 내용으로 검색
            {
            	String sql = "select * from board where BOARD_CONTENT like ? order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc "
            			+ "LIMIT 10 OFFSET ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%"+condition+"%");
            	pstmt.setInt(2, start);

               
            }
            else if(opt.equals("2")) // 제목+내용으로 검색
            {
            	String sql = "select * from board where BOARD_SUBJECT like ? OR BOARD_CONTENT like ? "
            			+ "order BY BOARD_RE_REF desc, BOARD_RE_SEQ asc"
            			+ "LIMIT 10 OFFSET ?";
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, "%"+condition+"%");
                pstmt.setString(2, "%"+condition+"%");
            	pstmt.setInt(3, start);

               
                
            }
            else if(opt.equals("3")) // 글쓴이로 검색
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
    
    // 글의 개수를 가져오는 메서드
    public int getBoardListCount(HashMap<String, Object> listOpt)
    {
        int result = 0;
        String opt = (String)listOpt.get("opt"); // 검색옵션(제목, 내용, 글쓴이 등..)
        String condition = (String)listOpt.get("condition"); // 검색내용
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            
            if(opt == null)    // 전체글의 개수
            {
            	String sql = "select count(*) from board";
                pstmt = conn.prepareStatement(sql);
                
                // StringBuffer를 비운다.
                sql = null;
            }
            else if(opt.equals("0")) // 제목으로 검색한 글의 개수
            {
            	String sql = "select count(*) from board where BOARD_SUBJECT like ?";
                pstmt = conn.prepareStatement(sql);
                               
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, '%'+condition+'%');
                
                sql = null;
            }
            else if(opt.equals("1")) // 내용으로 검색한 글의 개수
            {
            	String sql = "select count(*) from board where BOARD_CONTENT like ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, '%'+condition+'%');
                sql = null;
            }
            else if(opt.equals("2")) // 제목+내용으로 검색한 글의 개수
            {
            	String sql = "select count(*) from board where BOARD_SUBJECT like ? or BOARD_CONTENT like ?";
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, '%'+condition+'%');
                pstmt.setString(2, '%'+condition+'%');
                sql = null;
            }
            else if(opt.equals("3")) // 글쓴이로 검색한 글의 개수
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
    
    // 상세보기
    public BoardBean getDetail(int boardNum)
    {    
        BoardBean board = null;
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
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
    
    // 조회수 증가
    public boolean updateCount(int boardNum)
    {
        boolean result = false;
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            conn.setAutoCommit(false);

            String sql = "update board set BOARD_COUNT = BOARD_COUNT+1 where BOARD_NUM = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            
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
    } // end updateCount
    
 // 삭제할 파일명을 가져온다.
    public String getFileName(int boardNum)
    {
        String fileName = null;
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
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
        
    // 게시글 삭제
    public boolean deleteBoard(int boardNum) 
    {
        boolean result = false;
 
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            conn.setAutoCommit(false);
            
            String sql = "DELETE FROM board WHERE BOARD_NUM =?";
            		
           
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boardNum);
            
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
    } // end deleteBoard

 // 글 수정
    public boolean updateBoard(BoardBean border) 
    {
        boolean result = false;
        
        try{
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
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
    } // end updateBoard


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



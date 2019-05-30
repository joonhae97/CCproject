package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

 
import com.login.beans.MemberBean;

public class MemberDAO {
	private static MemberDAO instance;
    private MemberDAO(){}
    
    //싱글톤 패턴
    public static MemberDAO getInstance(){
        if(instance == null ) instance = new MemberDAO();
        return instance;
    }
    
    // 회원가입 메서드
    public void joinMember(MemberBean bean) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 쿼리
        	Class.forName("com.mysql.jdbc.Driver");
            String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

        	String sql = "INSERT INTO jspdb VALUES(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
	            // MemberBean에 담긴 값을 가져와 쿼리문에 세팅한다.
	            pstmt.setString(1, bean.getId());
	            pstmt.setString(2, bean.getPw());
	            pstmt.setString(3, bean.getName());
	            pstmt.setString(4, bean.getGender());
	            pstmt.setString(5, bean.getEmail());
	            // 쿼리실행
	            pstmt.executeUpdate();
 
        } catch (Exception sqle) {
            try {
                conn.rollback(); // 오류시 롤백
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(sqle.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                    pstmt = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    } // end joinMember()
    
 // 로그인시 아이디, 비밀번호 체크 메서드
    // 아이디, 비밀번호를 인자로 받는다.
    public int loginCheck(String id, String pw) 
    {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
 
        String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
        int x = -1;
 
        try {
            // 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
        	Class.forName("com.mysql.jdbc.Driver");
        	String jdbcDriver = "jdbc:mysql://127.0.0.1/jspdb";
          	String dbUser = "scott";
          	String dbPass = "1234";
        	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
        	String sql = "SELECT PASSWORD FROM jspdb WHERE ID=?";
            pstmt = conn.prepareStatement(sql);
            	pstmt.setString(1, id);
            rs = pstmt.executeQuery();
 
            if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
            {
                dbPW = rs.getString("password"); // 비번을 변수에 넣는다.
 
                if (dbPW.equals(pw)) 
                    x = 1; // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
                else                  
                    x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
                
            } else {
                x = -1; // 해당 아이디가 없을 경우
            }
            return x;
 
        } catch (Exception sqle) {
            throw new RuntimeException(sqle.getMessage());
        } finally {
            try{
                if ( pstmt != null ){ pstmt.close(); pstmt=null; }
                if ( conn != null ){ conn.close(); conn=null;    }
            }catch(Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }
    } // end loginCheck()


}


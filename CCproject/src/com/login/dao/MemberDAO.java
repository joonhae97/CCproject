package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;


import com.login.beans.MemberBean;

public class MemberDAO {
	private static MemberDAO instance;
	private MemberDAO(){}

	//�̱��� ����
	public static MemberDAO getInstance(){
		if(instance == null ) instance = new MemberDAO();
		return instance;
	}

	// ȸ������ �޼���
	public void joinMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// ����
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			
			
			String sql = "INSERT INTO usertable VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// MemberBean�� ��� ���� ������ �������� �����Ѵ�.
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPw());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getGender());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getCollege());
			pstmt.setString(7, bean.getHometown());
			pstmt.setString(8, bean.getAge());
			pstmt.setString(9, bean.getHeight());
			pstmt.setString(10, bean.getInteresting());
			pstmt.setString(11, bean.getCharacter());
			pstmt.setInt(12, bean.getKey());
			System.out.println("test");
			// ��������
			pstmt.executeUpdate();

		} catch (Exception sqle) {
			try {
				con.rollback(); // ������ �ѹ�
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
				if (con != null) {
					con.close();
					con = null;
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end joinMember()

	// �α��ν� ���̵�, ��й�ȣ üũ �޼���
	// ���̵�, ��й�ȣ�� ���ڷ� �޴´�.
	public int loginCheck(String id, String pw) 
	{

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String dbPW = ""; // db���� ���� ��й�ȣ�� ���� ����
		int x = -1;

		try {
			// ���� - ���� �Էµ� ���̵�� DB���� ��й�ȣ�� ��ȸ�Ѵ�.
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			String sql = "SELECT password FROM usertable WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) // �Է��� ���̵� �ش��ϴ� ��� �������
			{
				dbPW = rs.getString("password"); // ����� ������ �ִ´�.

				if (dbPW.equals(pw)) 
					x = 1; // �Ѱܹ��� ����� ������ ��� ��. ������ ��������
				else                  
					x = 0; // DB�� ��й�ȣ�� �Է¹��� ��й�ȣ �ٸ�, ��������

			} else {
				x = -1; // �ش� ���̵� ���� ���
			}
			return x;

		} catch (Exception sqle) {
			throw new RuntimeException(sqle.getMessage());
		} finally {
			try{
				if ( pstmt != null ){ pstmt.close(); pstmt=null; }
				if ( con != null ){ con.close(); con=null;    }
			}catch(Exception e){
				throw new RuntimeException(e.getMessage());
			}
		}
	} // end loginCheck()
	public MemberBean user(String id){
		MemberBean userinfo=new MemberBean();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			String query="SELECT * FROM usertable WHERE id="+"\""+id+"\"";

			pstmt=con.prepareStatement(query);

			rs=pstmt.executeQuery();

			rs.next();
			userinfo.setId(rs.getString("id"));
			userinfo.setGender(rs.getString("gender"));
			userinfo.setCollege(rs.getString("college"));
			userinfo.setHometown(rs.getString("hometown"));
			userinfo.setAge(rs.getString("age"));
			userinfo.setHeight(rs.getString("height"));
			userinfo.setInteresting(rs.getString("interesting"));
			userinfo.setCharacter(rs.getString("character"));

		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userinfo;
	}
	public ArrayList<MemberBean> userlist(){
		ArrayList<MemberBean> userlist=new ArrayList<MemberBean>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");	
			String query="SELECT * FROM usertable;";

			pstmt=con.prepareStatement(query);

			rs=pstmt.executeQuery();

			while(rs.next()) {
				MemberBean data=new MemberBean();
				data.setId(rs.getString("id"));
				data.setGender(rs.getString("gender"));
				data.setCollege(rs.getString("college"));
				data.setHometown(rs.getString("hometown"));
				data.setAge(rs.getString("age"));
				data.setHeight(rs.getString("height"));
				data.setInteresting(rs.getString("interesting"));
				data.setCharacter(rs.getString("character"));
				userlist.add(data);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userlist;
	}
	public int chatkey() {
		int key=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//connection pool
			//con=ds.getConnection();
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			String query="SELECT chatkey FROM usertable ORDER BY chatkey DESC;";
						
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
					key=rs.getInt("chatkey")+1;					
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("key :" + key);
		return key;
	}
	public void setChatkey(String id,int key) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			//connection pool
			//con=ds.getConnection();

			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");	

			String query="UPDATE usertable SET chatkey=? WHERE id=?";
			pstmt=con.prepareStatement(query);

			pstmt.setInt(1, key);
			pstmt.setString(2, id);
			pstmt.executeUpdate();

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}

		}
	}

}


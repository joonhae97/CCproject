package com.register.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class ApplyDAO {
	ResultSet rs = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	DataSource ds;

	public ApplyDAO(){

	}

	public ArrayList<ApplyDTO> list(){
		ArrayList<ApplyDTO> applylist=new ArrayList<ApplyDTO>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			
			String query="SELECT * FROM applytable ORDER BY applytime DESC;";
			pstmt=con.prepareStatement(query);

			rs=pstmt.executeQuery();

			while(rs.next()) {
				ApplyDTO data=new ApplyDTO();
				data.setId(rs.getString("id"));
				data.setGender(rs.getString("gender"));
				data.setCollege(rs.getString("college"));
				data.setHometown(rs.getString("hometown"));
				data.setAge(rs.getString("age"));
				data.setMinheight(rs.getString("minheight"));
				data.setMaxheight(rs.getString("maxheight"));
				data.setInteresting(rs.getString("interesting"));
				data.setCharacter(rs.getString("character"));
				data.setTime(rs.getTimestamp("applytime").toLocalDateTime());
				applylist.add(data);
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
		return applylist;
	}
	
	public ApplyDTO application(String id) {
		ApplyDTO data=new ApplyDTO();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");	
			String query="SELECT * FROM applytable WHERE id="+"\""+id+"\"";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				data.setId(rs.getString("id"));
				data.setGender(rs.getString("gender"));
				data.setCollege(rs.getString("college"));
				data.setHometown(rs.getString("hometown"));
				data.setAge(rs.getString("age"));
				data.setMinheight(rs.getString("minheight"));
				data.setMaxheight(rs.getString("maxheight"));
				data.setInteresting(rs.getString("interesting"));
				data.setCharacter(rs.getString("character"));
			}
			else {
				data.setId(id);
				data.setGender("신청 정보가 없습니다.");
				data.setCollege("신청 정보가 없습니다.");
				data.setHometown("신청 정보가 없습니다.");
				data.setAge("신청 정보가 없습니다.");
				data.setMinheight("0");
				data.setMaxheight("0");
				data.setInteresting("신청 정보가 없습니다.");
				data.setCharacter("신청 정보가 없습니다.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return data;
	}
	public void write(String _id, String _gender, String _college, String _hometown, 
			String _age, String _minheight, String _maxheight, String _interesting, String _character) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");	
				
			String query="INSERT INTO applytable values (?, ?, ?, ?, ?, ?, ?, ?,?,?)";
			pstmt=con.prepareStatement(query);

			pstmt.setString(1, _id);
			pstmt.setString(2, _gender);
			pstmt.setString(3, _college);
			pstmt.setString(4, _hometown);
			pstmt.setString(5, _age);
			pstmt.setString(6, _minheight);
			pstmt.setString(7, _maxheight);
			pstmt.setString(8, _interesting);
			pstmt.setString(9, _character);
			pstmt.setTimestamp(10, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.executeUpdate();


		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}
	}
	public void deleteApplication(String id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");	
			String query="SELECT * FROM applytable WHERE id="+"\""+id+"\"";
			pstmt=con.prepareStatement(query);
			rs=pstmt.executeQuery();

			if(rs.next()) {
				String squery="DELETE FROM applytable WHERE id="+"\""+id+"\"";
				pstmt=con.prepareStatement(squery);
				pstmt.executeUpdate();
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
	}
	public String getUserGender(String id) {
		String gender=new String();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드    
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/applydb?serverTimezone=UTC", "root","1223");
			
			String sql = "SELECT gender FROM usertable WHERE id=?";
            pstmt = con.prepareStatement(sql);
           
            pstmt.setString(1, id);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				gender=rs.getString("gender");
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
		return gender;
	}
	
}

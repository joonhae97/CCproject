package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	ResultSet rs = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	DataSource ds;
	
	public UserDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public UserDTO user(String id){
		UserDTO userinfo=new UserDTO();
		
		try {
		con=ds.getConnection();
		String query="SELECT * FROM usertable WHERE userid="+"\""+id+"\"";

		pstmt=con.prepareStatement(query);
		
		rs=pstmt.executeQuery();
		
		rs.next();
		userinfo.setUserid(rs.getString("userid"));
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
	public ArrayList<UserDTO> userlist(){
		ArrayList<UserDTO> userlist=new ArrayList<UserDTO>();
		
		try {
		con=ds.getConnection();
		String query="SELECT * FROM usertable;";
		
		pstmt=con.prepareStatement(query);
		
		rs=pstmt.executeQuery();
		
		while(rs.next()) {
			UserDTO data=new UserDTO();
			data.setUserid(rs.getString("userid"));
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
}

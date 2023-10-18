package testWeb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testWeb.dao.UserRegisterDAO;
import testWeb.db.DBConnect;
import testWeb.vo.UserInfo;

public class UserRegisterDAOImpl implements UserRegisterDAO {
	public int UserRegister(UserInfo u) {
		int flag=0;
		PreparedStatement pstmt=null;
		PreparedStatement PSTMT1=null;
		PreparedStatement PSTMT2=null;
		PreparedStatement PSTMT3=null;
		PreparedStatement PSTMT4=null;
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			String sql="INSERT INTO userinfo(phonenumber,email,username,password,robotname) VALUES (?,?,?,?,?)";
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, u.getPhonenumber());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getUsername());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getRobotname());
			
			String SQL1="SELECT * FROM userinfo where phonenumber=?";
			PSTMT1 = dbc.getConnection().prepareStatement(SQL1);
			PSTMT1.setString(1, u.getPhonenumber());
			ResultSet rs1=PSTMT1.executeQuery();
			
			String SQL2="SELECT * FROM userinfo where email=?";
			PSTMT2 = dbc.getConnection().prepareStatement(SQL2);
			PSTMT2.setString(1, u.getEmail());
			ResultSet rs2=PSTMT2.executeQuery();
			
			String SQL3="SELECT * FROM userinfo where username=?";
			PSTMT3 = dbc.getConnection().prepareStatement(SQL3);
			PSTMT3.setString(1, u.getUsername());
			ResultSet rs3=PSTMT3.executeQuery();
			
			String SQL4="SELECT * FROM userinfo where robotname=?";
			PSTMT4 = dbc.getConnection().prepareStatement(SQL4);
			PSTMT4.setString(1, u.getRobotname());
			ResultSet rs4=PSTMT4.executeQuery();
			
			if(rs1.next()) {
				flag=1;
			}
			else if(rs2.next()) {
				flag=2;
			}
			else if(rs3.next()) {
				flag=3;
			}
			else if(rs4.next()) {
				flag=4;
			}
			else {
				pstmt.executeUpdate();
				flag=5;
			}
		}catch(SQLException e) {
        	System.out.println(e.getMessage());  
        }finally{    
            dbc.close();
        }
		return flag;
	}
}

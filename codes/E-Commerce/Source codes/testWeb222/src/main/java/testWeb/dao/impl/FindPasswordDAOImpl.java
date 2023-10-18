package testWeb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testWeb.dao.FindPasswordDAO;
import testWeb.db.DBConnect;
import testWeb.vo.UserInfo;

public class FindPasswordDAOImpl implements FindPasswordDAO{
	public int FindPassword(UserInfo u) {
		int flag=0;
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			String sql="SELECT * FROM userinfo where username=?";
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			ResultSet ret=pstmt.executeQuery();
			if(ret.next()) {
				u.setPassword(u.getNewpassword());
				String SQL="UPDATE userinfo SET password=? WHERE username=?";
				pstmt=dbc.getConnection().prepareStatement(SQL);
				pstmt.setString(1, u.getPassword());
				pstmt.setString(2, u.getUsername());
				int rs=pstmt.executeUpdate();
				if(rs>0) {
					flag=1;
				}
			}
		}catch(SQLException e) {
        	System.out.println(e.getMessage());  
        }finally{    
            dbc.close();
        }
		return flag;
	}
}

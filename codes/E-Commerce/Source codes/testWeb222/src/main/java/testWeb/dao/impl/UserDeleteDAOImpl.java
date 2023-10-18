package testWeb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testWeb.dao.UserDeleteDAO;
import testWeb.db.DBConnect;
import testWeb.vo.UserInfo;

public class UserDeleteDAOImpl implements UserDeleteDAO{
	public int userdelete(UserInfo u) {
		int flag = 0;
		int ret = 0;
		int result = 0;
		PreparedStatement pstmt = null;
        DBConnect dbc = null;    
		try {
			dbc = new DBConnect();
			String sql = "DELETE FROM userinfo WHERE username=?";
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, u.getUsername());			
			flag = pstmt.executeUpdate();
			pstmt.close();
			if (flag>0) {
				String SQL= "DELETE FROM history WHERE robotname=?";
				pstmt = dbc.getConnection().prepareStatement(SQL);
				pstmt.setString(1, u.getRobotname());
				ret = pstmt.executeUpdate();
				pstmt.close();
				if (ret>0||ret==0) {
					String DeleteSql = "DELETE FROM exploration WHERE robotname=?";
					pstmt = dbc.getConnection().prepareStatement(DeleteSql);
					pstmt.setString(1, u.getRobotname());
					result = pstmt.executeUpdate();
					pstmt.close();
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			dbc.close();
		}
		return result;
	}
	
	public String SelectRobotname(String username) {
	    String robotname = null;
	    PreparedStatement pstmt = null;
	    DBConnect dbc = null;

	    try {
	        dbc = new DBConnect();
	        String sql = "SELECT robotname FROM userinfo WHERE username=?";
	        pstmt = dbc.getConnection().prepareStatement(sql);
	        pstmt.setString(1, username);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            robotname = rs.getString("robotname");
	        }
	        rs.close();
	        pstmt.close();
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	        dbc.close();
	    }
	    return robotname;
	}
}

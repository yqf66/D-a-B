package testWeb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import testWeb.dao.HistorySearchDAO;
import testWeb.db.DBConnect;
import testWeb.vo.HistoryRecord;
import testWeb.vo.UserInfo;

public class HistorySearchDAOImpl implements HistorySearchDAO {
	public ArrayList<HistoryRecord> HistorySearch(UserInfo user){
		ArrayList<HistoryRecord> list = new ArrayList<HistoryRecord>();
		DBConnect dbc = null;
		PreparedStatement pstmt = null;
        //PreparedStatement PSTMT = null;
        try {
        	dbc=new DBConnect();
        	String sql="SELECT * FROM history where robotname=?";
        	pstmt=dbc.getConnection().prepareStatement(sql);
        	pstmt.setString(1, user.getRobotname());  //将字符串的值传递给sql语句的占位符
        	ResultSet rs=pstmt.executeQuery();
        	while(rs.next()) {
        		HistoryRecord record=new HistoryRecord(rs.getInt("historyRecordID"),rs.getString("robotname"),rs.getString("exploration_time"),rs.getString("treasure"),rs.getString("picture"));
				list.add(record);
        	}
        	rs.close();
        	pstmt.close();
        }catch(SQLException e) {
        	System.out.println(e.getMessage());  
        }finally{    
            dbc.close();
        }
		return list;
	}
	
	public int UserSearch(UserInfo user) {
		int flag=0;
		DBConnect dbc = null;
		PreparedStatement pstmt = null;
		try {
			dbc=new DBConnect();
			String sql="SELECT * FROM userinfo WHERE username=?";
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				flag=1;
				user.setRobotname(rs.getString("robotname"));
			}
			else {
				flag=0;
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
        	System.out.println(e.getMessage());  
        }finally{    
            dbc.close();
        }
		return flag;
	}
}

package testWeb.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import testWeb.dao.RobotSearchDAO;
import testWeb.db.DBConnect;
import testWeb.vo.UserInfo;
import testWeb.vo.Exploration;

public class RobotSearchDAOImpl implements RobotSearchDAO{
	/*public int RobotSearch(Exploration e, UserInfo u) {
		int flag=0;
		PreparedStatement pstmt=null;
		PreparedStatement PSTMT=null;
		DBConnect dbc = null;
		try {
			dbc = new DBConnect();
			String sql="SELECT * FROM userinfo where username=?";
			pstmt = dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			ResultSet ret=pstmt.executeQuery();
			if(ret.next()) {
				u.setRobotname(ret.getString("robotname"));
				String SQL="SELECT timestamp, statistic_of_treasure FROM exploration WHERE robotname=?";
				PSTMT=dbc.getConnection().prepareStatement(SQL);
				PSTMT.setString(1, u.getRobotname());
				ResultSet rs=PSTMT.executeQuery();
				if(rs.next()) {
					e.setTimestamp(rs.getString("timestamp"));
					e.setStatistic_of_treasure(rs.getString("statistic_of_treasure"));
					flag=1;
				}
				else {
					flag=2;
				}
			}
			else {
				flag=3;
			}
		}catch(SQLException se) {
        	System.out.println(se.getMessage());  
        }finally{    
            dbc.close();
        }
		return flag;
	}*/
	public ArrayList<Exploration> RobotSearch(UserInfo user){
		DBConnect dbc = null;
		PreparedStatement pstmt=null;
		ArrayList<Exploration> List=new ArrayList<Exploration>();
		try {
			dbc = new DBConnect();
			String sql="SELECT * FROM exploration WHERE robotname=?";
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getRobotname());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Exploration e=new Exploration(rs.getString("robotname"),rs.getString("timestamp"),rs.getString("statistic_of_treasure"));
				List.add(e);
			}
			rs.close();
			pstmt.close();
		}catch(SQLException se) {
        	System.out.println(se.getMessage());  
        }finally{    
            dbc.close();
        }
		return List;
	}
	
	public int UserSearch(UserInfo user) {
		int flag=0;
		DBConnect dbc = null;
		PreparedStatement pstmt=null;
		try {
			dbc = new DBConnect();
			String sql="SELECT * FROM userinfo WHERE username=?";
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				user.setRobotname(rs.getString("robotname"));
				flag=1;
			}
			else {
				flag=0;
			}
			rs.close();
			pstmt.close();
		}catch(SQLException se) {
        	System.out.println(se.getMessage());  
        }finally{    
            dbc.close();
        }
		return flag;
	}
}

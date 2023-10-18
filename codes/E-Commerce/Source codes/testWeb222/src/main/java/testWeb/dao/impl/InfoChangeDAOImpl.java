package testWeb.dao.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testWeb.dao.InfoChangeDAO;
import testWeb.db.DBConnect;
import testWeb.vo.*;

public class InfoChangeDAOImpl implements InfoChangeDAO{
	public int InfoChange(HistoryRecord r,UserInfo u,Exploration e) {
		int ret=0;
		DBConnect dbc = null;
		PreparedStatement pstmt = null;
        PreparedStatement PSTMT = null;
        ResultSet rs = null;
        try {
        	dbc = new DBConnect();
        	String selectSql = "SELECT * FROM userinfo NATURAL JOIN history WHERE username=?";
        	PSTMT = dbc.getConnection().prepareStatement(selectSql);
        	PSTMT.setString(1, u.getUsername());
            rs = PSTMT.executeQuery();
            if(rs.next()) {
            	String updateSql = "UPDATE userinfo NATURAL JOIN history SET robotname=?, picture=?, treasure=?, exploration_time=? WHERE username=?";
                pstmt = dbc.getConnection().prepareStatement(updateSql);
                pstmt.setString(1, r.getNewRobotname());
                if (r.getNewRobotname().isEmpty()) {
                    pstmt.setString(1, rs.getString("robotname"));
                } else {
                    pstmt.setString(1, r.getNewRobotname());
                }
                
                pstmt.setString(2, r.getNewPicture());
                if (r.getNewPicture().isEmpty()) {
                    pstmt.setString(2, rs.getString("picture"));
                } else {
                    pstmt.setString(2, r.getNewPicture());
                }
                
                pstmt.setString(3, r.getNewtreasure());
                if (r.getNewtreasure().isEmpty()) {
                    pstmt.setString(3, rs.getString("treasure"));
                } else {
                    pstmt.setString(3, r.getNewtreasure());
                }
                
                pstmt.setString(4, r.getNewexploration_time());              
                if (r.getNewexploration_time().isEmpty()) {
                    pstmt.setString(4, rs.getString("exploration_time"));
                } else {
                    pstmt.setString(4, r.getNewexploration_time());
                }
                
                pstmt.setString(5, u.getUsername());
                int result=pstmt.executeUpdate();
                if(result>0) {
                	String sql="UPDATE history SET robotname=? where robotname=?";
                    PSTMT = dbc.getConnection().prepareStatement(sql);
                    PSTMT.setString(1, r.getNewRobotname());
                    PSTMT.setString(2, rs.getString("robotname"));
                    ret=PSTMT.executeUpdate();
                    ret=0;
                    String SQL="UPDATE exploration SET robotname=? where robotname=?";
                    PSTMT = dbc.getConnection().prepareStatement(SQL);
                    PSTMT.setString(1, e.getNewrobotname());
                    PSTMT.setString(2, rs.getString("robotname"));
                    ret=PSTMT.executeUpdate();
                }
            }
        }catch(SQLException se) {
        	System.out.println(se.getMessage());  
        }finally{    
            dbc.close();
        }
		return ret;
	}
	
	public int DataChange(HistoryRecord r) {
		int ret=0;
		DBConnect dbc = null;
		PreparedStatement pstmt = null;
		try {
			dbc = new DBConnect();
			String sql = "UPDATE history SET robotname=?, picture=?, treasure=?, exploration_time=? WHERE historyRecordID=?";
			pstmt = dbc.getConnection().prepareStatement(sql);
	        pstmt.setString(1, r.getNewRobotname());
//	        if (r.getNewRobotname().isEmpty()) {
	            pstmt.setString(1, r.getRobotname());
//	        } else {
//	            pstmt.setString(1, r.getNewRobotname());
//	        }
	        
//	        pstmt.setString(2, r.getNewPicture());
//	        if (r.getNewPicture().isEmpty()) {
	            pstmt.setString(2, r.getPicture());
//	        } else {
//	            pstmt.setString(2, r.getNewPicture());
//	        }
	        
//	        pstmt.setString(3, r.getNewtreasure());
//	        if (r.getNewtreasure().isEmpty()) {
	            pstmt.setString(3, r.getTreasure());
//	        } else {
//	            pstmt.setString(3, r.getNewtreasure());
//	        }
	        
//	        pstmt.setString(4, r.getNewexploration_time());              
//	        if (r.getNewexploration_time().isEmpty()) {
	            pstmt.setString(4, r.getExploration_time());
//	        } else {
//	            pstmt.setString(4, r.getNewexploration_time());
//	        }
	        
	        pstmt.setInt(5, r.getHistoryRecordID());
	        ret=pstmt.executeUpdate();
		}catch(SQLException se) {
        	System.out.println(se.getMessage());  
        }finally{    
            dbc.close();
        }
		return ret;
	}
	
	
	public HistoryRecord selectByID(Integer id) {
		int flag = 0;
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null; 
        String sql = "SELECT * FROM history historyRecordID where historyRecordID = ?";
        
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;
            pstmt=dbc.getConnection().prepareStatement(sql);
        	pstmt.setInt(1, id);  //将字符串的值传递给sql语句的占位符
        	ResultSet rs=pstmt.executeQuery();
        	while(rs.next()) {
        		return new HistoryRecord(rs.getInt("historyRecordID"),rs.getString("robotname"),rs.getString("exploration_time"),rs.getString("treasure"),rs.getString("picture"));
        	}
            rs.close() ; 
            pstmt.close() ;
            }catch (SQLException e){   
                System.out.println(e.getMessage());   
            }finally{   
                // 关闭数据库连接   
                dbc.close() ;   
            }
        return null;
	}
}

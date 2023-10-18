package testWeb.dao.impl;

/*import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.mysql.cj.jdbc.Blob;

import testWeb.dao.HistoryRecordDAO;
import testWeb.db.DBConnect;
import testWeb.vo.HistoryRecord;
import testWeb.vo.UserInfo;

public class HistoryRecordDAOImpl implements HistoryRecordDAO {
	//ArrayList<HistoryRecord> record = new ArrayList<HistoryRecord>();
	
	@Override
	public int addRecord(HistoryRecord Re) {
		// TODO Auto-generated method stub
		int row = 0;
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null; 
        String sql = "INSERT INTO history (exploration_time, treasure,picture,robotname) VALUES (?,?,?,?)";
        try {
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;
        	pstmt.setString(1, Re.getExploration_time());
        	pstmt.setString(2, Re.getTreasure());
        	pstmt.setString(3, Re.getPicture());
        	pstmt.setString(4, Re.getRobotname());
            row = pstmt.executeUpdate();
            pstmt.close();
        }catch(SQLException e) {
        	System.out.println(e.getMessage());  
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;  
        }
		return row;
	}

	@Override
	public ArrayList<HistoryRecord> selectRecord(UserInfo user) {
		// TODO Auto-generated method stub
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

	
	public int deleteRecord(HistoryRecord Re) {
		int row = 0;
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null; 
        String sql = "DELETE FROM history WHERE historyRecordID = ?";
        
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            pstmt.setInt(1, Re.getHistoryRecordID());
            row = pstmt.executeUpdate();
            pstmt.close();
            }
        catch(SQLException e) {
        	System.out.println(e.getMessage());  
        }finally{   
            // 关闭数据库连接   
            dbc.close() ;   
        }   
		return row;
	}
	
	public int selectID(HistoryRecord Re) {
		int flag = 0;
		PreparedStatement pstmt = null ;   
        DBConnect dbc = null; 
        String sql = "SELECT historyRecordID FROM history ";
        try{   
            // 连接数据库   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ;
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	if(rs.getInt("historyRecordID") == (Re.getHistoryRecordID())) {
            		flag = 1;
            		}
	            }
            rs.close() ; 
            pstmt.close() ;
            }catch (SQLException e){   
                System.out.println(e.getMessage());   
            }finally{   
                // 关闭数据库连接   
                dbc.close() ;   
            }
        return flag;
	}

}

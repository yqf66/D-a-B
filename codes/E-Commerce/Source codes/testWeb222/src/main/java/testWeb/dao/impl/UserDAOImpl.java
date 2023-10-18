package testWeb.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import testWeb.dao.userDAO;
import testWeb.db.DBConnect;
import testWeb.vo.UserInfo;

public class UserDAOImpl implements userDAO {

	@Override
	public int queryByUserInfo(UserInfo userinfo) throws Exception {
		// TODO Auto-generated method stub
		int flag=0;
		String sql="select * from userinfo where username=?";
		PreparedStatement pstmt=null;
		DBConnect dbc=null;
		
		try {
			dbc=new DBConnect();
			pstmt=dbc.getConnection().prepareStatement(sql);
			pstmt.setString(1, userinfo.getUsername());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("password").equals(userinfo.getPassword())) {
					flag=1;
				}
			}
			rs.close();
			pstmt.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbc.close();
		}
		return flag;
	}

}

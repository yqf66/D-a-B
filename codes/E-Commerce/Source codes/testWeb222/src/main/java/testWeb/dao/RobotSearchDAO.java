package testWeb.dao;

import testWeb.vo.UserInfo;

import java.util.ArrayList;

import testWeb.vo.Exploration;

public interface RobotSearchDAO {
	//public int RobotSearch(Exploration e,UserInfo u);
	public ArrayList<Exploration> RobotSearch(UserInfo user);
	public int UserSearch(UserInfo user);
}

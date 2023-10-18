package testWeb.dao;

import java.util.ArrayList;

import testWeb.vo.HistoryRecord;
import testWeb.vo.UserInfo;

public interface HistorySearchDAO {
	//public int HistorySearch(HistoryRecord r,UserInfo u);
	public ArrayList<HistoryRecord> HistorySearch(UserInfo user);
	public int UserSearch(UserInfo user);
}
